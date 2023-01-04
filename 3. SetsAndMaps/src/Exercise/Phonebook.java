package Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contacts = new HashMap<>();

        String info;
        while (!"search".equals(info = scanner.nextLine())) {
            String[] tokens = info.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];
            contacts.put(name, phoneNumber);
        }

        while (!"stop".equals(info = scanner.nextLine())) {
            if (!contacts.containsKey(info)) {
                System.out.println("Contact " + info + " does not exist.");
            } else {
                System.out.println(info + " -> " + contacts.get(info));
            }
        }
    }
}
