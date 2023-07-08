/*
File: Account.java
Name: Riya Rami
Email: riyar1@umbc.edu
*/

package Finance_Manager;

/* Abstract class representing a financial account */
public abstract class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount) throws InsufficientFundsException;
}
