package Exercises.CarSalesman;

public class Car {
    private final String model;
    private final Engine engine;
    private final int weight; //optional
    private final String color; //optional

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, 0, color);
    }

    public Car(String model, Engine engine) {
        this(model, engine, 0, "n/a");
    }

    @Override
    public String toString() {
        String output = this.model + ":"
                + System.lineSeparator()
                + this.engine
                + System.lineSeparator()
                + "Weight: " + (this.weight == 0 ? "n/a" : this.weight)
                + System.lineSeparator()
                + "Color: " + this.color;
        return output.trim();
    }
}
