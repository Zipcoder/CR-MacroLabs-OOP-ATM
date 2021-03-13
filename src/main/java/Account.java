
public abstract class Account {

    private int acctnumber;
    private double balance;


    public Account(){
        this.acctnumber = AccountWarehouse.getAccounts().size();
        this.balance = 0;
        //nextAvailableAcctNumber++;
    }

    public Account(double initial_deposit){
        this();
        this.balance = initial_deposit;
    }

    public void setAcctNumber(int acctnumber) {
        this.acctnumber = acctnumber;
    }


    public int getAcctNumber() {
        return acctnumber;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }


    public double getBalance() {
        return balance;
    }

    public String deposit(double deposit) {

        balance += deposit;

        return "Your new balance is $" + String.format("%,.2f", balance);

    }

    public String withdrawl(double withdrawl){

        balance -= withdrawl;

        return "Your new balance is $" + String.format("%,.2f", balance);

    }

    public String transfer(Account toAccount, double amount){

        balance -= amount;

        toAccount.balance += amount;


        return "Transfer complete. New 'from' balance is $" + String.format("%,.2f", this.getBalance()) + ". Your new 'to' balance is $" + String.format("%,.2f", toAccount.getBalance())+".";
    }

//    @Override
//    public String toString(){
//        return "Account# " + this.acctnumber;


}







