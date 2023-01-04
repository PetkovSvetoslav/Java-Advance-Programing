package Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] number = Arrays.stream(scanner.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .filter(SortEvenNumbers::isEven)
                .toArray();


        System.out.println(formatArray(number, ", "));

        Arrays.sort(number);
        System.out.println(formatArray(number, ", "));
    }

    private static String formatArray(int[] arr, String delimiter) {
        return Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(delimiter));
    }

    private static boolean isEven(int number) {
        return isDivisibleBy(number, 2);
    }

    private static boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }
}
