package Exercises.LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList list = new LinkedList();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            int num = Integer.parseInt(tokens[1]);
            switch (command) {
                case "Add":
                    list.add(num);
                    break;
                case "Remove":
                    list.remove(num);
                    break;
            }
        }

        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
