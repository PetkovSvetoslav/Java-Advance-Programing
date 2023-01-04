import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SumOfCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coins = Arrays.stream(scanner.nextLine().substring(7).split(",\\s*"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = Integer.parseInt(scanner.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, sum);

        if (usedCoins != null) {
            int totalCoins = usedCoins.values().stream().mapToInt(i -> i).sum();
            System.out.println("Number of coins to take: " + totalCoins);

            usedCoins.forEach((k, v) -> System.out.println(v + " coin(s) with value " + k));
        } else System.out.println("Error");
    }

    private static Map<Integer, Integer> chooseCoins(int[] coins, int sum) {
        coins = Arrays.stream(coins).sorted().toArray();

        Map<Integer, Integer> coinsCounts = new LinkedHashMap<>();

        for (int i = coins.length - 1; i >= 0; i--) {
            int currentCoin = coins[i];
            int numberOfCoins = sum / currentCoin;

            if (numberOfCoins > 0) {
                coinsCounts.put(coins[i], numberOfCoins);
                sum %= currentCoin;
            } else if (sum == 0) {
                break;
            }
        }
        if (sum != 0) {
            return null;
        }
        return coinsCounts;
    }
}
