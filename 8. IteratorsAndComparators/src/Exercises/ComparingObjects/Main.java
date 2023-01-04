package Exercises.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String[] personData = line.split("\\s+");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            String town = personData[2];

            Person person = new Person(name, age, town);
            people.add(person);
        }
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        Person personToCompare = people.get(index);

        int equal = 0;
        int different = 0;
        int allPeople = people.size();

        for (int i = 0; i < allPeople; i++) {
            Person person = people.get(i);
            if (person.compareTo(personToCompare) == 0) {
                equal++;
            } else {
                different++;
            }
        }
        if (equal == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(equal + " " + different + " " + allPeople);
        }
    }
}
