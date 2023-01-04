package Exercise;

import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int column = 0; column < tokens.length; column++) {
                matrix[row][column] = Integer.parseInt(tokens[column]);
            }
        }

        int startingRow = rows - 1;
        int startingColumn = columns - 1;
        while (0 <= startingRow && 0 <= startingColumn) {
            int innerRow = startingRow;
            int innerColumn = startingColumn;
            while (0 <= innerRow && innerColumn < columns) {
                System.out.print(matrix[innerRow--][innerColumn++] + " ");
            }
            System.out.println();

            if (startingColumn == 0) {
                startingRow--;
            } else {
                startingColumn--;
            }
        }
    }
}
