public class Checking extends Account{

    public Checking(Integer accountNumber, double balance) {
        super(accountNumber,balance);
    }

    public void transferToSavings(Savings savingsAccount, double transferAmount) {
        if (this.getBalance() >= transferAmount) {
            this.withdraw(transferAmount);
            savingsAccount.deposit(transferAmount);
        }
    }

    public void transferToInvestment(Investment investmentAccount, double transferAmount) {
        if (this.getBalance() >= transferAmount) {
            this.withdraw(transferAmount);
            investmentAccount.deposit(transferAmount);
        }
    }
}
