import java.util.ArrayList;

public class Account {
    private int accountNum;
    private double accountBalance;
    private char accountType;
    private double[] accountHistory = new double[3];

    ATM atm = ATM.getInstance();

    Account(){
    }
    public double[] getAccountHistory(){
        return accountHistory;
    }
    public void addToAccountHistory(double amount){
        accountHistory[0] = accountHistory[1];
        accountHistory[1] = accountHistory[2];
        accountHistory[2] = amount;
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

