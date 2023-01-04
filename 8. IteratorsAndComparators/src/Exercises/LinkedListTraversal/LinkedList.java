package Exercises.LinkedListTraversal;

import java.util.Iterator;

public class LinkedList implements Iterable<Integer> {
    private class Node {
        private int element;
        private Node prev;
        private Node next;

        private Node(int element) {
            this.element = element;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void add(int element) {
        Node newNode = new Node(element);
        newNode.prev = this.last;
        if (this.last != null) {
            this.last.next = newNode;
        }
        this.last = newNode;
        if (isEmpty()) {
            this.first = this.last;
        }
        this.size++;
    }

    public boolean remove(int element) {
        Node currentNode = first;
        for (int i = 0; i < this.size; i++) {
            int currentElement = currentNode.element;
            if (currentElement == element) {
                unlink(currentNode);
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }


    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    private void unlink(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        if (next != null) {
            next.prev = prev;
        } else {
            this.last = prev;
        }

        if (prev != null) {
            prev.next = next;
        } else {
            this.first = next;
        }
    }

    private class LinkedListIterator implements Iterator<Integer> {
        Node currentNode = first;

        @Override
        public boolean hasNext() {
            return this.currentNode != null;
        }

        @Override
        public Integer next() {
            int element = this.currentNode.element;
            this.currentNode = currentNode.next;
            return element;
        }
    }

    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }
}
