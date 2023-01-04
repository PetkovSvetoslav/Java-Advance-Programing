package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> backHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        String input;
        String URL = null;
        while (!"Home".equals(input = scanner.nextLine())) {
            if (input.equals("back")) {
                if (backHistory.isEmpty()) {
                    System.out.println("no previous URLs");
                    continue;
                } else {
                    forwardHistory.push(URL);
                    URL = backHistory.pop();
                }
            } else if (input.equals("forward")) {
                if (forwardHistory.isEmpty()) {
                    System.out.println("no next URLs");
                    continue;
                } else {
                    URL = forwardHistory.pop();
                }
            } else {
                if (URL != null) {
                    backHistory.push(URL);
                }
                forwardHistory.clear();
                URL = input;
            }
            System.out.println(URL);
        }
    }
}
