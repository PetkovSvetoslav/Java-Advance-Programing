package Lab;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> graduationList = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] gradesAsString = scanner.nextLine().split("\\s+");

            double gradesSum = 0.0;
            for (String s : gradesAsString) {
                gradesSum += Double.parseDouble(s);
            }
            graduationList.put(name, gradesSum / gradesAsString.length);
        }
        for (Map.Entry<String, Double> entry : graduationList.entrySet()) {
            System.out.println(entry.getKey() + " is graduated with " + entry.getValue());
        }

        /*
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            graduationList.put(name, grades);
        }

        graduationList.forEach((k, v) ->
                System.out.println(k + " is graduated with "
                        + Arrays.stream(v).average().orElse(0))
        );

         */
    }
}
