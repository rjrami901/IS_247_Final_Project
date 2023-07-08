/*
File: Main.java
Name: Riya Rami
Date: 07/07/2023
Instructor: Prof. Shiva Sharma
Email: riyar1@umbc.edu
*/

package Finance_Manager;

import java.util.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();
        Map<String, Double> expenses = new HashMap<>();

        try {
            throw new RuntimeException("Sample Exception");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        int factorialResult = calculateFactorial(5);
        System.out.println("Factorial of 5: " + factorialResult);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.print("Enter your income: $");
        double income = scanner.nextDouble();

        User user = new User(name, age, income);
        System.out.println("User created successfully!");
        System.out.println("User: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Income: $" + user.getIncome());

        boolean exit = false;
        while (!exit) {
            System.out.println("Personal Finance Manager");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Generate financial report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the initial balance: ");
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
                case 2 -> {
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found. Please create an account first.");
                        break;
                    }
                    System.out.print("Enter the account index: ");
                    int accountIndex = scanner.nextInt();
                    if (accountIndex >= 0 && accountIndex < accounts.size()) {
                        System.out.print("Enter the deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        accounts.get(accountIndex).deposit(depositAmount);
                        System.out.println("Deposit successful. New balance: " + accounts.get(accountIndex).getBalance());
                    } else {
                        System.out.println("Invalid account index.");
                    }
                }
                case 3 -> {
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found. Please create an account first.");
                        break;
                    }
                    System.out.print("Enter the account index: ");
                    int accountIndex2 = scanner.nextInt();
                    if (accountIndex2 >= 0 && accountIndex2 < accounts.size()) {
                        System.out.print("Enter the withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        try {
                            accounts.get(accountIndex2).withdraw(withdrawalAmount);
                            System.out.println("Withdrawal successful. New balance: " + accounts.get(accountIndex2).getBalance());
                        } catch (InsufficientFundsException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Invalid account index.");
                    }
                }
                case 4 -> {
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found. Please create an account first.");
                        break;
                    }
                    scanner.nextLine(); // Consume newline character
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
                        scanner.nextLine(); // Consume newline character
                    }
                    FinancialReport reportGenerator = new ReportGenerator();
                    reportGenerator.generateReport(accounts, user, expenses);
                }
                case 5 -> {
                    exit = true;
                    System.out.println("Exiting Personal Finance Manager. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        ConcreteFinanceManager concreteFinanceManager = new ConcreteFinanceManager();
        concreteFinanceManager.printUserInfo();
        concreteFinanceManager.displayUserId();
        PersonalFinanceManager.staticMethod();
    }

    public static int calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}
