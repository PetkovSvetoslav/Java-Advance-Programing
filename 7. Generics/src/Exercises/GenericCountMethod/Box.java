package Exercises.GenericCountMethod;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {

    private final List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public long countGreaterElements(T toCompare) {
        return this.values
                .stream()
                .filter(e -> e.compareTo(toCompare) > 0)
                .count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(String.format("%s: %s%n", value.getClass().getName(), value));
        }
        return sb.toString();
    }
}
