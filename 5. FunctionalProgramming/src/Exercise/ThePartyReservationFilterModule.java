package Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Predicate<String>> predicateMap = new HashMap<>();

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input;
        while (!"Print".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(";");

            String command = tokens[0];
            String filterType = tokens[1];
            String parameter = tokens[2];
            switch (command) {
                case "Add filter":
                    predicateMap.put(filterType + parameter,
                            getPredicate(filterType, parameter));
                    break;
                case "Remove filter":
                    predicateMap.remove(filterType + parameter);
                    break;
            }
        }
        filterTheGuests(predicateMap, guests);

        System.out.println(String.join(" ", guests));
    }

    private static void filterTheGuests(Map<String, Predicate<String>> predicateMap, List<String> names) {
        names.removeIf(g -> {
            for (Predicate<String> predicate : predicateMap.values()) {
                if (predicate.test(g)) {
                    return true;
                }
            }
            return false;
        });
    }

    private static Predicate<String> getPredicate(String filterType, String parameter) {
        Predicate<String> predicate = null;

        switch (filterType) {
            case "Starts with":
                predicate = str -> str.startsWith(parameter);
                break;
            case "Ends with":
                predicate = str -> str.endsWith(parameter);
                break;
            case "Length":
                predicate = str -> str.length() == Integer.parseInt(parameter);
                break;
            case "Contains":
                predicate = str -> str.contains(parameter);
                break;
        }
        return predicate;
    }
}
