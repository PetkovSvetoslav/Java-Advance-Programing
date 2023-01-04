package June2020;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] territory = readMatrix(size, scanner);

        int[] snakeCoordinates = coordinatesOf(territory, 'S');
        int row = snakeCoordinates[0];
        int cow = snakeCoordinates[1];

        int foodCount = 0;

        while (true) {
            String command = scanner.nextLine();

            territory[row][cow] = '.';
            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    cow--;
                    break;
                case "right":
                    cow++;
                    break;
            }

            if (outOfBounds(territory, row, cow)) {
                System.out.println("Game over!");
                break;
            }

            if (territory[row][cow] == '*') {
                foodCount++;
            } else if (territory[row][cow] == 'B') {
                territory[row][cow] = '.';
                int[] coordinatesOfSecondBurrow = coordinatesOf(territory, 'B');
                row = coordinatesOfSecondBurrow[0];
                cow = coordinatesOfSecondBurrow[1];
            }
            territory[row][cow] = 'S';

            if (foodCount == 10) {
                System.out.println("You won! You fed the snake.");
                break;
            }
        }
        System.out.println("Food eaten: " + foodCount);

        printMatrix(territory);
    }

    private static char[][] readMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            String line = scanner.nextLine();
            for (int c = 0; c < size; c++) {
                matrix[r][c] = line.charAt(c);
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static int[] coordinatesOf(char[][] matrix, char symbol) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == symbol) {
                    return new int[]{r, c};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static boolean outOfBounds(char[][] matrix, int row, int cow) {
        return 0 > row || row >= matrix.length
                || 0 > cow || cow >= matrix[row].length;
    }
}