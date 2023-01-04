package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {

        Consumer<String> printlnSirAndTheString = str -> System.out.println("Sir " + str);

        Arrays.stream(new Scanner(System.in).nextLine()
                .split("\\s+"))
                .forEach(printlnSirAndTheString);
    }
}
