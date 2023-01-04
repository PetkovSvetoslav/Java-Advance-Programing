import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            FileInputStream inputStream = new FileInputStream("D:\\Resources-StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
            Scanner scanner = new Scanner(inputStream);
            String s = scanner.nextLine();
            System.out.println(s);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
