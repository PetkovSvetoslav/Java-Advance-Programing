package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();

        String input;
        String URL = null;
        while (!"Home".equals(input = scanner.nextLine())) {
            if (input.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    continue;
                } else {
                    URL = history.pop();
                }
            } else {
                if (URL != null) {
                    history.push(URL);
                }
                URL = input;
            }
            System.out.println(URL);
        }
    }
}
