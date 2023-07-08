/*
File: ReportGenerator.java
Name: Riya Rami
Email: riyar1@umbc.edu
*/

package Finance_Manager;

import java.util.List;
import java.util.Map;

/* Financial report generator class implementing FinancialReport interface
* This class generates the user information, including name, age, and income,
* the total checking and savings amount, and a list of all the expenses the user added. */
public class ReportGenerator implements FinancialReport {
    @Override
    public void generateReport(List<Account> accounts, User user, Map<String, Double> expenses) {
        System.out.println("-----------------------------------------");
        System.out.println("Generating financial report...");
        System.out.println("-----------------------------------------");
        System.out.println("User: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Income: $" + user.getIncome());

        double totalSavings = 0;
        double totalChecking = 0;

        for (Account account : accounts) {
            if (account instanceof SavingsAccount) {
                totalSavings += account.getBalance();
            } else if (account instanceof CheckingAccount) {
                totalChecking += account.getBalance();
            }
        }

        System.out.println("-----------------------------------------");
        System.out.println("Total Money in Savings Account: $" + totalSavings);
        System.out.println("Total Money in Checking Account: $" + totalChecking);
        System.out.println("-----------------------------------------");

        System.out.println("Expenses:");
        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
        System.out.println("-----------------------------------------");
    }
}
