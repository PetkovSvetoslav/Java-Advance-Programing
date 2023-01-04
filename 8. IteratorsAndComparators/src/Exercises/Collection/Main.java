package Exercises.Collection;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator listyIterator = new ListyIterator(
                Arrays.stream(scanner.nextLine().split("\\s+"))
                        .skip(1)
                        .collect(Collectors.toList()));

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    try {
                        for (String s : listyIterator) {
                            System.out.print(s + " ");
                        }
                        System.out.println();
                    } catch (IllegalStateException exception){
                        System.out.println(exception.getMessage());
                    }
                    break;
            }
        }
    }
}
