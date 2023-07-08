/*
File: CheckingAccount.java
Name: Riya Rami
Email: riyar1@umbc.edu
*/

package Finance_Manager;

/* Checking account class inheriting from Account
* This class adds your balance to your Checking Account */
public class CheckingAccount extends Account {
    public CheckingAccount(double balance) {
        super(balance);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    /* This method does not withdraw money if the amount is higher than the balance */
    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new InsufficientFundsException("Insufficient funds in the checking account.");
        }
    }
}
