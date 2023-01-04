package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> textChanges = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");

            switch (commands[0]) {
                case "1": {
                    //adds string to text
                    String s = commands[1];
                    if (!textChanges.isEmpty()) {
                        s = textChanges.peek() + s;
                    }
                    textChanges.push(s);
                    break;
                }
                case "2": {
                    int count = Integer.parseInt(commands[1]);
                    String text = textChanges.peek();
                    if (text != null) {
                        if (text.length() < count) {
                            textChanges.push("");
                        } else {
                            text = text.substring(0, text.length() - count);
                            textChanges.push(text);
                        }
                    }
                    break;
                }
                case "3": {
                    int index = Integer.parseInt(commands[1]) - 1;
                    String text = textChanges.peek();
                    if (text != null && 0 <= index && index < text.length()) {
                        System.out.println(text.charAt(index));
                    }
                    break;
                }
                case "4": {
                    textChanges.pop();
                    break;
                }
            }
        }
    }
}
