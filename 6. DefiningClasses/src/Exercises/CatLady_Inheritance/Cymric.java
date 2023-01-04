package Exercises.CatLady_Inheritance;

public class Cymric extends Cat {
    private double furLength;

    public Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %.2f", this.furLength);
    }
}
