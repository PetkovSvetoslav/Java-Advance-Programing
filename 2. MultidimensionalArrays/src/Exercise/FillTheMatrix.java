package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");

        int size = Integer.parseInt(input[0]);
        String type = input[1];
        int[][] matrix;
        if (type.equals("A")) {
            matrix = fillTheMatrixFromTopToBottomByColumn(size);
        } else {
            matrix = fillTheMatrixFromTopToBottomAndThenFromBottomToTop(size);
        }

        printMatrix(matrix);
    }

    /**
     * print n/n matrix
     *
     * @param matrix matrix to print
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] array : matrix) {
            Arrays.stream(array).forEach(n -> System.out.print(n + " "));
            System.out.println();
        }
    }

    private static int[][] fillTheMatrixFromTopToBottomByColumn(int size) {
        int[][] matrix = new int[size][size];

        int counter = 1;
        for (int column = 0; column < size; column++) {
            for (int row = 0; row < size; row++) {
                matrix[row][column] = counter++;
            }
        }
        return matrix;
    }

    private static int[][] fillTheMatrixFromTopToBottomAndThenFromBottomToTop(int size) {
        int[][] matrix = new int[size][size];

        int counter = 1;
        for (int column = 0; column < size; column++) {
            if (column % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][column] = counter++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][column] = counter++;
                }
            }
        }
        return matrix;
    }
}
