package Lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {

        try {
            String path = "D:\\SoftUni\\Java-Advanced\\StreamsFilesAndDirectories\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
            File root = new File(path);

            Deque<File> dirs = new ArrayDeque<>();
            dirs.offer(root);
            int counter = 0;
            while (!dirs.isEmpty()) {
                File current = dirs.poll();
                File[] nestedFiles = current.listFiles();

                for (File nestedFile : nestedFiles) {
                    if (nestedFile.isDirectory()) {
                        dirs.offer(nestedFile);
                    }
                }
                counter++;
                System.out.println(current.getName());
            }
            System.out.println(counter + " folders");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
