package Exercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> playerDeck = new LinkedHashMap<>();

        String input;
        while (!"JOKER".equals(input = scanner.nextLine())) {
            String[] playerAndCards = input.split(":\\s*");
            String playerName = playerAndCards[0];
            String[] cards = playerAndCards[1].split("\\s*,\\s+");

            Set<String> deck = playerDeck.get(playerName);
            if (deck == null) {
                deck = new HashSet<>();
            }
            deck.addAll(Arrays.asList(cards));
            playerDeck.put(playerName, deck);
        }

        playerDeck.forEach((k, v) ->
                System.out.println(k + ": " + calculateTheValueOfTheCards(v)));
    }

    private static int calculateTheValueOfTheCards(Set<String> cards) {
        int sum = 0;
        for (String card : cards) {
            int power = 0;
            int type = 0;
            char secondSymbol;
            if (card.length() == 3
                    && card.charAt(0) == '1'
                    && card.charAt(1) == '0') {
                power = 10;
                secondSymbol = card.charAt(2);
            } else {
                char firstSymbol = card.charAt(0);
                secondSymbol = card.charAt(1);
                switch (firstSymbol) {
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        power = Character.getNumericValue(firstSymbol);
                        break;
                    case 'J':
                        power = 11;
                        break;
                    case 'Q':
                        power = 12;
                        break;
                    case 'K':
                        power = 13;
                        break;
                    case 'A':
                        power = 14;
                        break;
                }
            }
            switch (secondSymbol) {
                case 'S':
                    type = 4;
                    break;
                case 'H':
                    type = 3;
                    break;
                case 'D':
                    type = 2;
                    break;
                case 'C':
                    type = 1;
            }
            sum += power * type;
        }
        return sum;
    }
}
