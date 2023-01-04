package June2020;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> bombs = new HashMap<>();
        bombs.put(40, "Datura Bombs");
        bombs.put(60, "Cherry Bombs");
        bombs.put(120, "Smoke Decoy Bombs");

        Map<String, Integer> bombsCount = new TreeMap<>();
        bombsCount.put("Cherry Bombs", 0);
        bombsCount.put("Datura Bombs", 0);
        bombsCount.put("Smoke Decoy Bombs", 0);

        //Queue
        ArrayDeque<Integer> bombEffects = Arrays.stream(scanner.nextLine().split(",\\s*"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //Stack
        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s*"))
                .map(Integer::parseInt)
                .forEach(bombCasings::push);

        boolean filledTheBombPouch = false;

        while (!bombEffects.isEmpty() && !bombCasings.isEmpty() && !filledTheBombPouch) {
            filledTheBombPouch = true;
            int effect = bombEffects.poll();
            int casing = bombCasings.pop();

            int sum = effect + casing;

            while (!bombs.containsKey(sum)) {
                casing -= 5;
                sum = effect + casing;
                if (sum < 40 && casing <= 0) {
                    break;
                }
            }

            String bomb = bombs.get(sum);
            if (bomb != null) {
                int count = bombsCount.get(bomb);
                bombsCount.put(bomb, count + 1);
            }

            for (Integer count : bombsCount.values()) {
                if (count < 3) {
                    filledTheBombPouch = false;
                    break;
                }
            }
        }

        if (filledTheBombPouch) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        //Print bomb effects
        String bombEffectsAsString = bombEffects.isEmpty()
                ? "empty"
                : bombEffects.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        
        System.out.println("Bomb Effects: " + bombEffectsAsString);

        //Print bomb casings
        String bombCasingsAsString = bombCasings.isEmpty()
                ? "empty"
                : bombCasings.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println("Bomb Casings: " + bombCasingsAsString);

        //Print all bombs and their count
        bombsCount.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
