package Lab;

import java.io.File;

public class NestedFolders2 {

    public static int folderCount = 1;

    public static void main(String[] args) {

        try {
            String fileName = "D:\\SoftUni\\Java-Advanced\\StreamsFilesAndDirectories\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
            File file = new File(fileName);

            dfs(file);

            System.out.println(folderCount + " folders");
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
    public static void dfs(File file) {
        folderCount++;
        for (File f : file.listFiles()) {
            if (f.isDirectory()){
                dfs(f);
            }
        }

        System.out.println(file.getName());
    }
}
