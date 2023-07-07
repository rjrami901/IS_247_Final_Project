package Finance_Manager;

import java.util.List;

// Financial report generator class implementing FinancialReport interface
class ReportGenerator implements FinancialReport<Account> {
    @Override
    public void generateReport(List<Account> accounts) {
        System.out.println("Generating financial report...");
        System.out.println("Financial Report");
        System.out.println("----------------");

        for (Account account : accounts) {
            String accountType = account instanceof CheckingAccount ? "Checking Account" : "Savings Account";
            double balance = account.getBalance();

            System.out.println("Account Type: " + accountType);
            System.out.println("Balance: $" + balance);
            System.out.println("----------------");
        }
    }
}
