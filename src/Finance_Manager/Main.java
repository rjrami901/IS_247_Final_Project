/*
File: Main.java
Name: Riya Rami
Email: riyar1@umbc.edu
*/

package Finance_Manager;

import java.util.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();
        Map<String, Double> expenses = new HashMap<>();

        int factorialResult = calculateFactorial(5);
        System.out.println("Factorial of 5: " + factorialResult);

        /* Asks for user information */
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.print("Enter your income: $");
        double income = scanner.nextDouble();

        /* Prints user information */
        User user = new User(name, age, income);
        System.out.println("User created successfully!");
        System.out.println("User: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Income: $" + user.getIncome());

        boolean exit = false;
        while (!exit) {
            /* Loops these options once you complete an option until you choose to exit */
            System.out.println();
            System.out.println("Personal Finance Manager");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Add Expenses");
            System.out.println("5. Generate financial report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            /* Asks to enter initial balance and add to either checking or savings account.
            If you type something else, then it will show Invalid account message. */
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the initial balance: $");
                    double initialBalance = scanner.nextDouble();
                    System.out.print("Choose account type (1 - Checking, 2 - Savings): ");
                    int accountType = scanner.nextInt();
                    if (accountType == 1) {
                        accounts.add(new CheckingAccount(initialBalance));
                    } else if (accountType == 2) {
                        accounts.add(new SavingsAccount(initialBalance));
                    } else {
                        System.out.println("Invalid account type.");
                    }
                }

                /* Asks to enter account index and then enter the amount you want to deposit.
                Then adds the new balance by adding the deposit amount and the previous balance amount from
                checking account. */
                case 2 -> {
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found. Please create an account first.");
                        break;
                    }
                    System.out.print("Enter the account index: ");
                    int accountIndex = scanner.nextInt();
                    if (accountIndex >= 0 && accountIndex < accounts.size()) {
                        System.out.print("Enter the deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        accounts.get(accountIndex).deposit(depositAmount);
                        System.out.println("Deposit successful. New balance: $" + accounts.get(accountIndex).getBalance());
                    } else {
                        System.out.println("Invalid account index.");
                    }
                }

                /* Asks to enter account index and then enter the amount you want to withdraw.
                Then adds the new balance by subtracting the previous balance amount and the withdraw amount from
                checking account. */
                case 3 -> {
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found. Please create an account first.");
                        break;
                    }
                    System.out.print("Enter the account index: ");
                    int accountIndex2 = scanner.nextInt();
                    if (accountIndex2 >= 0 && accountIndex2 < accounts.size()) {
                        System.out.print("Enter the withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        try {
                            accounts.get(accountIndex2).withdraw(withdrawalAmount);
                            System.out.println("Withdrawal successful. New balance: $" + accounts.get(accountIndex2).getBalance());
                        } catch (InsufficientFundsException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Invalid account index.");
                    }
                }

                /* Asks what expenses you want to add and the amount of those expenses */
                case 4 -> {
                    scanner.nextLine(); //
                    System.out.println("Enter your expenses (press enter to finish):");
                    String expenseName;
                    double expenseAmount;
                    while (true) {
                        System.out.print("Expense name: ");
                        expenseName = scanner.nextLine();
                        if (expenseName.isEmpty()) {
                            break;
                        }
                        System.out.print("Expense amount: $");
                        expenseAmount = scanner.nextDouble();
                        expenses.put(expenseName, expenseAmount);
                        scanner.nextLine();
                    }
                }

                /* Prints the financial report from the FinancialReport class */
                case 5 -> {
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found. Please create an account first.");
                        break;
                    }

                    System.out.println();
                    FinancialReport reportGenerator = new ReportGenerator();
                    reportGenerator.generateReport(accounts, user, expenses);
                }
                case 6 -> {
                    exit = true;
                    System.out.println("Exiting Personal Finance Manager. \nThank you! :)");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static int calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}
