package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> serverLogs = new TreeMap<>();

        String regex = "IP=(?<address>[^\\s]+)\\s+message=(?<message>[^\\s]+)\\s+user=(?<user>[^\\s]+)";
        Pattern pattern = Pattern.compile(regex);

        String input;
        while (!"end".equals(input = scanner.nextLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String address = matcher.group("address");
                String message = matcher.group("message");
                String user = matcher.group("user");

                Map<String, Integer> IPAddress = serverLogs.get(user);
                if (IPAddress == null) {
                    IPAddress = new LinkedHashMap<>();
                }

                Integer messagesCount = IPAddress.get(address);
                if (messagesCount == null) {
                    messagesCount = 0;
                }

                IPAddress.put(address, messagesCount + 1);
                serverLogs.put(user, IPAddress);
            }
        }
        for (Map.Entry<String, Map<String, Integer>> log : serverLogs.entrySet()) {
            System.out.println(log.getKey() + ": ");
            int counter = 0;
            for (Map.Entry<String, Integer> addresses : log.getValue().entrySet()) {
                counter++;
                System.out.print(addresses.getKey() + " => " + addresses.getValue());
                if (counter != log.getValue().size()) {
                    System.out.print(", ");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
