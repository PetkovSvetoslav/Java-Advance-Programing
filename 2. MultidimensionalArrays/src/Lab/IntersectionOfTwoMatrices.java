package Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(scanner, rows, columns);
        char[][] secondMatrix = readMatrix(scanner, rows, columns);

        char[][] finalMatrix = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                char firstSymbol = firstMatrix[row][column];
                char secondSymbol = secondMatrix[row][column];

                finalMatrix[row][column] = firstSymbol == secondSymbol ? firstSymbol : '*';
            }
        }

        printMatrix(finalMatrix);
    }

    private static char[][] readMatrix(Scanner scanner, int rows, int columns) {
        char[][] matrix = new char[rows][columns];
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int column = 0; column < line.length; column++) {
                matrix[row][column] = line[column].charAt(0);
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}
