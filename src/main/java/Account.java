public class Account {
    private Integer AccountID;
    private Double balance;

    public Account(){

    }

    public Account(Double balance){
        this.balance = balance;
    }


    //////GETTERS AND SETTERS//////
    public Integer getAccountID() {
        return AccountID;
    }

    public void setAccountID(Integer accountID) {
        AccountID = accountID;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
