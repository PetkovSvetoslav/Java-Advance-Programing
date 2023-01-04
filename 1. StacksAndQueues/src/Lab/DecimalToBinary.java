package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        ArrayDeque<Integer> binaryNum = new ArrayDeque<>();
        int decimalNum = new Scanner(System.in).nextInt();
        if (decimalNum == 0) {
            binaryNum.push(0);
        }
        while (decimalNum != 0) {
            int binaryDigit = decimalNum % 2;
            binaryNum.push(binaryDigit);
            decimalNum /= 2;
        }
        for (Integer digit : binaryNum) {
            System.out.print(digit);
        }
    }
}
