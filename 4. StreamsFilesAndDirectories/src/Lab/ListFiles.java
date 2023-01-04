package Lab;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles {
    public static void main(String[] args) {
        try{
            File file = new File("D:\\SoftUni\\Java-Advanced\\StreamsFilesAndDirectories\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

            File[] innerFiles = file.listFiles();

            PrintWriter writer = new PrintWriter("output.txt");
            for (File f : innerFiles) {
                if (!f.isDirectory()){
                    writer.printf("%s: [%d]%n",f.getName(), f.length());
                }
            }
            writer.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
