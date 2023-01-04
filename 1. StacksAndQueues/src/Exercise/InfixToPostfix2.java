package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] tokens = scanner.nextLine().split("\\s+");

        for (String token : tokens) {
            switch (token) {
                case "+", "-", "*", "/" -> {
                    while (!stack.isEmpty() && getPrecedence(token) <= getPrecedence(stack.peek())) {
                        queue.offer(stack.pop());
                    }
                    stack.push(token);
                }
                case "(" -> stack.push(token);
                case ")" -> {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        queue.offer(stack.pop());
                    }
                    stack.pop();
                }
                default -> queue.offer(token);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek().equals("(")) {
                System.out.println("Invalid expression");
            } else {
                queue.offer(stack.pop());
            }
        }
        queue.forEach(c -> System.out.print(c + " "));
    }

    private static int getPrecedence(String operator) {
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } else {
            return -1;
        }
    }
}
