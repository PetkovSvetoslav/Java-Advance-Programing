package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> venueConcerts = new LinkedHashMap<>();

        String regex = "(?<name>[A-Za-z\\s]+)\\s@(?<venue>[A-Za-z\\s]+)\\s(?<price>\\d+)\\s(?<count>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                String venue = matcher.group("venue");
                int price = Integer.parseInt(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));

                Map<String, Integer> incomeOfTheSingers = venueConcerts.get(venue);
                if (incomeOfTheSingers == null) {
                    incomeOfTheSingers = new LinkedHashMap<>();
                }

                Integer income = incomeOfTheSingers.get(name);
                if (income == null) {
                    income = 0;
                }
                incomeOfTheSingers.put(name, income + (price * count));
                venueConcerts.put(venue, incomeOfTheSingers);
            }
        }
        venueConcerts.forEach((k, v) -> {
            System.out.println(k);
            v.entrySet()
                    .stream()
                    .sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                    .forEach(s -> System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue()));
        });
    }
}
