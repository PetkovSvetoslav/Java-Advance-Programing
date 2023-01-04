package Exercises;

public class Main {
    public static void main(String[] args) {

        SmartLinkedList list = new SmartLinkedList();
        list.addFirst(0);

        for (int i = 0; i < 10; i++) {
            list.addLast(i + 1);
            list.addFirst(11);
        }

        for (int i = 0; i <= 5; i++) {
            System.out.println(list.removeLast());
            System.out.println(list.removeFirst());
        }

    }
}
