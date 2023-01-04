package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {

        Function<List<Integer>, Integer> lastMinElement =
                list -> list.lastIndexOf(list.stream().min(Integer::compareTo).orElse(-1));

        List<Integer> numbers = Arrays.stream(new Scanner(System.in).nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(lastMinElement.apply(numbers));
    }
}
