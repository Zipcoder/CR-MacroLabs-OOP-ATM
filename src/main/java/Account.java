

public class Account {
    private int accountNum;
    private double accountBalance;
    private char accountType;

    ATM atm = ATM.getInstance();

    Account(){
    }

    public void setAccountNum(){
        this.accountNum = atm.returnNewAccountNum();
    }

    public int getAccountNum(){
        return accountNum;
    }

    public void setBalance(double balanceGiven){
        accountBalance = balanceGiven;
    }

    public double getBalance(){
        return accountBalance;
    }

    public void setType(char type){
        accountType = type;
    }

    public char getType(){
        return accountType;
    }

}

