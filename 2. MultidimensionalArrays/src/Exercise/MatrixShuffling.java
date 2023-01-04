package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = readMatrix(scanner, rows, columns);

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            if (isValid(input, rows, columns, tokens)) {
                int row1 = Integer.parseInt(tokens[1]);
                int column1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int column2 = Integer.parseInt(tokens[4]);

                String s1 = matrix[row1][column1];
                String s2 = matrix[row2][column2];
                matrix[row1][column1] = s2;
                matrix[row2][column2] = s1;
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            Arrays.stream(strings)
                    .forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }

    private static boolean isValid(String input, int rows, int columns, String[] tokens) {
        if (tokens.length != 5) {
            return false;
        }

        String command = tokens[0];

        if (!command.equals("swap")) {
            return false;
        }
        int row1 = Integer.parseInt(tokens[1]);
        int column1 = Integer.parseInt(tokens[2]);
        int row2 = Integer.parseInt(tokens[3]);
        int column2 = Integer.parseInt(tokens[4]);

        if ((row1 > rows || row1 < 0) || (row2 > rows || row2 < 0)
                || (column1 > columns || column1 < 0) || (column2 > columns || column2 < 0)) {
            return false;
        }
        return true;
    }

    private static String[][] readMatrix(Scanner scanner, int rows, int columns) {
        String[][] matrix = new String[rows][columns];
        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = tokens[column];
            }
        }
        return matrix;
    }
}
