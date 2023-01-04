package Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream("input.txt");
            int oneByte = inputStream.read();
            while (oneByte != -1) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = inputStream.read();
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }

    }
}
