package Lab.Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split("\\s+");

            String brand = carData[0];
            Car car;
            if (carData.length == 1) {
                car = new Car(brand);
            } else {
                String model = carData[1];
                int horsePower = Integer.parseInt(carData[2]);
                car = new Car(brand, model, horsePower);
            }
            cars[i] = car;
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
