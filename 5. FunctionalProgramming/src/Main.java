import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer integer = numbers.stream()
                .filter(n -> n > 3)
                .filter(n -> n % 2 == 0)
                .findFirst()
                .orElseGet(() -> new Random().nextInt());

        System.out.println(integer);

        int a = -1111252323;
        int b = 1;
        System.out.println(a & b);
    }
}
