package Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReverseAndExclude2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BiPredicate<Integer, Integer> isNotDivisibleBy = (n, d) -> (n % d) != 0;
        Function<List<Integer>, String> arrayAsString =
                nums -> nums.stream().map(String::valueOf).collect(Collectors.joining(" "));

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(numbers);
        int divisor = Integer.parseInt(scanner.nextLine());

        numbers = numbers.stream().filter(n -> isNotDivisibleBy.test(n, divisor)).collect(Collectors.toList());

        System.out.println(arrayAsString.apply(numbers));
    }
}
