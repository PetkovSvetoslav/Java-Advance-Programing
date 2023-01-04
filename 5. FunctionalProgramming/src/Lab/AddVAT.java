package Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {

        UnaryOperator<Double> vatAdder = val -> val * 1.20;
        System.out.println("Price with VAT:");
        Arrays.stream(new Scanner(System.in).nextLine().split(", "))
                .map(n -> vatAdder.apply(Double.parseDouble(n)))
                .forEach(n -> System.out.printf("%.2f%n",n));
    }
}
