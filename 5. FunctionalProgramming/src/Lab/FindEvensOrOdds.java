package Lab;

import java.io.InputStream;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = scanner.nextInt();
        int end = scanner.nextInt();
        scanner.nextLine();

        List<Integer> numbers = IntStream
                .range(start, end + 1)
                .boxed()
                .collect(Collectors.toList());

        String type = scanner.nextLine();
        numbers = type.equals("even")
                ? filterNumbers(numbers, FindEvensOrOdds::isEven)
                : filterNumbers(numbers, FindEvensOrOdds::isOdd);

        System.out.println(listAsString(numbers, " "));
    }

    private static String listAsString(List<Integer> list, String delimiter) {
        return list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(delimiter));
    }

    private static List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    private static boolean isOdd(int number) {
        return !isEven(number);
    }

    private static boolean isEven(int number) {
        return isDivisibleBy(number, 2);
    }

    private static boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }
}
