package Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> usersLogs = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String IP = data[0];
            String user = data[1];
            int duration = Integer.parseInt(data[2]);

            Map<String, Integer> spentTimeOnAddresses = usersLogs.get(user);
            if (spentTimeOnAddresses == null) {
                spentTimeOnAddresses = new TreeMap<>();
            }

            Integer durationPerAddress = spentTimeOnAddresses.get(IP);
            if (durationPerAddress == null){
                durationPerAddress = 0;
            }

            spentTimeOnAddresses.put(IP, durationPerAddress + duration);
            usersLogs.put(user, spentTimeOnAddresses);
        }

        usersLogs.forEach((k,v) -> {
            System.out.printf("%s: %d [%s]%n"
                    , k
                    , v.values().stream().mapToInt(i -> i).sum()
                    , String.join(", ",v.keySet()));
        });
    }
}
