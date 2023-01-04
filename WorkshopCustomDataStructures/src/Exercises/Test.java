package Exercises;

import java.util.Date;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.removeFirst();
        Date s = new Date();
        for (int i = 1; i <= 10000000; i++) {
            list.addFirst(i);
        }
        Date e = new Date();
        System.out.println(e.getTime() - s.getTime());
    }
}