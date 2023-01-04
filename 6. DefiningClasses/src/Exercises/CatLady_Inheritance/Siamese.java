package Exercises.CatLady_Inheritance;

public class Siamese extends Cat {
    private double earSize;

    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %.2f", this.earSize);
    }
}
