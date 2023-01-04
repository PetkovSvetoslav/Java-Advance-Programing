package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        scanner.nextLine();

        char[][] matrix = new char[rows][columns];
        int playerRow = 0;
        int playerColumn = 0;
        List<int[]> bunniesPositions = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine();
            for (int column = 0; column < columns; column++) {
                char symbol = line.charAt(column);
                matrix[row][column] = symbol;
                if (symbol == 'P') {
                    playerRow = row;
                    playerColumn = column;
                } else if (symbol == 'B') {
                    bunniesPositions.add(new int[]{row, column});
                }
            }
        }
        String commands = scanner.nextLine();

        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);

            matrix[playerRow][playerColumn] = '.';
            int playerLocation = 0;
            switch (command) {
                case 'U':
                    playerLocation = playerMovements(matrix, playerRow - 1, playerColumn);
                    if (playerLocation != 1) {
                        playerRow--;
                    }
                    break;
                case 'D':
                    playerLocation = playerMovements(matrix, playerRow + 1, playerColumn);
                    if (playerLocation != 1) {
                        playerRow++;
                    }
                    break;
                case 'R':
                    playerLocation = playerMovements(matrix, playerRow, playerColumn + 1);
                    if (playerLocation != 1) {
                        playerColumn++;
                    }
                    break;
                case 'L':
                    playerLocation = playerMovements(matrix, playerRow, playerColumn - 1);
                    if (playerLocation != 1) {
                        playerColumn--;
                    }
                    break;
            }
            int bunniesLocation = bunniesMovements(matrix, bunniesPositions);

            if (playerLocation == -1 || bunniesLocation == -1) {
                printMatrix(matrix);
                System.out.println("dead: " + playerRow + " " + playerColumn);
                break;
            } else if (playerLocation == 1) {
                printMatrix(matrix);
                System.out.println("won: " + playerRow + " " + playerColumn);
                break;
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column]);
            }
            System.out.println();
        }
    }

    private static int bunniesMovements(char[][] matrix, List<int[]> bunniesPositions) {
        List<int[]> newBunnies = new ArrayList<>();
        for (int[] bunnie : bunniesPositions) {
            int row = bunnie[0];
            int column = bunnie[1];

            //If we return -1 it means that we have lost

            //UP
            if (isValid(matrix, row - 1, column) && matrix[row - 1][column] != 'B') {
                if (matrix[row - 1][column] == 'P') {
                    matrix[row - 1][column] = 'B';
                    return -1;
                }
                matrix[row - 1][column] = 'B';
                newBunnies.add(new int[]{row - 1, column});
            }

            //DOWN
            if (isValid(matrix, row + 1, column) && matrix[row + 1][column] != 'B') {
                if (matrix[row + 1][column] == 'P') {
                    matrix[row + 1][column] = 'B';
                    return -1;
                }
                matrix[row + 1][column] = 'B';
                newBunnies.add(new int[]{row + 1, column});
            }

            //LEFT
            if (isValid(matrix, row, column - 1) && matrix[row][column - 1] != 'B') {
                if (matrix[row][column - 1] == 'P') {
                    matrix[row][column - 1] = 'B';
                    return -1;
                }
                matrix[row][column - 1] = 'B';
                newBunnies.add(new int[]{row, column - 1});
            }

            //RIGHT
            if (isValid(matrix, row, column + 1) && matrix[row][column + 1] != 'B') {
                if (matrix[row][column + 1] == 'P') {
                    matrix[row][column + 1] = 'B';
                    return -1;
                }
                matrix[row][column + 1] = 'B';
                newBunnies.add(new int[]{row, column + 1});
            }
        }
        //Add all positions of the new bunnies in the list
        bunniesPositions.addAll(newBunnies);

        return 0;
    }

    private static int playerMovements(char[][] matrix, int row, int column) {
        if (isValid(matrix, row, column)) {
            if (matrix[row][column] == 'B') {
                return -1;
            } else {
                matrix[row][column] = 'P';
            }
        } else {
            return 1;
        }
        return 0;
    }

    private static boolean isValid(char[][] matrix, int row, int column) {
        return 0 <= row && row < matrix.length && 0 <= column && column < matrix[row].length;
    }
}
