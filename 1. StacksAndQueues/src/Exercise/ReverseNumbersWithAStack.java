package Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        Arrays.stream(new Scanner(System.in).nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(numbersStack::push);

        for (Integer num : numbersStack) {
            System.out.print(num + " ");
        }
    }
}
