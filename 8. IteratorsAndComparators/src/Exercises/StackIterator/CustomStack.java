package Exercises.StackIterator;

import java.util.Iterator;

public class CustomStack implements Iterable<Integer> {
    private Node top;

    private class Node {
        private int element;
        private Node prev;

        public Node(int element) {
            this.element = element;
        }
    }

    private class StackIterator implements Iterator<Integer> {
        Node currentElement = top;

        @Override
        public boolean hasNext() {
            return this.currentElement != null;
        }

        @Override
        public Integer next() {
            int element = this.currentElement.element;
            this.currentElement = this.currentElement.prev;
            return element;
        }
    }

    public void push(int element) {
        Node newNode = new Node(element);
        if (this.top != null) {
            newNode.prev = this.top;
        }
        this.top = newNode;
    }

    public int pop() {
        ensureNotEmpty();
        int element = this.top.element;
        this.top = this.top.prev;
        return element;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public Iterator<Integer> iterator(){
        return new StackIterator();
    }

    private void ensureNotEmpty(){
        if (this.top == null){
            throw new IllegalArgumentException("No elements");
        }
    }
}
