package Exercises.GenericSwapMethod;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private final List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstElement = this.values.get(firstIndex);
        T secondElement = this.values.get(secondIndex);
        this.values.set(firstIndex, secondElement);
        this.values.set(secondIndex, firstElement);
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
