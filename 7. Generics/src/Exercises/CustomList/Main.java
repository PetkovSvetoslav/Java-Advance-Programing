package Exercises.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Add": {
                    String element = tokens[1];
                    list.add(element);
                }
                break;
                case "Remove": {
                    int index = Integer.parseInt(tokens[1]);
                    list.remove(index);
                }
                break;
                case "Contains": {
                    String element = tokens[1];
                    System.out.println(list.contains(element));
                }
                break;
                case "Swap": {
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    list.swap(firstIndex, secondIndex);
                }
                break;
                case "Greater": {
                    String element = tokens[1];
                    System.out.println(list.countGreaterThan(element));
                }
                break;
                case "Max": {
                    System.out.println(list.getMax());
                }
                break;
                case "Min": {
                    System.out.println(list.getMin());
                }
                break;
                case "Print": {
                    for (String s : list) {
                        System.out.println(s);
                    }

                }
                case "Sort": {
                    Sorter.sort(list);
                }
                break;
            }
            input = scanner.nextLine();
        }
    }
}
