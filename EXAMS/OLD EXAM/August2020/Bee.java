package August2020;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] territory = readMatrix(n, scanner);

        int[] beeCoordinates = coordinatesOf(territory, 'B');
        int row = beeCoordinates[0];
        int col = beeCoordinates[1];
        int pollinatedFlowers = 0;

        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            territory[row][col] = '.';
            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }
            if (outOfTerritory(territory, row, col)) {
                System.out.println("The bee got lost!");
                break;
            }

            if (territory[row][col] == 'f') {
                pollinatedFlowers++;
            } else if (territory[row][col] == 'O') {
                territory[row][col] = 'B';
                continue;
            }
            territory[row][col] = 'B';
            command = scanner.nextLine();
        }

        if (pollinatedFlowers < 5) {
            System.out.println("The bee couldn't pollinate the flowers, she needed " + (5 - pollinatedFlowers) + " flowers more");
        } else {
            System.out.println("Great job, the bee manage to pollinate " + pollinatedFlowers + " flowers!");
        }

        printMatrix(territory);
    }

    private static boolean outOfTerritory(char[][] matrix, int row, int col) {
        return 0 > row || row >= matrix.length
                || 0 > col || col >= matrix[row].length;
    }

    private static char[][] readMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
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
        int[] coordinates = new int[0];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == symbol) {
                    coordinates = new int[]{r, c};
                    break;
                }
            }
        }
        return coordinates;
    }
}
