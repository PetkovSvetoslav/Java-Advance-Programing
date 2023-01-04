import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndColumns = readArray(scanner);

        int rows = rowsAndColumns[0];
        int columns = rowsAndColumns[1];

        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
            for (int column = 0; column < arr.length; column++) {
                System.out.print(arr[column] + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
