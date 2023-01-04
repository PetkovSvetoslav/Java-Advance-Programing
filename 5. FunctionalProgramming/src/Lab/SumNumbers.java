package Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Function<String, IntStream> getIntStream = str ->
                Arrays.stream(str.split(", ")).mapToInt(Integer::parseInt);

        Function<String, Integer> getSum = str -> getIntStream.apply(str).sum();

        Function<String, Long> getCount = str -> getIntStream.apply(str).count();

        System.out.println("Count = " + getCount.apply(line));
        System.out.println("Sum = " + getSum.apply(line));
    }
}
