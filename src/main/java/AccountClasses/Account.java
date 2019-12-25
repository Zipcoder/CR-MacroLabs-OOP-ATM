package AccountClasses;

public abstract class Account {
    Double balance=0.00;
    Integer counter=1;
    String accountNum = "A" + counter;


    public Account() {
        balance = 0.00;
        counter++;
        //give account number;
    }



    public Double getAccountBal()
    {
        return this.balance ;
    }

    public String getAccountNum ()
    {
        return this.accountNum;
    }

    public Double withdraw(Double withdrawalAmt) {
        //Error.checkIfEnough(withdrawalAmt, balance);
        return this.balance - withdrawalAmt;
    }

    public double deposit(Double depositAmt) {

        balance = balance + depositAmt;
        return balance;
    }
    public Double transfer()
    {
        return null;
    }

}
