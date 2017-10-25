public class Account {

    public static int accountCounter;

    private int acctNumber;
    private String type;
    private double balance;

    Account(String type){
        this.acctNumber = Account.accountCounter++;
        this.type = type;
        this.balance = 0;

    };

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAcctNumber() {
        return acctNumber;
    }

    public void setAcctNumber(int acctNumber) {
        this.acctNumber = acctNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
