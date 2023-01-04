package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();

        String regex = "(?<=\\()\\d+(?=\\))";
        Pattern pattern = Pattern.compile(regex);
        String command = scanner.nextLine();
        Matcher matcher = pattern.matcher(command);

        int degrees = 0;
        if (matcher.find()) {
            degrees = Integer.parseInt(matcher.group());
        }

        while (degrees >= 360) {
            degrees -= 360;
        }

        String input;
        int longestString = 0;
        while (!"END".equals(input = scanner.nextLine())) {
            if (longestString < input.length()) {
                longestString = input.length();
            }
            stringList.add(input);
        }
        char[][] matrix = rotate0degrees(stringList, longestString);
        switch (degrees) {
            case 0:
                break;
            case 90:
                matrix = rotate90degrees(stringList, longestString);
                break;
            case 180:
                matrix = rotate180degrees(stringList, longestString);
                break;
            case 270:
                matrix = rotate270degrees(stringList, longestString);
                break;
        }

        printMatrix(matrix);
    }

    private static char[][] rotate0degrees(List<String> stringList, int longestString) {
        int rows = stringList.size();
        int columns = longestString;

        char[][] matrix = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            String s = stringList.get(row);
            for (int column = 0; column < columns; column++) {
                char symbol;
                if (s.length() - 1 < column) {
                    symbol = ' ';
                } else {
                    symbol = s.charAt(column);
                }
                matrix[row][column] = symbol;
            }
        }
        return matrix;
    }

    private static char[][] rotate270degrees(List<String> stringList, int longestString) {
        int rows = longestString;
        int columns = stringList.size();

        char[][] matrix = new char[rows][columns];
        for (int column = 0; column < columns; column++) {
            String s = stringList.get(column);
            for (int row = 0; row < rows; row++) {
                int oppositeRow = rows - row - 1;

                char symbol;
                if (s.length() <= row) {
                    symbol = ' ';
                } else {
                    symbol = s.charAt(row);
                }

                matrix[oppositeRow][column] = symbol;
            }
        }
        return matrix;
    }

    private static char[][] rotate180degrees(List<String> stringList, int longestString) {
        int rows = stringList.size();
        int columns = longestString;

        char[][] matrix = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            String s = stringList.get(row);
            int oppositeRow = rows - row - 1;
            for (int column = 0; column < columns; column++) {
                int oppositeColumn = columns - column - 1;

                char symbol;
                if (s.length() <= column) {
                    symbol = ' ';
                } else {
                    symbol = s.charAt(column);
                }
                matrix[oppositeRow][oppositeColumn] = symbol;
            }

        }
        return matrix;
    }

    private static char[][] rotate90degrees(List<String> stringList, int longestString) {
        int rows = longestString;
        int columns = stringList.size();

        char[][] matrix = new char[rows][columns];
        for (int column = 0; column < columns; column++) {
            String s = stringList.get(column);
            int oppositeColumn = columns - column - 1;
            for (int row = 0; row < rows; row++) {
                char symbol;
                if (s.length() <= row) {
                    symbol = ' ';
                } else {
                    symbol = s.charAt(row);
                }

                matrix[row][oppositeColumn] = symbol;
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] array : matrix) {
            for (char chars : array) {
                System.out.print(chars);
            }
            System.out.println();
        }
    }
}
