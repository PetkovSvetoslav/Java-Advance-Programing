package Exercises.Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nameAddress = scanner.nextLine().split("\\s+");
        String name = nameAddress[0] + " " + nameAddress[1];
        String address = nameAddress[2];
        String city = nameAddress[3];
        Threeuple<String, String, String> personData = new Threeuple<>(name,address, city);
        System.out.println(personData);

        String[] nameLitresOfBeer = scanner.nextLine().split("\\s+");
        name = nameLitresOfBeer[0];
        Integer litresOfBeer = Integer.valueOf(nameLitresOfBeer[1]);
        Boolean drunk = nameLitresOfBeer[2].equals("drunk");
        Threeuple<String, Integer, Boolean> drinkerData = new Threeuple<>(name, litresOfBeer, drunk);
        System.out.println(drinkerData);

        String[] bankAccount = scanner.nextLine().split("\\s+");
        name = bankAccount[0];
        Double balance = Double.parseDouble(bankAccount[1]);
        String bankName = bankAccount[2];
        Threeuple<String, Double, String> bankAccountData = new Threeuple<>(name, balance, bankName);
        System.out.println(bankAccountData);
    }
}
