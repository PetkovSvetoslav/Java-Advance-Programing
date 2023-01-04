package Lab;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("input.txt");
        Scanner scanner = new Scanner(inputStream);

        FileWriter writer = new FileWriter("output.txt");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()){
                int num = scanner.nextInt();
                writer.write(String.valueOf(num));
                writer.write(System.lineSeparator());
            }
            scanner.next();
        }
        writer.flush();
        writer.close();
    }
}
