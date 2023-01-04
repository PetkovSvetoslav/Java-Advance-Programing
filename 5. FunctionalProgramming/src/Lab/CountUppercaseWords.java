package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {

        Predicate<String> startsWithUppercase = str -> str != null && !str.isEmpty()
                    && Character.isUpperCase(str.charAt(0));


        List<String> words = Arrays.stream(new Scanner(System.in).nextLine()
                .split("\\s+"))
                .filter(startsWithUppercase)
                .collect(Collectors.toList());

        System.out.println(words.size());
        System.out.println(words.stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
