package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndColumns = readArray(scanner, "\\s+");

        int rows = rowsAndColumns[0];
        int columns = rowsAndColumns[1];

        int[][] matrix = readMatrix(scanner, rows, columns);

        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0, maxColumn = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int column = 0; column < columns - 2; column++) {
                int sum = matrixSum3x3(matrix, row, column);
                if (sum > maxSum) {
                    maxSum = sum;
                    maxRow = row;
                    maxColumn = column;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int r = maxRow; r < maxRow + 3; r++) {
            for (int c = maxColumn; c < maxColumn + 3; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static int matrixSum3x3(int[][] matrix, int row, int column) {
        int sum = 0;
        for (int r = row; r < row + 3; r++) {
            for (int c = column; c < column + 3; c++) {
                sum += matrix[r][c];
            }
        }
        return sum;
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int columns) {
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner, "\\s+");
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
