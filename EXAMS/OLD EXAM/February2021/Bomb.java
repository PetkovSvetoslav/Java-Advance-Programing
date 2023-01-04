package February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {

    static int bombsCount = 0;
    static int row = -1;
    static int col = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> commands = Arrays.stream(scanner.nextLine().split(",\\s*"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        char[][] matrix = readMatrix(size, scanner);

        while (!commands.isEmpty()) {
            String command = commands.poll();
            int result = 0;
            switch (command) {
                case "left":
                    result = move(matrix, row, col - 1);
                    break;
                case "right":
                    result = move(matrix, row, col + 1);
                    break;
                case "up":
                    result = move(matrix, row - 1, col);
                    break;
                case "down":
                    result = move(matrix, row + 1, col);
                    break;
            }
            if (result == -1) {
                System.out.println("You found a bomb!");
            }
            if (bombsCount == 0) {
                System.out.println("Congratulations! You found all bombs!");
                return;
            }
            if (result == 1) {
                System.out.println("END! " + bombsCount + " bombs left on the field");
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombsCount, row, col);
    }

    private static int move(char[][] matrix, int newRow, int newCol) {
        if (outOfBounds(matrix, newRow, newCol)) {
            return 0;
        }
        matrix[row][col] = '+';
        row = newRow;
        col = newCol;

        if (matrix[newRow][newCol] == 'B') {
            matrix[row][col] = 's';
            bombsCount--;
            return -1;
        } else if (matrix[newRow][newCol] == 'e') {
            matrix[row][col] = 's';
            return 1;
        }
        matrix[row][col] = 's';
        return 0;
    }

    private static boolean outOfBounds(char[][] matrix, int r, int c) {
        return 0 > r || r >= matrix.length
                || 0 > c || c >= matrix[r].length;
    }

    private static char[][] readMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int c = 0; c < size; c++) {
                char currentSymbol = tokens[c].charAt(0);
                matrix[r][c] = currentSymbol;
                if (currentSymbol == 'B') {
                    bombsCount++;
                } else if (currentSymbol == 's') {
                    row = r;
                    col = c;
                }
            }
        }
        return matrix;
    }
}
