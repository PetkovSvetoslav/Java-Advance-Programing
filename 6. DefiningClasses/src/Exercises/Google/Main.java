package Exercises.Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> peoplesData = new HashMap<>();

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");
            String name = data[0];

            Person person = peoplesData.get(name);
            if (person == null){
                person = new Person();
            }

            String type = data[1];
            switch (type) {
                case "company": {
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                }
                break;
                case "pokemon": {
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

                    List<Pokemon> pokemonList = person.getPokemons();
                    pokemonList.add(pokemon);
                }
                break;
                case "parents": {
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Parent parent = new Parent(parentName, parentBirthday);

                    List<Parent> parents = person.getParents();
                    parents.add(parent);
                }
                break;
                case "children": {
                    String kidName = data[2];
                    String kidBirthday = data[3];
                    Child child = new Child(kidName, kidBirthday);

                    List<Child> children = person.getChildren();
                    children.add(child);

                }
                break;
                case "car": {
                    String model = data[2];
                    int speed = Integer.parseInt(data[3]);
                    Car car = new Car(model, speed);

                    person.setCar(car);
                }
                break;
            }
            peoplesData.put(name, person);
        }

        String person = scanner.nextLine();
        System.out.println(person);
        System.out.println(peoplesData.get(person));
    }
}
