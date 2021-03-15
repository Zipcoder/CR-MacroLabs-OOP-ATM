public abstract class Account {
    private final Integer accountNumber;
    private double balance;

    protected Account(Integer accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double withdraw(double amount) {
        if (balance >= amount && amount >= 0) {
            balance -= amount;
        }
        return balance;
    }

    public double deposit(double amount) {
        if (amount > 0) {
            return balance += amount;
        } else return balance;
    }

}
