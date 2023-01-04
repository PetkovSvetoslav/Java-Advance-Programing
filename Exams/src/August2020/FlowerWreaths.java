package August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Queue
        ArrayDeque<Integer> lilies = Arrays.stream(scanner.nextLine().split(",\\s*"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //Stack
        ArrayDeque<Integer> roses = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s*"))
                .map(Integer::parseInt)
                .forEach(roses::push);

        //decreasing lilies with 2 if the sum is more than 15
        //store the sum if it is lesser than 15
        int wreathsCount = 0;
        int leftFlowers = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int currentLilies = lilies.poll();
            int currentRoses = roses.pop();

            int sum = currentLilies + currentRoses;
            while (sum > 15) {
                currentLilies -= 2;
                sum = currentLilies + currentRoses;
            }
            if (sum < 15) {
                leftFlowers += sum;
            } else {
                wreathsCount++;
            }
        }

        wreathsCount += leftFlowers / 15;

        if (wreathsCount < 5) {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreathsCount);
        } else {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreathsCount);
        }
    }
}
