package Lab;

import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int column = 0; column < tokens.length; column++) {
                matrix[row][column] = Integer.parseInt(tokens[column]);
            }
        }
        int row = 0, column = 0;
        while (row < n && column < n) {
            System.out.print(matrix[row++][column++] + " ");
        }
        System.out.println();

        row = n - 1;
        column = 0;
        while (row >= 0 && column < n) {
            System.out.print(matrix[row--][column++] + " ");
        }
    }
}
