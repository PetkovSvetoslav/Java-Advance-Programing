package Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        int divisor = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> isNotDivisibleBy = n -> n % divisor != 0;

        numbers.stream().filter(isNotDivisibleBy).forEach(n -> System.out.print(n + " "));
    }
}
