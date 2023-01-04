package Exercises.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double fuelPer1km = Double.parseDouble(carData[2]);

            Car car = new Car(model, fuelAmount, fuelPer1km);
            cars.put(model, car);
        }

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            if (tokens.length == 3) {
                String carModel = tokens[1];
                int amountOfKm = Integer.parseInt(tokens[2]);
                Car car = cars.get(carModel);
                if (!car.hasFuel(amountOfKm)){
                    System.out.println("Insufficient fuel for the drive");
                }
            }
        }
        cars.values().forEach(c -> System.out.printf("%s %.2f %d%n"
                , c.getModel(), c.getFuelAmount(), c.getTraveledDistance()));
    }
}
