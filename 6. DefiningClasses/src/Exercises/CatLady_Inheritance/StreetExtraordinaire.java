package Exercises.CatLady_Inheritance;

public class StreetExtraordinaire extends Cat {
    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %.2f", this.decibelsOfMeows);
    }
}
