/*
File: SavingsAccount.java
Name: Riya Rami
Email: riyar1@umbc.edu
*/

package Finance_Manager;

/* Savings account class inheriting from Account
* This class adds your balance to your Savings Account */
public class SavingsAccount extends Account {
    public SavingsAccount(double balance) {
        super(balance);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new InsufficientFundsException("Insufficient funds in the savings account.");
        }
    }
}
