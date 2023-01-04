package Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        int divisor = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> isDivisibleBy = n -> n % divisor == 0;

        numbers.removeIf(isDivisibleBy);

        numbers.forEach(n -> System.out.print(n + " "));

    }
}
