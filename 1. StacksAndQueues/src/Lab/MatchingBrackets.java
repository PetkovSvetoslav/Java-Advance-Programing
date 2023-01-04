package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> indexOfBrackets = new ArrayDeque<>();
        String line = scanner.nextLine();

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (symbol == '(') {
                indexOfBrackets.push(i);
            } else if (symbol == ')') {
                int fromIndex = indexOfBrackets.pop();
                String expression = line.substring(fromIndex, i + 1);
                System.out.println(expression);
            }
        }
    }
}
