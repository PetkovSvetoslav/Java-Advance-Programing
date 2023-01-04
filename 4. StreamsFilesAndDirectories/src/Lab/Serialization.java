package Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
    public static void main(String[] args) throws Exception {

        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("mouse");
        stringList.add("sunrise");

        ObjectOutputStream outputStream =
                new ObjectOutputStream(new FileOutputStream("output.txt"));

        outputStream.writeObject(stringList);

        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("output.txt"));

        List<String> readStrings = (List<String>) inputStream.readObject();
        
        for (String string : readStrings) {
            System.out.println(string);
        }
    }
}
