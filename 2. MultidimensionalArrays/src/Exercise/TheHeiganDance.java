package Exercise;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Heigan
        double heiganPoints = 3_000_000;

        //Player
        int playerPoints = 18_500;
        double damage = Double.parseDouble(scanner.nextLine());
        int startRow = 7;
        int startColumn = 7;

        boolean activeCloud = false;
        String previousSpell = "";

        while (heiganPoints > 0 && playerPoints > 0) {
            heiganPoints -= damage;

            if (activeCloud) {
                playerPoints -= 3_500;
                activeCloud = false;
                if (playerPoints <= 0) {
                    break;
                }
            }

            if (heiganPoints <= 0) {
                break;
            }

            String[] castSpell = scanner.nextLine().split("\\s+");
            String spell = castSpell[0];
            int row = Integer.parseInt(castSpell[1]);
            int column = Integer.parseInt(castSpell[2]);

            boolean[][] chamber = new boolean[15][15];
            for (int r = row - 1; r <= row + 1; r++) {
                if (0 <= r && r < chamber.length) {
                    for (int c = column - 1; c <= column + 1; c++) {
                        if (0 <= c && c < chamber[r].length) {
                            chamber[r][c] = true;
                        }
                    }
                }
            }

            if (chamber[startRow][startColumn]) {
                if (isValidRow(chamber, startRow - 1) && !chamber[startRow - 1][startColumn]) {
                    startRow--;
                } else if (isValidColumn(chamber, startRow, startColumn + 1) && !chamber[startRow][startColumn + 1]) {
                    startColumn++;
                } else if (isValidRow(chamber, startRow + 1) && !chamber[startRow + 1][startColumn]) {
                    startRow++;
                } else if (isValidColumn(chamber, startRow, startColumn - 1) && !chamber[startRow][startColumn - 1]) {
                    startColumn--;
                }

                if (chamber[startRow][startColumn]) {
                    switch (spell) {
                        case "Cloud":
                            playerPoints -= 3_500;
                            activeCloud = true;
                            previousSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerPoints -= 6_000;
                            previousSpell = "Eruption";
                            break;
                    }

                    if (playerPoints <= 0) {
                        break;
                    }
                }
            }
        }

        if (heiganPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganPoints);
        }

        if (playerPoints <= 0) {
            System.out.println("Player: Killed by " + previousSpell);
        } else {
            System.out.println("Player: " + playerPoints);
        }

        System.out.printf("Final position: %d, %d%n", startRow, startColumn);
    }

    private static boolean isValidColumn(boolean[][] chamber, int row, int column) {
        return 0 <= column && column < chamber[row].length;
    }

    private static boolean isValidRow(boolean[][] chamber, int row) {
        return 0 <= row && row < chamber.length;
    }
}
