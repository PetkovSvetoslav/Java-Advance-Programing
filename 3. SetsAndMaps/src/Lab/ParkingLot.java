package Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String direction = input.substring(0, input.indexOf(','));
            String carNumber = input.substring(input.indexOf(", ") + 2);
            switch (direction) {
                case "IN":
                    parking.add(carNumber);
                    break;
                case "OUT":
                    parking.remove(carNumber);
                    break;
            }
        }

        String output;
        if (parking.isEmpty()) {
            output = "Parking Lot is Empty";
        } else {
            output = parking
                    .stream()
                    .collect(Collectors.joining(System.lineSeparator()));
        }

        System.out.println(output);
    }
}
