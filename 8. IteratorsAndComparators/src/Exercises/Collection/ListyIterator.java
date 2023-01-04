package Exercises.Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {

    private class ElementsIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < elements.size();
        }

        @Override
        public String next() {
            return elements.get(this.index++);
        }
    }

    private List<String> elements;
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

    @Override
    public Iterator<String> iterator() {
        validateIndex();
        return new ElementsIterator();
    }
}
