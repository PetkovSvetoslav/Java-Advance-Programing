package Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {

        try {
            FileInputStream inputStream = new FileInputStream("input.txt");
            FileOutputStream outputStream = new FileOutputStream("output.txt");
            PrintWriter writer = new PrintWriter(outputStream);

            Set<Character> punctuations = new HashSet<>();
            punctuations.add(',');
            punctuations.add('.');
            punctuations.add('!');
            punctuations.add('?');

            int oneByte = inputStream.read();
            while (oneByte != -1) {
                char symbol = (char) oneByte;
                if (!punctuations.contains(symbol)) {
                    writer.print(symbol);
                }
                oneByte = inputStream.read();
            }

            writer.close();
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }
}
