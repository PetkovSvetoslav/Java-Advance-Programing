package Exercise;

import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }
        }
        char replacement = scanner.nextLine().charAt(0);
        int startingRow = scanner.nextInt();
        int startingCol = scanner.nextInt();
        char startChar = matrix[startingRow][startingCol];

        characterSpread(matrix, startingRow, startingCol, startChar, replacement);

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    /**
     *
     * Every character equals to "startChar" and in contact with it, turns into "replacement"
     *
     * @param matrix - character matrix
     * @param row - the row witch the spread begins
     * @param col - the column witch the spread begins
     * @param startChar - the character that we replace
     * @param replacement - the replacement of the char
     */
    private static void characterSpread(char[][] matrix, int row, int col, char startChar, char replacement) {
        if (matrix[row][col] != startChar || replacement == startChar) {
            return;
        }
        matrix[row][col] = replacement;

        //UP
        if (0 <= row - 1) {
            characterSpread(matrix, row - 1, col, startChar, replacement);
        }

        //DOWN
        if (row + 1 < matrix.length) {
            characterSpread(matrix, row + 1, col, startChar, replacement);
        }

        //LEFT
        if (0 <= col - 1) {
            characterSpread(matrix, row, col -1, startChar, replacement);
        }

        //RIGHT
        if (col + 1 < matrix[row].length){
            characterSpread(matrix, row, col + 1, startChar, replacement);
        }
    }
}
