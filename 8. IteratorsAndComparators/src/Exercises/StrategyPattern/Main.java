package Exercises.StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> byName = new TreeSet<>(new ComparatorByName());
        Set<Person> byAge = new TreeSet<>(new ComparatorByAge());

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] personData = scanner.nextLine().split("\\s+");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);

            Person person = new Person(name, age);
            byName.add(person);
            byAge.add(person);
        }

        for (Person person : byName) {
            System.out.println(person);
        }

        for (Person person : byAge) {
            System.out.println(person);
        }

    }
}
