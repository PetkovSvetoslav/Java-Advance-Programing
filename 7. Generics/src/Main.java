import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        List elements = new ArrayList();

        elements.add("process");
        elements.add(10);

        for (Object element : elements) {
            System.out.println(element instanceof String);
            System.out.println(element instanceof Integer);
            System.out.println("-----------");
        }

         */

        CustomList<Integer> list = new CustomList<>(Integer.class);

        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(list.remove(i));
        }
    }
}
