package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, rows, "\\s+");
        int[] indexes = readArray(scanner, "\\s+");

        int mistakenValue = matrix[indexes[0]][indexes[1]];
        List<int[]> fixInfo = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == mistakenValue) {
                    int correctValue = calculateCorrectValue(matrix, row, column, mistakenValue);
                    fixInfo.add(new int[]{row, column, correctValue});
                }
            }
        }

        for (int[] ints : fixInfo) {
            int row = ints[0];
            int column = ints[1];
            int correctValue = ints[2];
            matrix[row][column] = correctValue;
        }

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] array : matrix) {
            Arrays.stream(array).forEach(n -> System.out.print(n + " "));
            System.out.println();
        }
    }


    private static int calculateCorrectValue(int[][] matrix, int row, int column, int mistakenValue) {
        int correctValue = 0;

        if (isInBounds(matrix, row + 1, column, mistakenValue)) {
            correctValue += matrix[row + 1][column];
        }

        if (isInBounds(matrix, row - 1, column, mistakenValue)) {
            correctValue += matrix[row - 1][column];
        }

        if (isInBounds(matrix, row, column + 1, mistakenValue)) {
            correctValue += matrix[row][column + 1];
        }

        if (isInBounds(matrix, row, column - 1, mistakenValue)) {
            correctValue += matrix[row][column - 1];
        }

        return correctValue;
    }

    private static boolean isInBounds(int[][] matrix, int row, int column, int mistakenValue) {
        return (0 <= row && row < matrix.length) && (0 <= column && column < matrix[row].length)
                && matrix[row][column] != mistakenValue;
    }

    private static int[][] readMatrix(Scanner scanner, int rows, String separator) {
        int[][] matrix = new int[rows][];
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
