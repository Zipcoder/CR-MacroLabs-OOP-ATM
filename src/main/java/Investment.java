public class Investment extends Account {

    public Investment(Integer accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void transferToSavings(Savings savingsAccount, double transferAmount) {
        if (this.getBalance() >= transferAmount) {
            this.withdraw(transferAmount);
            savingsAccount.deposit(transferAmount);
        }
    }

    public void transferToChecking(Checking checkingAccount, double transferAmount) {
        if (this.getBalance() >= transferAmount) {
            this.withdraw(transferAmount);
            checkingAccount.deposit(transferAmount);
        }
    }
}
