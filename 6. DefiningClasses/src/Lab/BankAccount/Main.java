package Lab.BankAccount;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            String output = "";

            switch (command) {
                case "Create": {
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    output = String.format("Account ID%d created", account.getId());
                }
                break;
                case "Deposit": {
                    int id = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);
                    BankAccount account = accounts.get(id);
                    if (account == null) {
                        output = "Account does not exist";
                    } else {
                        account.deposit(amount);
                        DecimalFormat df = new DecimalFormat("#,#######");
                        output = String.format("Deposited %s to ID%d", df.format(amount), id);
                    }
                }
                break;
                case "SetInterest": {
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                }
                break;
                case "GetInterest": {
                    int id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    BankAccount account = accounts.get(id);
                    if (account == null) {
                        output = "Account does not exist";
                    } else {
                        output = String.format("%.2f", account.getInterestRate(years));
                    }
                }
                break;
            }
            if (!output.equals("")) {
                System.out.println(output);
            }
        }
    }
}
