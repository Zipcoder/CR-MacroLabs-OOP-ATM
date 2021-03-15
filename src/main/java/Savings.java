public class Savings extends Account{

    public Savings(Integer accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void transferToChecking(Checking checkingAccount, double transferAmount) {
        if (this.getBalance() >= transferAmount) {
            this.withdraw(transferAmount);
            checkingAccount.deposit(transferAmount);
        }
    }

    public void transferToInvestment(Investment investmentAccount, double transferAmount) {
        if (this.getBalance() >= transferAmount) {
            this.withdraw(transferAmount);
            investmentAccount.deposit(transferAmount);
        }
    }
}
