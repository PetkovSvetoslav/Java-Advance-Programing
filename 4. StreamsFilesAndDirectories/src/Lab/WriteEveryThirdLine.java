package Lab;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        int lineCounter = 1;
        while (line != null) {

            if (lineCounter % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }
            lineCounter++;
            line = reader.readLine();
        }

        writer.close();
    }
}
