package Lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> locations = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String countries = tokens[1];
            String cities = tokens[2];

            locations.putIfAbsent(continent, new LinkedHashMap<>());
            locations.get(continent).putIfAbsent(countries, new ArrayList<>());
            locations.get(continent).get(countries).add(cities);
        }

        locations.forEach((continent, v) -> {
            System.out.println(continent + ":");
            v.forEach((countries, cities) ->
                    System.out.printf("  %s -> %s", countries, String.join(", ", cities))
            );
        });
    }
}
