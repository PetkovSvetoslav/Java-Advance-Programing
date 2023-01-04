package Exercises.OpinionPoll;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Comparator<Person> personComparator = Comparator.comparing(Person::getName);

        Set<Person> people = new TreeSet<>(personComparator);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream().filter(p -> p.getAge() > 30).forEach(System.out::println);
    }
}
