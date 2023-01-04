package Exercises.Tuple;

public class Threeuple <E1, E2, E3>{
    private E1 firstElement;
    private E2 secondElement;
    private E3 thirdElement;

    public Threeuple(E1 firstElement, E2 secondElement, E3 thirdElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.thirdElement = thirdElement;
    }

    @Override
    public String toString() {
        return this.firstElement +" -> " + this.secondElement + " -> " + this.thirdElement;
    }
}
