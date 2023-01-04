package Exercises.CarSalesman;

public class Engine {
    private final String model;
    private final int power;
    private final int displacement; //optional
    private final String efficiency; //optional

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this(model, power, 0, "n/a");
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, 0, efficiency);
    }

    @Override
    public String toString() {
        String output = this.model + ":" +
                System.lineSeparator() +
                "Power: " + this.power +
                System.lineSeparator() +
                "Displacement: " + (this.displacement == 0 ? "n/a" : this.displacement) +
                System.lineSeparator() +
                "Efficiency: " + this.efficiency;
        return output.trim();
    }
}
