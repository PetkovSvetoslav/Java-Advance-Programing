package Exercises;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class SmartLinkedList {
    private static class Node {
        int element;
        Node next;
        Node previous;

        private Node(int element) {
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public SmartLinkedList() {
    }

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (this.head != null) {
            this.head.previous = newNode;
            newNode.next = this.head;
        }
        this.head = newNode;
        if (isEmpty()) {
            this.tail = this.head;
        }
        this.size++;
    }

    public void addLast(int element) {
        Node newNode = new Node(element);
        if (this.tail != null) {
            this.tail.next = newNode;
            newNode.previous = this.tail;
        }
        this.tail = newNode;
        if (isEmpty()) {
            this.head = this.tail;
        }
        this.size++;
    }

    public int removeFirst() {
        validateElements();
        int removedElement = this.head.element;

        this.head = this.head.next;
        if (this.head != null) {
            this.head.previous = null;
        }
        this.size--;
        return removedElement;
    }

    public int removeLast() {
        validateElements();

        int removedElement = this.tail.element;

        this.tail = this.tail.previous;
        if (this.tail != null) {
            this.tail.next = null;
        }
        this.size--;
        return removedElement;
    }

    public int getFirst() {
        validateElements();
        return this.head.element;
    }

    public int getLast() {
        validateElements();
        return this.tail.element;
    }

    public int get(int index) {
        validateIndex(index);

        Node currentNode = this.head;
        int element = 0;
        int i = 0;
        while (currentNode != null) {
            if (i == index) {
                element = currentNode.element;
            }
            currentNode = currentNode.next;
            i++;
        }
        return element;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;
        while (currentNode != null) {
            int element = currentNode.element;
            consumer.accept(element);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] array = new int[this.size];

        Node currentNode = this.head;
        for (int i = 0; i < this.size; i++) {
            int element = currentNode.element;
            array[i] = element;
            currentNode = currentNode.next;
        }
        return array;
    }

    private void validateElements() {
        if (isEmpty()) {
            throw new NoSuchElementException
                    ("The data structure from which you are trying to remove is empty");
        }
    }

    private void validateIndex(int index) {
        if (0 > index || index >= this.size) {
            throw new IndexOutOfBoundsException
                    ("Index " + index + " out of bound for size " + this.size);
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
