package Exercise;

import java.util.*;

public class PopulationCounter {
    //Keeps the name of the city and its population
    private static class City {
        String city;
        Long population;

        City(String city, long population) {
            this.city = city;
            this.population = population;
        }

        private String getCity() {
            return this.city;
        }

        private Long getPopulation() {
            return this.population;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<City>> countryPopulation = new LinkedHashMap<>();

        String input;
        while (!"report".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);

            City c = new City(city, population);
            List<City> cityPopulation = countryPopulation.get(country);
            if (cityPopulation == null) {
                cityPopulation = new ArrayList<>();
            }
            cityPopulation.add(c);
            countryPopulation.putIfAbsent(country, cityPopulation);
        }

        countryPopulation
                .entrySet()
                .stream()
                .sorted((c1, c2) -> Long.compare(c2.getValue().stream().mapToLong(City::getPopulation).sum(), c1.getValue().stream().mapToLong(City::getPopulation).sum()))
                .forEach(c -> {
                    System.out.printf("%s (total population: %d)%n", c.getKey(), c.getValue().stream().mapToLong(City::getPopulation).sum());
                    c.getValue()
                            .stream()
                            .sorted((p1, p2) -> Long.compare(p2.getPopulation(), p1.getPopulation()))
                            .forEach(p -> System.out.printf("=>%s: %d%n", p.getCity(), p.getPopulation()));
                });
    }
}
