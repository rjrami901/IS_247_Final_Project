package Finance_Manager;

// Savings account class inheriting from Account
class SavingsAccount extends Account {
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
