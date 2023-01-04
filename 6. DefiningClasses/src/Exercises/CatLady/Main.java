package Exercises.CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Cat> cats = new HashMap<>();

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] catData = line.split("\\s+");
            String breed = catData[0];
            String name = catData[1];
            double parameter = Double.parseDouble(catData[2]);

            Cat cat = new Cat(breed, name, parameter);
            cats.put(name, cat);
        }
        String name = reader.readLine();
        System.out.println(cats.get(name));
    }
}
