package Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {

        Map<Character, Integer> charactersCount = new TreeMap<>();

        String line = new Scanner(System.in).nextLine();
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);

            Integer count = charactersCount.get(symbol);
            if (count == null) {
                count = 0;
            }
            charactersCount.put(symbol, count + 1);
        }

        charactersCount.forEach((k, v) -> System.out.printf("%c: %d time/s%n", k, v));
    }
}
