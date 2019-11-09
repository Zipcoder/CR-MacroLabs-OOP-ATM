public class Account {
    private Integer AccountID;
    private Double balance;

    public Account(){

    }

    public Account(Double balance){
        this.AccountID = 0;
        this.balance = balance;
    }

    public void deposit(Double amount){
        if(amount > 0.0){
            this.setBalance(this.getBalance() + amount);
        }
    }

    public Double withdraw(Double amount){
        if(amount > 0 && amount <= this.getBalance()){
            this.setBalance(this.getBalance() - amount);
        }
        return this.getBalance();
    }

    public void transfer(Account too, Double amount){
        if(this.balance >= amount && amount > 0){
            this.setBalance(this.getBalance() - amount);
            too.setBalance(too.getBalance() + amount);
        }
        Console.println("Sorry, not enough currency to transfer.");
    }

    public boolean closeAccount(){
        return (getBalance() == 0.0);
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
    public Double balance() {
        return balance;
    }


    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
