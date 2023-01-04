package Exercises.Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] stones = Arrays.stream(scanner.nextLine().split(",+\\s*"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(stones);
        Iterator<Integer> frog = lake.iterator();

        StringBuilder output = new StringBuilder();
        while (frog.hasNext()) {
            output.append(frog.next());
            if (frog.hasNext()) {
                output.append(", ");
            }
        }
        System.out.println(output);
    }
}
