package Lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] student = scanner.nextLine().split("\\s+");
            String name = student[0];
            double grade = Double.parseDouble(student[1]);

            List<Double> grades = studentsGrades.get(name);
            if (grades == null) {
                grades = new ArrayList<>();
            }
            grades.add(grade);
            studentsGrades.put(name, grades);
        }

        for (Map.Entry<String, List<Double>> entry : studentsGrades.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            double gradesSum = 0;
            for (Double grade : entry.getValue()) {
                gradesSum += grade;
                System.out.printf("%.2f ", grade);
            }
            System.out.printf("(avg: %.2f)%n", gradesSum / entry.getValue().size());

        }

        /*
        studentsGrades
                .forEach((k, v) -> {
                    System.out.print(k + " -> ");
                    v.forEach(g -> System.out.printf("%.2f ", g));
                    double averageGrade = v.stream().mapToDouble(val -> val).average().orElse(0.00);
                    System.out.printf("(avg: %.2f)%n",averageGrade);
                });
         */
    }
}
