package Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        Set<Integer> set1 = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            set1.add(num);
        }

        Set<Integer> set2 = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            set2.add(num);
        }

        for (Integer num : set1) {
            if (set2.contains(num)) {
                System.out.print(num + " ");
            }
        }
    }
}
