package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int num = Integer.parseInt(scanner.nextLine());
        List<int[]> coordinates = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == num) {
                    int[] indexes = {row, column};
                    coordinates.add(indexes);
                }
            }
        }

        if (coordinates.isEmpty()) {
            System.out.println("not found");
        } else {
            for (int[] coordinate : coordinates) {
                System.out.println(coordinate[0] + " " + coordinate[1]);
            }
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndColumns = readArray(scanner);

        int rows = rowsAndColumns[0];
        int column = rowsAndColumns[1];

        int[][] matrix = new int[rows][column];
        for (int row = 0; row < matrix.length; row++) {
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
