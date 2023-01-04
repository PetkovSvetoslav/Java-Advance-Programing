package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PoisonousPlants3 {
    public static void main(String[] args) {
        //Someone else's solution (just wanted to understand the logic)
        //1/12/2021 - I can't debug this code. When i try the stack doesn't work and the result is 0
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());
        int[] plants = new int[n];
        for (int i = 0; i < n; i++) {
            plants[i] = scanner.nextInt();
        }

        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        indexes.push(0);

        int[] days = new int[n];
        int maxSpan = 0;
        for (int i = 1; i < n; i++) {
            int maxDays = 0;
            while (indexes.size() > 0 && plants[indexes.peek()] >= plants[i]) {
                maxDays = Math.max(maxDays, days[indexes.pop()]);
            }

            if (indexes.size() > 0) {
                days[i] = maxDays + 1;
                if (days[i] > maxSpan) {
                    maxSpan = days[i];
                }
            }

            indexes.push(i);
        }
        System.out.println(maxSpan);
    }
}
/*
Input:
25
6 5 8 4 7 10 9 2 3 11 6 9 8 7 5 4 13 10 8 9 6 15 4 3 8
 */
