package Finance_Manager;

// Checking account class inheriting from Account
class CheckingAccount extends Account {
    public CheckingAccount(double balance) {
        super(balance);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new InsufficientFundsException("Insufficient funds in the checking account.");
        }
    }
}
