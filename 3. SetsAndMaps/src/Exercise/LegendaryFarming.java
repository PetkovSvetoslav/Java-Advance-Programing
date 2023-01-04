package Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> legendaryMaterials = new HashMap<>();
        legendaryMaterials.put("shards", 0);
        legendaryMaterials.put("fragments", 0);
        legendaryMaterials.put("motes", 0);
        Map<String, Integer> junkMaterials = new TreeMap<>();

        String item = "";
        boolean flag = false;
        while (!flag) {
            int currentQuantity = scanner.nextInt();
            String material = scanner.next().toLowerCase();
            Integer quantity;

            switch (material) {
                case "shards":
                    if (collectsMaterialsToObtainAnItem(legendaryMaterials, currentQuantity, material)) {
                        item = "Shadowmourne";
                        flag = true;
                    }
                    break;
                case "fragments":
                    if (collectsMaterialsToObtainAnItem(legendaryMaterials, currentQuantity, material)) {
                        item = "Valanyr";
                        flag = true;
                    }
                    break;
                case "motes":
                    if (collectsMaterialsToObtainAnItem(legendaryMaterials, currentQuantity, material)) {
                        item = "Dragonwrath";
                        flag = true;
                    }
                    break;
                default:
                    quantity = junkMaterials.get(material);
                    if (quantity == null) {
                        quantity = 0;
                    }
                    junkMaterials.put(material, currentQuantity + quantity);
                    break;
            }
        }
        System.out.println(item + " obtained!");
        legendaryMaterials
                .entrySet()
                .stream()
                .sorted((m1, m2) -> {
                    int result = m2.getValue() - m1.getValue();
                    if (result == 0) {
                        result = m1.getKey().compareTo(m2.getKey());
                    }
                    return result;
                })
                .forEach(m -> System.out.println(m.getKey() + ": " + m.getValue()));

        junkMaterials.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private static boolean collectsMaterialsToObtainAnItem(Map<String, Integer> legendaryMaterials, int currentQuantity, String material) {
        int quantity = legendaryMaterials.get(material);
        if (currentQuantity + quantity >= 250) {
            legendaryMaterials.put(material, (currentQuantity + quantity) - 250);
            return true;
        } else {
            legendaryMaterials.put(material, currentQuantity + quantity);
        }
        return false;
    }
}
