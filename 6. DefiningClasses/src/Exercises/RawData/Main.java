package Exercises.RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Car>> deliveryCars = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            double tire1Pressure = Double.parseDouble(data[5]);
            int tire1Age = Integer.parseInt(data[6]);
            double tire2Pressure = Double.parseDouble(data[7]);
            int tire2Age = Integer.parseInt(data[8]);
            double tire3Pressure = Double.parseDouble(data[9]);
            int tire3Age = Integer.parseInt(data[10]);
            double tire4Pressure = Double.parseDouble(data[11]);
            int tire4Age = Integer.parseInt(data[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tires = new Tire(tire1Pressure, tire2Pressure, tire3Pressure, tire4Pressure
                    , tire1Age, tire2Age, tire3Age, tire4Age);
            Car car = new Car(model, engine, cargo, tires);

            deliveryCars.putIfAbsent(cargoType, new ArrayList<>());
            deliveryCars.get(cargoType).add(car);
        }

        String searchingType = scanner.nextLine();
        switch (searchingType) {
            case "fragile":
                deliveryCars.get("fragile")
                        .stream()
                        .filter(c -> {
                            return c.getTires().getTire1Pressure() < 1
                                    || c.getTires().getTire2Pressure() < 1
                                    || c.getTires().getTire3Pressure() < 1
                                    || c.getTires().getTire4Pressure() < 1;
                        }).forEach(c -> System.out.println(c.getModel()));
                break;
            case "flamable":
                deliveryCars.get("flamable")
                        .stream()
                        .filter(c -> c.getEngine().getPower() > 250)
                        .forEach(c -> System.out.println(c.getModel()));
                break;
        }
    }
}
