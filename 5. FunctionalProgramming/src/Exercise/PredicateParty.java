package Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s"))
                .collect(Collectors.toList());

        String input;
        while (!"Party!".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String option = tokens[1];
            String parameter = tokens[2];

            switch (command) {
                case "Remove":
                    remove(getPredicate(option, parameter), guests);
                    break;
                case "Double":
                    addOneMore(getPredicate(option, parameter), guests);
                    break;
            }
        }

        Collections.sort(guests);
        String outPut = guests.isEmpty()
                ? "Nobody is going to the party!"
                : String.join(", ", guests) + " are going to the party!";

        System.out.println(outPut);
    }

    private static void remove(Predicate<String> predicate, List<String> guests) {
        guests.removeIf(predicate);
    }

    private static void addOneMore(Predicate<String> predicate, List<String> guests) {
        List<String> namesToAdd = new ArrayList<>();
        guests.stream().filter(predicate).forEach(namesToAdd::add);
        guests.addAll(namesToAdd);
    }

    private static Predicate<String> getPredicate(String option, String parameter) {
        Predicate<String> predicate = null;
        switch (option) {
            case "StartsWith":
                predicate = str -> str.startsWith(parameter);
                break;
            case "EndsWith":
                predicate = str -> str.endsWith(parameter);
                break;
            case "Length":
                predicate = str -> str.length() == Integer.parseInt(parameter);
                break;
        }
        return predicate;
    }
}
