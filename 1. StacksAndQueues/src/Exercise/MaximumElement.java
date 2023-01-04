package Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] command = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            switch (command[0]) {
                case 1:
                    stack.push(command[1]);
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case 3:
                    if (stack.isEmpty()) {
                        System.out.println(0);
                    } else {
                        int maxNum = stack.peek();
                        for (Integer num : stack) {
                            if (num > maxNum) {
                                maxNum = num;
                            }
                        }
                        System.out.println(maxNum);
                    }
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
