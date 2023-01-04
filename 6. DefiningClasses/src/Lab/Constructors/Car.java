package Lab.Constructors;

public class Car {
    String brand;
    String model;
    int horsePower;

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String brand) {
        this(brand, "unknown", -1);
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", brand, model, horsePower);
    }
}
