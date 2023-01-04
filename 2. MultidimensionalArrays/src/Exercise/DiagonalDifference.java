package Exercise;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner, size);

        int difference = diffFromTheDiagonalsSums(matrix);
        System.out.println(difference);
    }

    private static int diffFromTheDiagonalsSums(int[][] matrix) {

        int row = 0, column = 0;
        int sumA = 0;
        while (row < matrix.length) {
            sumA += matrix[row++][column++];
        }

        row = 0;
        column = matrix.length - 1;
        int sumB = 0;
        while (row < matrix.length && column >= 0) {
            sumB += matrix[row++][column--];
        }

        return Math.abs(sumA - sumB);
    }

    private static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int column = 0; column < tokens.length; column++) {
                matrix[row][column] = Integer.parseInt(tokens[column]);
            }
        }
        return matrix;
    }
}
