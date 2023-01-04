package December2020;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> cookingTable = new HashMap<>();
        cookingTable.put(25, "Bread");
        cookingTable.put(50, "Cake");
        cookingTable.put(75, "Pastry");
        cookingTable.put(100, "Fruit Pie");

        Map<String, Integer> amountOfFood = new LinkedHashMap<>();
        amountOfFood.put("Bread", 0);
        amountOfFood.put("Cake", 0);
        amountOfFood.put("Fruit Pie", 0);
        amountOfFood.put("Pastry", 0);

        //Queue
        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //Stack
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();

            int sum = liquid + ingredient;
            String food = cookingTable.get(sum);
            if (food != null) {
                amountOfFood.put(food, amountOfFood.get(food) + 1);
            } else {
                ingredients.push(ingredient + 3);
            }
        }

        if (hasCookedEachMeal(amountOfFood)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        System.out.println("Liquids left: " + getElementsInfo(liquids));
        System.out.println("Ingredients left: " + getElementsInfo(ingredients));

        amountOfFood.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ? "none"
                : deque
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private static boolean hasCookedEachMeal(Map<String, Integer> amountOfFood) {
        return amountOfFood
                .values()
                .stream()
                .noneMatch(c -> c == 0);
    }
}
