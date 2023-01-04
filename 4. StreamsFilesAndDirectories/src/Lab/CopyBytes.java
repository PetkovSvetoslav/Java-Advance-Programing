package Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        PrintWriter writer = new PrintWriter(outputStream);
        int oneByte = inputStream.read();
        while (oneByte >= 0) {
            if (oneByte == 10 || oneByte == 32) {
                writer.print((char) oneByte);
            } else {
                writer.print(oneByte);
            }
            oneByte = inputStream.read();
        }

        writer.close();

        inputStream.close();
    }
}
