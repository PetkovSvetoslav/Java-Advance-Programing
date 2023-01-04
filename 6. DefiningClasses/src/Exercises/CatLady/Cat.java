package Exercises.CatLady;

public class Cat {
    private final String breed;
    private final String name;
    private final double parameter;

    public Cat(String breed, String name, double parameter) {
        this.breed = breed;
        this.name = name;
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.breed, this.name, this.parameter);
    }
}
