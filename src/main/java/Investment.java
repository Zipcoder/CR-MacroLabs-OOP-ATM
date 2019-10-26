public class Investment extends Account implements Storeable {

    public Double risk;

    public Investment(Double balance, Integer ownerID, Integer acctNum) {
        super(balance, ownerID, acctNum);
        this.risk = risk;
    }

    public void setRisk(Double risk) {
        this.risk = risk;
    }

    public Double calcReturn(){
        return null;
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
