import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {

        int[] arr = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = sumOfElements(arr, 0);
        System.out.println(sum);

        /*
        int reversedSum = reversedSumOfElements(arr, arr.length - 1);
        System.out.println(reversedSum);
        */
    }

    private static int sumOfElements(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        return arr[index] + sumOfElements(arr, index + 1);
    }
    /*
    private static int reversedSumOfElements(int[] arr, int index) {
        if (index < 0) {
            return 0;
        }
        return arr[index] + reversedSumOfElements(arr, index - 1);
    }
     */
}
