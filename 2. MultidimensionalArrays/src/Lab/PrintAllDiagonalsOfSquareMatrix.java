package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintAllDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //This example was given by a teacher
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, size);

        int row = 0, column = size - 1;
        //runs along the entire top row and the alon the entire left column
        while (row < size && column >= 0) {
            int innerRow = row, innerColumn = column;
            while (innerRow < size && innerColumn < size) {
                System.out.print(matrix[innerRow++][innerColumn++] + " ");
            }
            System.out.println();

            if (column == 0) {
                row++;
            } else {
                column--;
            }
        }


    }

    private static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
