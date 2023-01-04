package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> usersData = new LinkedHashMap<>();

        String name;
        while (!"stop".equals(name = scanner.nextLine())) {
            String email = scanner.nextLine();
            if (emailIsValid(email)) {
                usersData.put(name, email);
            }
        }
        usersData.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    private static boolean emailIsValid(String email) {
        Pattern pattern = Pattern.compile("(us|uk|com)$");
        Matcher matcher = pattern.matcher(email);
        return !matcher.find();
    }
}
