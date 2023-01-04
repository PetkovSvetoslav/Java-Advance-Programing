package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean isEqual = firstMatrix.length == secondMatrix.length;

        if (isEqual) {
            for (int row = 0; row < firstMatrix.length; row++) {
                int[] firstArr = firstMatrix[row];
                int[] secondArr = secondMatrix[row];
                isEqual = firstArr.length == secondArr.length;
                if (isEqual) {
                    for (int column = 0; column < firstArr.length; column++) {
                        int firstElement = firstArr[column];
                        int secondElement = secondArr[column];
                        if (firstElement != secondElement) {
                            isEqual = false;
                            break;
                        }
                    }
                }
                if (!isEqual) {
                    break;
                }
            }
        }
        String output = isEqual ? "equal" : "not equal";
        System.out.println(output);

    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndColumns = readArray(scanner);

        int rows = rowsAndColumns[0];
        int columns = rowsAndColumns[1];

        int[][] matrix = new int[rows][columns];

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
