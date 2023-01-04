package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> documentsQueue = new ArrayDeque<>();

        String input;
        while (!"print".equals(input = scanner.nextLine())) {
            if (input.equals("cancel")) {
                if (documentsQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + documentsQueue.poll());
                }
            } else {
                documentsQueue.offer(input);
            }
        }

        for (String s : documentsQueue) {
            System.out.println(s);
        }
    }
}
