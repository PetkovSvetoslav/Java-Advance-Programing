package Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstDeck = new LinkedHashSet<>();
        Set<Integer> secondDeck = new LinkedHashSet<>();

        //Fill the first deck
        for (int p1 = 0; p1 < 20; p1++) {
            int card = scanner.nextInt();
            firstDeck.add(card);
        }
        scanner.nextLine();

        //Fill the second deck
        for (int p2 = 0; p2 < 20; p2++) {
            int card = scanner.nextInt();
            secondDeck.add(card);
        }

        //Game rounds
        for (int r = 0; r < 50; r++) {
            int firstNum = firstDeck.iterator().next();
            firstDeck.remove(firstNum);

            int secondNum = secondDeck.iterator().next();
            secondDeck.remove(secondNum);

            if (firstNum > secondNum) {
                firstDeck.add(firstNum);
                firstDeck.add(secondNum);
            } else if (firstNum < secondNum) {
                secondDeck.add(firstNum);
                secondDeck.add(secondNum);
            }
        }

        if (firstDeck.size() == secondDeck.size()) {
            System.out.println("Draw!");
        } else if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }
}
