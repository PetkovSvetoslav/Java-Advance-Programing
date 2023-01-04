package Exercises.Tuple;

public class Tuple<E1, E2> {
    private E1 firstElement;
    private E2 secondElement;

    public Tuple(E1 firstElement, E2 secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    @Override
    public String toString() {
        return this.firstElement + " -> " + this.secondElement;
    }
}
