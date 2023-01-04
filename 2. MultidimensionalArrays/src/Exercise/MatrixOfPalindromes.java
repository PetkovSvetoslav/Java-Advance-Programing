package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int column = scanner.nextInt();

        String[][] matrix = generatePalindromeMatrix(row, column);

        for (String[] array : matrix) {
            Arrays.stream(array).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }

    private static String[][] generatePalindromeMatrix(int rows, int columns) {
        String[][] matrix = new String[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                char firstLetter = (char) (row + 97);
                char middleLetter = (char) (row + column + 97);
                char lastLetter = firstLetter;
                String s = firstLetter + "" + middleLetter + lastLetter;
                matrix[row][column] = s;
            }
        }
        return matrix;
    }
}
