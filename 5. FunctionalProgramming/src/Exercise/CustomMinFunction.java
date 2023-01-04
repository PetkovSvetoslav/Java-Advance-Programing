package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {

        Function<int[], Integer> smallestNumber =
                nums -> Arrays.stream(nums).min().orElse(0);

        int[] numbers = Arrays.stream(new Scanner(System.in).nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(smallestNumber.apply(numbers));
    }
}
