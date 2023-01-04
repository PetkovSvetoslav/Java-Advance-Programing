package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        scanner.nextLine();

        List<List<Integer>> matrix = generateMatrix(rows, columns);

        String input;
        while (!"Nuke it from orbit".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int column = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            explosion(row, column, radius, matrix);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            matrix.get(row).forEach(n -> System.out.print(n + " "));
            System.out.println();
        }
    }

    private static void explosion(int row, int column, int radius, List<List<Integer>> matrix) {

        for (int i = row - radius; i <= row + radius; i++) {
            if (isInRange(i, column, matrix) && i != row) {
                matrix.get(i).remove(column);
            }
        }

        for (int i = column + radius; i >= column - radius; i--) {
            if (isInRange(row, i, matrix)) {
                matrix.get(row).remove(i);
            }
        }
        matrix.removeIf(List::isEmpty);

    }

    private static boolean isInRange(int row, int column, List<List<Integer>> matrix) {
        return (0 <= row && row < matrix.size()) && 0 <= column && column < matrix.get(row).size();
    }

    private static List<List<Integer>> generateMatrix(int rows, int columns) {
        List<List<Integer>> matrix = new ArrayList<>();
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            List<Integer> numList = new ArrayList<>();
            for (int column = 0; column < columns; column++) {
                numList.add(counter++);
            }
            matrix.add(numList);
        }
        return matrix;
    }
}
