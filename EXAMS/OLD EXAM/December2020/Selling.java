package December2020;

import java.util.Scanner;

public class Selling {
    static int money = 0;
    static int row;
    static int col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] bakery = readMatrix(scanner, n);
        int[] sellerCoordinates = coordinateOf(bakery, 'S');
        row = sellerCoordinates[0];
        col = sellerCoordinates[1];

        boolean isOutOfTheBakery = false;
        String movement = scanner.nextLine();
        while (true) {
            switch (movement) {
                case "up":
                    isOutOfTheBakery = moveAndCollect(bakery, row - 1, col);
                    break;
                case "down":
                    isOutOfTheBakery = moveAndCollect(bakery, row + 1, col);
                    break;
                case "left":
                    isOutOfTheBakery = moveAndCollect(bakery, row, col - 1);
                    break;
                case "right":
                    isOutOfTheBakery = moveAndCollect(bakery, row, col + 1);
                    break;
            }
            if (50 <= money) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
            if (isOutOfTheBakery) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }
            movement = scanner.nextLine();
        }
        System.out.println("Money: " + money);
        printMatrix(bakery);
    }

    private static char[][] readMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
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

    private static int[] coordinateOf(char[][] matrix, char symbol) {
        int[] coordinates = new int[0];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == symbol) {
                    coordinates = new int[]{r, c};
                }
            }
        }
        return coordinates;
    }

    private static boolean moveAndCollect(char[][] matrix, int newRow, int newCol) {
        matrix[row][col] = '-';

        if (!outOfBounds(matrix, newRow, newCol)) {
            return true;
        }
        char symbol = matrix[newRow][newCol];

        if (Character.isDigit(symbol)) {
            money += Character.getNumericValue(symbol);
        } else if (symbol == 'O') {
            matrix[newRow][newCol] = '-';
            int[] pillarCoordinates = coordinateOf(matrix, 'O');
            newRow = pillarCoordinates[0];
            newCol = pillarCoordinates[1];
        }

        matrix[newRow][newCol] = 'S';
        row = newRow;
        col = newCol;

        return false;
    }

    private static boolean outOfBounds(char[][] matrix, int row, int col) {
        return 0 <= row && row < matrix.length &&
                0 <= col && col < matrix[row].length;
    }
}
