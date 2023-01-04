package Exercises.SpeedRacing;

public class Car {
    private final String model;
    private double fuelAmount;
    private final double fuelPer1km;

    int traveledDistance;

    public Car(String model, double fuelAmount, double fuelPer1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPer1km = fuelPer1km;
        traveledDistance = 0;
    }

    public boolean hasFuel(int distance){
        if (this.fuelAmount - (distance * fuelPer1km) >= 0){
            this.fuelAmount -= distance * fuelPer1km;
            traveledDistance += distance;
            return true;
        }
        return false;
    }

    public String getModel() {
        return this.model;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public int getTraveledDistance() {
        return this.traveledDistance;
    }
}
