import java.util.ArrayList;

public /*abstract*/ class Account {
    private int accountNum;
    private double accountBalance;
    private String accountType;
    private ArrayList accountHistory = new ArrayList();

    ATM atm = ATM.getInstance();

    Account(){}

    void setBalance(double balanceGiven){
        accountBalance = balanceGiven;
    }

    double getBalance(){
        return accountBalance;
    }

    void setType(String type){
        accountType = type;
    }
    String getType(){
        return accountType;
    }



    void setAccountNum(){
        this.accountNum = atm.returnNewAccountNum();
    }

    int getAccountNum(){
        return accountNum;
    }

    ArrayList getAccountHistory(){
        return accountHistory;
    }

    void addToAccountHistory(String newTransaction){
        accountHistory.add(newTransaction);
    }

}

