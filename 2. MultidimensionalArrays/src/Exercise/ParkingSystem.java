package Exercise;

import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        boolean[][] parking = generateParking(rows, columns);
        scanner.nextLine();
        String input;
        while (!"stop".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            int entryRow = Integer.parseInt(tokens[0]);
            int targetRow = Integer.parseInt(tokens[1]);
            int targetColumn = Integer.parseInt(tokens[2]);

            boolean hasFoundAFreePlace = false;
            int traveledDistance = 1;
            traveledDistance += Math.abs(targetRow - entryRow);

            //If target place is free
            if (!parking[targetRow][targetColumn]) {
                traveledDistance += targetColumn;
                parking[targetRow][targetColumn] = true;
                hasFoundAFreePlace = true;
            } else {
                //Searching for a free place at the same row
                for (int i = 1; i < parking[targetRow].length; i++) {
                    if (targetColumn - i > 0 && !parking[targetRow][targetColumn - i]) {
                        traveledDistance += targetColumn - i;
                        parking[targetRow][targetColumn - i] = true;
                        hasFoundAFreePlace = true;
                        break;
                    }

                    if (targetColumn + i < parking[targetRow].length && !parking[targetRow][targetColumn + i]) {
                        traveledDistance += targetColumn + i;
                        parking[targetRow][targetColumn + i] = true;
                        hasFoundAFreePlace = true;
                        break;
                    }
                }
            }
            if (hasFoundAFreePlace){
                System.out.println(traveledDistance);
            } else {
                System.out.println("Row " + targetRow + " full");
            }
        }
    }

    private static boolean[][] generateParking(int rows, int columns) {
        //Generate matrix with a whole column full of "true"
        boolean[][] matrix = new boolean[rows][columns];
        for (int row = 0; row < rows; row++) {
            matrix[row][0] = true;
        }
        return matrix;
    }
}
