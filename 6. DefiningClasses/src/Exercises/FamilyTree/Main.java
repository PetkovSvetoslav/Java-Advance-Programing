package Exercises.FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String mainPerson = reader.readLine();

        //people information (name birthday)
        List<Person> people = new ArrayList<>();

        //people's kinship (the children of a parent)
        Map<String, List<String>> parent_Children = new LinkedHashMap<>();

        String line;
        while (!"End".equals(line = reader.readLine())) {
            if (line.contains("-")) {
                String[] tokens = line.split("\\s*-\\s*");
                String parentID = tokens[0];
                String childrenID = tokens[1];

                parent_Children.putIfAbsent(parentID, new ArrayList<>());
                parent_Children.get(parentID).add(childrenID);
            } else {
                String[] tokens = line.split("\\s+");
                String name = tokens[0] + " " + tokens[1];
                String birthday = tokens[2];

                Person person = new Person(name, birthday);
                people.add(person);
            }
        }

        //By the data in kinship searches in the List<People> to make connection between people
        //Adds children to each parent
        parent_Children.forEach((parentID, children) -> {
            Person parent = findPerson(people, parentID);

            children.stream()
                    .map(childID -> findPerson(people, childID))
                    .forEach(parent::addChild);
        });

        Person forPerson = findPerson(people, mainPerson);
        System.out.println(getFamilyTree(forPerson));
    }

    public static String getFamilyTree(Person person) {
        return new StringBuilder()
                .append(person.toString()).append(System.lineSeparator())
                .append("Parents:").append(System.lineSeparator())
                .append(person.getParents()
                        .stream()
                        .map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .append(person.getParents().isEmpty() ? "" : System.lineSeparator())
                .append("Children:").append(System.lineSeparator())
                .append(person.getChildren()
                        .stream()
                        .map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .toString();
    }


    //Searching int the List<Person> by personID (name or birthday)
    public static Person findPerson(List<Person> people, String personID) {
        return people.stream()
                .filter(p -> p.getName().equals(personID) || p.getBirthday().equals(personID))
                .findFirst()
                .orElseThrow();
    }
}
