import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {

        int num = new Scanner(System.in).nextInt();

        long result = factorial(num);
        System.out.println(result);
    }

    private static long factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}
