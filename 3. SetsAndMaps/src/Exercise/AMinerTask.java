package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> yield = new LinkedHashMap<>();

        String resource;
        while (!"stop".equals(resource = scanner.nextLine())) {
            int currentQuantity = Integer.parseInt(scanner.nextLine());

            Integer quantity = yield.get(resource);
            if (quantity == null) {
                quantity = 0;
            }
            yield.put(resource, quantity + currentQuantity);
        }

        yield.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
