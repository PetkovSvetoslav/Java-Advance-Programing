package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<int[]> addOne = nums -> Arrays.stream(nums).map(n -> n + 1).toArray();
        UnaryOperator<int[]> multiplyByTwo = nums -> Arrays.stream(nums).map(n -> n * 2).toArray();
        UnaryOperator<int[]> subtractOne = nums -> Arrays.stream(nums).map(n -> n - 1).toArray();
        Function<int[], String> arrayAsString = nums -> Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(" "));

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command;
        while (!"end".equals(command = scanner.nextLine())) {
            switch (command) {
                case "add":
                    numbers = addOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyByTwo.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractOne.apply(numbers);
                    break;
                case "print":
                    System.out.println(arrayAsString.apply(numbers));
                    break;
            }
        }
    }
}
