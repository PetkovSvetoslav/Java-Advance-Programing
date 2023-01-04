package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Slow!!!
        //Mine
        ArrayDeque<Integer> plants = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int pesticides = scanner.nextInt();
            plants.offer(pesticides);
        }

        ArrayDeque<Integer> survivedPlants = new ArrayDeque<>();
        int dayCounter = 0;
        int counter =0;
        while (true) {
            if (!plants.isEmpty()) {
                int previousPlant = plants.peek();
                for (Integer plant : plants) {
                    counter++;
                    if (plant <= previousPlant) {
                        survivedPlants.offer(plant);
                    }
                    previousPlant = plant;
                }
                if (survivedPlants.size() == plants.size()) {
                    System.out.println(dayCounter);
                    System.out.println(counter);
                    return;
                }
                dayCounter++;
                plants = survivedPlants;
                survivedPlants = new ArrayDeque<>();
            }
            else {
                System.out.println(dayCounter);
                return;
            }
        }
    }
}
