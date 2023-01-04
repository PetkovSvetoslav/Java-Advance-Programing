package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndColumns = readArray(scanner, ",\\s+");

        int rows = rowsAndColumns[0];
        int columns = rowsAndColumns[1];

        int[][] matrix = readMatrix(scanner, ",\\s+", rows, columns);

        int sum = Arrays.stream(matrix).mapToInt(m -> Arrays.stream(m).sum()).sum();

        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);
    }

    private static int[][] readMatrix(Scanner scanner, String separator, int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner, separator);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner, String separator) {
        return Arrays.stream(scanner.nextLine()
                .split(separator))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
