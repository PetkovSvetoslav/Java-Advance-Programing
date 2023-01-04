package Exercises.CatLady_Inheritance;

//3/11/2021 - Shortly after I understood what inheritance is

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Cat> catsByName = new HashMap<>();

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] catData = line.split("\\s+");
            String breed = catData[0];
            String name = catData[1];

            Cat cat = null;
            switch (breed) {
                case "Siamese":
                    double earSize = Double.parseDouble(catData[2]);
                    cat = new Siamese(name, earSize);

                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(catData[2]);
                    cat = new Cymric(name, furLength);

                    break;
                case "StreetExtraordinaire":
                    double decibelsOfMeows = Double.parseDouble(catData[2]);
                    cat = new StreetExtraordinaire(name, decibelsOfMeows);

                    break;
            }
            catsByName.put(name, cat);
        }

        String wantedCat = reader.readLine();
        System.out.println(catsByName.get(wantedCat));
    }
}
