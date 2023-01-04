package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacture, String model) {
        return this.data.removeIf(c -> c.getManufacturer().equals(manufacture)
                && c.getModel().equals(model));
    }

    public Car getLatestCar() {
        return this.data.stream()
                .max(Comparator.comparingInt(Car::getYear))
                .orElse(null);
    }

    public Car getCar(String manufacture, String model) {
        return this.data.stream()
                .filter(c-> c.getManufacturer().equals(manufacture)
                        && c.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("The cars are in a car dealership " + this.name + ":");
        for (Car car : this.data) {
            output.append(System.lineSeparator());
            output.append(car);
        }
        return output.toString();
    }
}
