package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            stack.push(num);
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            int smallestNum = stack.peek();
            for (Integer num : stack) {
                if (num == x) {
                    System.out.println("true");
                    return;
                }
                if (smallestNum > num) {
                    smallestNum = num;
                }
            }
            System.out.println(smallestNum);
        }
    }
}
