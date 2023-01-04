package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            queue.offer(num);
        }

        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            int minNum = queue.peek();
            for (Integer num : queue) {
                if (num == x) {
                    System.out.println("true");
                    return;
                }
                if (minNum > num) {
                    minNum = num;
                }
            }
            System.out.println(minNum);
        }
    }
}
