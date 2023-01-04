package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<int[]> queensPositions = new ArrayList<>();
        char[][] matrix = readMatrixAndQueens(scanner, 8, 8, "\\s+", queensPositions);
        int[] queen = checkingForTheRealQueen(matrix, queensPositions);

        if (queen == null) {
            System.out.println("There is no real queen");
        } else {
            System.out.println(queen[0] + " " + queen[1]);
        }
    }

    private static int[] checkingForTheRealQueen(char[][] matrix, List<int[]> queensPositions) {
        List<int[]> theQueen = new ArrayList<>();
        searchingByLines(theQueen, queensPositions);
        return searchingByDiagonals(matrix, theQueen);
    }


    private static int[] searchingByDiagonals(char[][] matrix, List<int[]> remainingQueens) {

        //Iterate at the remaining queens (from "searchingByLines")
        for (int i = 0; i < remainingQueens.size(); i++) {
            int[] queen = {0, 0};
            int row = remainingQueens.get(i)[0];
            int column = remainingQueens.get(i)[1];

            boolean matches = false;

            int counter = 1;
            //lower left diagonal
            while (row + counter < 8 && column - counter >= 0) {
                if (matrix[row + counter][column - counter] == 'q') {
                    matches = true;
                }
                counter++;
            }

            counter = 1;
            //lower right diagonal
            while (row + counter < 8 && column + counter < 8 && !matches) {
                if (matrix[row + counter][column + counter] == 'q') {
                    matches = true;
                }
                counter++;
            }

            counter = 1;
            //upper right diagonal
            while (row - counter >= 0 && column + counter < 8 && !matches) {
                if (matrix[row - counter][column + counter] == 'q') {
                    matches = true;
                }
                counter++;
            }

            counter = 1;
            //upper left diagonal
            while (row - counter >= 0 && column - counter >= 0 && !matches) {
                if (matrix[row - counter][column - counter] == 'q') {
                    matches = true;
                }
                counter++;
            }

            if (!matches) {
                queen[0] = row;
                queen[1] = column;
                return queen;
            }
        }
        return null;
    }

    private static void searchingByLines(List<int[]> remainingQueens, List<int[]> queensPositions) {
        //Looking for queens in the same row or in the same column
        //Then we complete the list "remainingQueens" with those that didn't match

        for (int i = 0; i < queensPositions.size(); i++) {
            int currentRow = queensPositions.get(i)[0];
            int currentColumn = queensPositions.get(i)[1];
            boolean noMatch = true;
            for (int j = 0; j < queensPositions.size(); j++) {
                if (i != j) {
                    int row = queensPositions.get(j)[0];
                    int column = queensPositions.get(j)[1];
                    if (currentColumn == column || currentRow == row) {
                        noMatch = false;
                    }
                }
            }
            if (noMatch) {
                int[] position = {currentRow, currentColumn};
                remainingQueens.add(position);
            }
        }
    }

    private static char[][] readMatrixAndQueens(Scanner scanner, int rows, int columns, String separator, List<int[]> queensPositions) {
        char[][] matrix = new char[rows][columns];

        for (int row = 0; row < matrix.length; row++) {
            String[] tokens = scanner.nextLine().split(separator);
            for (int column = 0; column < tokens.length; column++) {
                char symbol = tokens[column].charAt(0);
                matrix[row][column] = symbol;
                if (symbol == 'q') {
                    int[] queen = {row, column};
                    queensPositions.add(queen);
                }
            }
        }
        return matrix;
    }
}
