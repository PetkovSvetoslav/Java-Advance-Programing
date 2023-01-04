package src.RawData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLines = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();
        List<Tyres> tyresList = new ArrayList<>();
        for (int i = 0; i < numLines; i++) {

            List<String> info = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

            String model = info.get(0);
            int engineSpeed = Integer.parseInt(info.get(1));
            int enginePower = Integer.parseInt(info.get(2));
            int cargoWeight = Integer.parseInt(info.get(3));
            String cargoType = info.get(4);

            //FOR  CAR
            Car currentCar = new Car(model
                    ,engineSpeed
                    ,enginePower
                    ,cargoWeight
                    ,cargoType);

            carList.add(currentCar);

            double presureTyre1 = Double.parseDouble(info.get(5));
            int tyre1Age = Integer.parseInt(info.get(6));
            double presureTyre2 = Double.parseDouble(info.get(7));
            int tyre2Age = Integer.parseInt(info.get(8));
            double presureTyre3 = Double.parseDouble(info.get(9));
            int tyre3Age = Integer.parseInt(info.get(10));
            double presureTyre4 = Double.parseDouble(info.get(11));
            int tyre4Age = Integer.parseInt(info.get(12));

            //FOR TYRES

            Tyres currentTyres = new Tyres(presureTyre1,tyre1Age
                    ,presureTyre2,tyre2Age
                    ,presureTyre3,tyre3Age
                    ,presureTyre4,tyre4Age);

            tyresList.add(currentTyres);

        }
        String command = scanner.nextLine();

        if(command.equals("fragile")){
          fragile(carList,tyresList,command);
        }
        else if (command.equals("flamable")){
            flamable(carList,command);
        }
    }

    private static void fragile (List<Car> carList, List<Tyres> tyresList,String command){
        for (int i = 0; i <carList.size() ; i++) {
            if (carList.get(i).getCargoType().equals(command)){
                double tyre1Pressure= tyresList.get(i).getTyre1();
                double tyre2Pressure= tyresList.get(i).getTyre2();
                double tyre3Pressure= tyresList.get(i).getTyre3();
                double tyre4Pressure= tyresList.get(i).getTyre4();
                if (tyre1Pressure<1 || tyre2Pressure<1 || tyre3Pressure<1 || tyre4Pressure<1){
                    System.out.println(carList.get(i).getModel());
                }
            }
        }
    }
    private static void flamable(List<Car> carList,String command) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getCargoType().equals(command)) {
                int enginePower = carList.get(i).getEnginePower();
                if (enginePower>250){
                    System.out.println(carList.get(i).getModel());
                }
            }
        }
    }

}
