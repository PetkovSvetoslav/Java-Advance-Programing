import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String input = "12" + System.lineSeparator()
                + "nextLine";
        System.out.println(input);
        //12
        //nextLine

        Scanner scanner = new Scanner(input);
        int num = scanner.nextInt();
        String nextLine = scanner.nextLine();
        System.out.println(num);
        //12
        System.out.println(nextLine);
        //""
    }
}
