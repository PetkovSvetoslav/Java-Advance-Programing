package Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {

        Comparator<Integer> comparator = (n1, n2) -> {
            if (n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;
            }

            if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            }

            return n1.compareTo(n2);
        };

        List<Integer> numbers = Arrays.stream(new Scanner(System.in).nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .sorted(comparator)
                .collect(Collectors.toList());

        numbers.forEach(n -> System.out.print(n + " "));
    }
}
