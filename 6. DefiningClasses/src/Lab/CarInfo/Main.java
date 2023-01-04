package Lab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split("\\s");

            String brand = carData[0];
            String model = carData[1];
            int horsePower = Integer.parseInt(carData[2]);

            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            carList.add(car);
        }

        carList.forEach(System.out::println);
    }
}
