package Exercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    //collect all new fibonacci numbers
    private static long[] memorization;

    public static void main(String[] args) {

        int n = new Scanner(System.in).nextInt();
        memorization = new long[n + 1];
        System.out.println(fibonacci(n));
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memorization[n] != 0) {
            return memorization[n];
        }

        memorization[n] = fibonacci(n - 1) + fibonacci(n - 2);

        return memorization[n];
    }
}
