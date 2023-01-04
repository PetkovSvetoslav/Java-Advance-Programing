package February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Queue
        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //Stack
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBox::push);

        int calmedItems = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstItem = firstBox.peek();
            int secondItem = secondBox.pop();

            int sum = firstItem + secondItem;
            if (sum % 2 == 0) {
                calmedItems += sum;
                firstBox.poll();
            } else {
                firstBox.offer(secondItem);
            }
        }
        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        }

        if (secondBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (calmedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + calmedItems);
        } else {
            System.out.println("Poor prey... Value: " + calmedItems);
        }
    }
}
