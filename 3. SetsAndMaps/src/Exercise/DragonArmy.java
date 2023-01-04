package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    private static class Dragon {
        int damage;
        int health;
        int armor;

        Dragon(String damage, String health, String armor) {
            this.damage = parseDamage(damage);
            this.health = parseHealth(health);
            this.armor = parseArmor(armor);
        }

        private int parseArmor(String armor) {
            if (armor.equals("null")) {
                return 10;
            }
            return Integer.parseInt(armor);
        }

        private int parseHealth(String health) {
            if (health.equals("null")) {
                return 250;
            }
            return Integer.parseInt(health);
        }

        private int parseDamage(String damage) {
            if (damage.equals("null")) {
                return 45;
            }
            return Integer.parseInt(damage);
        }

        private int getDamage() {
            return this.damage;
        }

        private int getHealth() {
            return this.health;
        }

        private int getArmor() {
            return this.armor;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Dragon>> dragonsColonies = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String dragonType = data[0];
            String dragonName = data[1];
            String damage = data[2];
            String health = data[3];
            String armor = data[4];

            Map<String, Dragon> dragonsByName = dragonsColonies.get(dragonType);
            if (dragonsByName == null) {
                dragonsByName = new TreeMap<>();
            }

            Dragon dragon = new Dragon(damage, health, armor);
            dragonsByName.put(dragonName, dragon);
            dragonsColonies.put(dragonType, dragonsByName);
        }
        dragonsColonies.forEach((key, value) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n"
                    , key
                    , value.values().stream().mapToInt(Dragon::getDamage).average().orElse(0)
                    , value.values().stream().mapToInt(Dragon::getHealth).average().orElse(0)
                    , value.values().stream().mapToInt(Dragon::getArmor).average().orElse(0)
            );
            value.forEach((k, v) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n"
                    , k, v.getDamage(), v.getHealth(), v.getArmor()));
        });
    }
}
