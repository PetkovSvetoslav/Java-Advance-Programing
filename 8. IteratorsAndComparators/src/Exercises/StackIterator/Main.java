package Exercises.StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomStack stack = new CustomStack();

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(",*\\s+,*");
            String command = tokens[0];
            switch (command) {
                case "Push":
                    for (int i = 1; i < tokens.length; i++) {
                        int element = Integer.parseInt(tokens[i]);
                        stack.push(element);
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
            }
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }

        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
