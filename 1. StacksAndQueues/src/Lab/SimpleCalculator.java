package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        String[] line = scanner.nextLine().split("\\s+");

        for (int i = 0; i < line.length; i++) {
            String token = line[i];
            if (Character.isDigit(token.codePointAt(0))) {
                numbers.push(Integer.parseInt(token));
            } else {
                int leftNum = numbers.peek();
                int rightNum = Integer.parseInt(line[++i]);

                int result = token.equals("+")
                        ? leftNum + rightNum
                        : leftNum - rightNum;
                numbers.push(result);
            }
        }
        System.out.println(numbers.peek());
    }
}
