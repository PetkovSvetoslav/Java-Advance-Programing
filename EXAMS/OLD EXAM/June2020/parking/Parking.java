package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> cars;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.cars = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > cars.size()) {
            cars.add(car);
        }
    }

    public boolean remove(String manufacture, String model) {
        return this.cars.removeIf(c -> c.getManufacturer().equals(manufacture)
                && c.getModel().equals(model));
    }

    public Car getLatestCar() {
        return this.cars.stream()
                .max(Comparator.comparingInt(Car::getYear))
                .orElse(null);
    }

    public Car getCar(String manufacture, String model) {
        return this.cars.stream()
                .filter(c-> c.getManufacturer().equals(manufacture)
                        && c.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.cars.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("The cars are parked in " + this.type + ":");
        for (Car car : this.cars) {
            output.append(System.lineSeparator());
            output.append(car);
        }
        return output.toString();
    }
}
