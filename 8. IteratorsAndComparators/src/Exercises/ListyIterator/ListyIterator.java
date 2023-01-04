package Exercises.ListyIterator;

import java.util.List;

public class ListyIterator {

    private final List<String> elements;
    private int index = 0;

    public ListyIterator(List<String> elements) {
        this.elements = elements;
    }

    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index < this.elements.size() - 1;
    }

    public void print() {
        validateIndex();
        System.out.println(this.elements.get(this.index));
    }

    private void validateIndex() {
        if (this.elements.isEmpty()) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
    }
}
