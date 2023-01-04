package Lab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {

    private static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Function<String, Person> parsePerson = str -> {
            String[] tokens = str.split(", ");
            return new Person(tokens[0], Integer.parseInt(tokens[1]));
        };

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            people.add(parsePerson.apply(scanner.nextLine()));
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        people = condition.equals("older")
                ? filterPeople(people, p -> p.getAge() >= age)
                : filterPeople(people, p -> p.getAge() <= age);

        System.out.println(formatPeople(people, getFormatterFunction(format), System.lineSeparator()));
    }

    private static Function<Person, String> getFormatterFunction(String format) {
        switch (format) {
            case "name":
                return Person::getName;
            case "age":
                return p -> String.valueOf(p.getAge());
            case "name age":
                return p -> p.getName() + " - " + p.getAge();
            default:
                throw new IllegalStateException("Unknown format type " + format);
        }
    }

    private static String formatPeople(Collection<Person> people,
                                       Function<Person, String> formatter,
                                       String delimiter) {
        return people
                .stream()
                .map(formatter)
                .collect(Collectors.joining(delimiter));
    }

    private static List<Person> filterPeople(Collection<Person> people, Predicate<Person> predicate) {
        return people
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
