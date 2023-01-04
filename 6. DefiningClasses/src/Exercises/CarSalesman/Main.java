package Exercises.CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Works only because of the Buffer (Time errors in judge)
//The code is clearly not optimal

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Engine> engines = new HashMap<>();

        int n = Integer.parseInt(scanner.readLine());
        for (int i = 0; i < n; i++) {
            String[] engineData = scanner.readLine().split("\\s+");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);

            Engine engine = readEngine(engineData, model, power);
            engines.put(model, engine);
        }

        List<Car> cars = new ArrayList<>();

        int m = Integer.parseInt(scanner.readLine());
        for (int i = 0; i < m; i++) {
            String[] carData = scanner.readLine().split("\\s+");
            String carModel = carData[0];
            String engineModel = carData[1];

            Car car = readCar(carData, carModel, engineModel, engines);
            cars.add(car);
        }

        cars.forEach(System.out::println);
    }

    private static Car readCar(String[] carData, String carModel, String engineModel, Map<String, Engine> engines) {
        Engine engine = engines.get(engineModel);
        switch (carData.length) {
            case 3: {
                if (isANumber(carData[2])) {
                    int weight = Integer.parseInt(carData[2]);
                    return new Car(carModel, engine, weight);
                } else {
                    String color = carData[2];
                    return new Car(carModel, engine, color);
                }
            }
            case 4: {
                int weight;
                String color;

                if (isANumber(carData[2])) {
                    weight = Integer.parseInt(carData[2]);
                    color = carData[3];
                } else {
                    color = carData[2];
                    weight = Integer.parseInt(carData[3]);
                }
                return new Car(carModel, engine, weight, color);
            }
            default:
                return new Car(carModel, engine);
        }
    }

    private static Engine readEngine(String[] engineData, String model, int power) {
        switch (engineData.length) {
            case 3: {
                if (isANumber(engineData[2])) {
                    int displacement = Integer.parseInt(engineData[2]);
                    return new Engine(model, power, displacement);
                } else {
                    String efficiency = engineData[2];
                    return new Engine(model, power, efficiency);
                }
            }
            case 4: {
                int displacement;
                String efficiency;

                if (isANumber(engineData[2])) {
                    displacement = Integer.parseInt(engineData[2]);
                    efficiency = engineData[3];
                } else {
                    efficiency = engineData[2];
                    displacement = Integer.parseInt(engineData[3]);
                }
                return new Engine(model, power, displacement, efficiency);
            }
            default:
                return new Engine(model, power);
        }
    }

    public static boolean isANumber(String line) {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }
}
