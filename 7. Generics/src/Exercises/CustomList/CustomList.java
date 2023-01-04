package Exercises.CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private class elementsIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < elements.size();
        }

        @Override
        public T next() {
            return elements.get(index++);
        }

    }

    private final List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T get(int index) {
        return this.elements.get(index);
    }

    public T remove(int index) {
        return this.elements.remove(index);
    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public int size() {
        return this.elements.size();
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstElement = this.elements.get(firstIndex);
        T secondElement = this.elements.get(secondIndex);

        this.elements.set(firstIndex, secondElement);
        this.elements.set(secondIndex, firstElement);
    }

    public long countGreaterThan(T element) {
        return this.elements
                .stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return this.elements
                .stream()
                .max(Comparable::compareTo)
                .orElseThrow(IllegalArgumentException::new);
    }

    public T getMin() {
        return this.elements
                .stream()
                .min(Comparable::compareTo)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.elements) {
            sb.append(element).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public Iterator<T> iterator() {
        return new elementsIterator();
    }
}

