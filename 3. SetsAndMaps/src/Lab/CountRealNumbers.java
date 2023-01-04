package Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {

        double[] values = Arrays.stream(new Scanner(System.in).nextLine()
                .split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> numbers = new LinkedHashMap<>();
        for (double num : values) {
            Integer count = numbers.get(num);
            if (count == null) {
                count = 0;
            }
            numbers.put(num, count + 1);
        }

        numbers.forEach((k, v) -> System.out.printf("%.1f -> %d%n", k, v));
    }
}
