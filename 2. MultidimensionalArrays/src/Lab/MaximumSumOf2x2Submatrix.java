package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndColumns = readArray(scanner, ",\\s+");

        int rows = rowsAndColumns[0];
        int columns = rowsAndColumns[1];

        int[][] matrix = readMatrix(scanner, rows, columns, ",\\s+");

        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0, maxColumn = 0;
        for (int row = 0; row < rows - 1; row++) {
            for (int column = 0; column < columns - 1; column++) {
                int sum = matrix[row][column] + matrix[row][column + 1]
                        + matrix[row + 1][column] + matrix[row + 1][column + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    maxRow = row;
                    maxColumn = column;
                }
            }
        }

        System.out.println(matrix[maxRow][maxColumn] + " " + matrix[maxRow][maxColumn + 1]);
        System.out.println(matrix[maxRow + 1][maxColumn] + " " + matrix[maxRow + 1][maxColumn + 1]);
        System.out.println(maxSum);
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int columns, String separator) {
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
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
