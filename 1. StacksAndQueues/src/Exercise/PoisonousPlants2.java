package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PoisonousPlants2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Unsolved!!!!

        int n = Integer.parseInt(scanner.nextLine());
        int[] plants = new int[n];
        for (int i = 0; i < n; i++) {
            plants[i] = scanner.nextInt();
        }

        int min = plants[0];
        int[] daySpan = new int[plants.length];
        ArrayDeque<Integer> indexStack = new ArrayDeque<>();
        int maxSpam = 1;
        for (int i = 0; i < plants.length; i++) {
            if (min >= plants[i]) {
                min = plants[i];
                daySpan[i] = Integer.MAX_VALUE;
                continue;
            }
            if(indexStack.isEmpty()){
                indexStack.push(i);
                daySpan[i] = 1;
                continue;
            }

            int poppedIndex = indexStack.pop();

            if (plants[i] > plants[poppedIndex]){
                daySpan[i] = 1;
            }

           if (plants[i] <= plants[poppedIndex]){
                daySpan[i] = daySpan[poppedIndex] + 1;
                maxSpam = daySpan[i];
            }
        }
        System.out.println(maxSpam);
    }
}
