public class Savings extends Account{

    public Double interestRate;

    public Savings(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public Double getBalance() {
        return super.getBalance();
    }

    @Override
    public void transferToAnother() {
        super.transferToAnother();
    }

    @Override
    public void transferWithin() {
        super.transferWithin();
    }

    @Override
    public void withdraw(Double amount) {
        super.withdraw(amount);
    }

    @Override
    public void getAcctHist() {
        super.getAcctHist();
    }

    @Override
    public void deposit(Double amount) {
        super.deposit(amount);
    }
}
