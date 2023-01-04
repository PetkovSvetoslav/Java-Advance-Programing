package Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int toNum = Integer.parseInt(scanner.nextLine());
        Set<Integer> divisors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(HashSet::new));

        Predicate<Integer> isDivisible = num -> {
            for (Integer divisor : divisors) {
                if (num % divisor != 0) {
                    return false;
                }
            }
            return true;
        };

        List<Integer> numbers =
                IntStream.range(1, toNum + 1)
                        .filter(isDivisible::test)
                        .boxed()
                        .collect(Collectors.toList());

        System.out.println(listAsString(numbers, " "));
    }

    public static String listAsString(List<Integer> list, String delimiter) {
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(delimiter));
    }
}
