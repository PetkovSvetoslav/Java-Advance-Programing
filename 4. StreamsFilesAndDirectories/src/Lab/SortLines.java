package Lab;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) {

        try {
            List<String> lines = Files.readAllLines(Paths.get("input.txt"))
                    .stream()
                    .sorted(String::compareTo)
                    .collect(Collectors.toList());

            Files.write(Paths.get("output.txt"), lines);


        } catch (IOException exception){
            System.err.println(exception);
        }
    }
}
