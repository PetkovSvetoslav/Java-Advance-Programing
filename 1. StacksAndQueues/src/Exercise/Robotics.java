package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    private static class Robot {
        String name;
        int processingTime;

        Robot(String name, int processingTime) {
            this.name = name;
            this.processingTime = processingTime;
        }

        public String getName() {
            return this.name;
        }

        public int getProcessingTime() {
            return this.processingTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Robot[] robots = parseLineOfRobots(scanner);
        int startingTimeInSeconds = parseTimeInSeconds(scanner);
        String productInput;
        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        while (!"End".equals(productInput = scanner.nextLine())) {
            productsQueue.offer(productInput);
        }

        int[] robotsWorkTimeLeft = new int[robots.length];
        while (!productsQueue.isEmpty()) {
            startingTimeInSeconds++;
            String product = productsQueue.poll();
            int index = -1; //assume that the robot is NOT available
            for (int i = 0; i < robotsWorkTimeLeft.length; i++) {
                //robot is working
                if (robotsWorkTimeLeft[i] > 0) {
                    robotsWorkTimeLeft[i]--;
                }
                //give the index of a free robot
                if (robotsWorkTimeLeft[i] == 0 && index == -1) {
                    index = i;
                }
            }

            if (index != -1) {
                //assign the product to a robot
                robotsWorkTimeLeft[index] = robots[index].getProcessingTime();
                System.out.println(robotWorkingData(robots[index].getName(), product, startingTimeInSeconds));
            } else {
                //index = -1 -> all robots are busy
                //returns the product in the queue
                productsQueue.offer(product);
            }
        }
    }

    private static String robotWorkingData(String name, String product, int startingTimeInSeconds) {
        int hours = (startingTimeInSeconds / 3600) % 24;
        int mins = (startingTimeInSeconds / 60) % 60;
        int sec = startingTimeInSeconds % 60;
        return String.format("%s - %s [%02d:%02d:%02d]", name, product, hours, mins, sec);
    }

    private static Robot[] parseLineOfRobots(Scanner scanner) {
        String[] robotsAsString = scanner.nextLine().split(";");
        Robot[] robots = new Robot[robotsAsString.length];
        for (int i = 0; i < robots.length; i++) {
            String[] tokens = robotsAsString[i].split("-");
            String name = tokens[0];
            int processTime = Integer.parseInt(tokens[1]);
            Robot robot = new Robot(name, processTime);
            robots[i] = robot;
        }
        return robots;
    }

    private static int parseTimeInSeconds(Scanner scanner) {
        String startingTame = scanner.nextLine();
        String[] time = startingTame.split(":");
        int hours = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        int sec = Integer.parseInt(time[2]);

        return (((hours * 60) + min) * 60) + sec;
    }
}
