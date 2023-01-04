package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {

        Consumer<String> println = System.out::println;

        Arrays.stream(new Scanner(System.in).nextLine()
                .split("\\s+"))
                .forEach(println);
    }
}
