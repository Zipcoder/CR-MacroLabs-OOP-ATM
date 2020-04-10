import java.util.ArrayList;

public class Account {
    private int accountNum;
    private double accountBalance;
    private String accountType;
    private ArrayList accountHistory = new ArrayList();

    ATM atm = ATM.getInstance();

    Account(String accountType){
        this.accountType = accountType;
    }

    void setBalance(double balanceGiven) {
        accountBalance = balanceGiven;
    }

    double getBalance() {
        return accountBalance;
    }

    void setAccountNum() {
        this.accountNum = atm.returnNewAccountNum();
    }

    int getAccountNum() {
        return accountNum;
    }

    String getAccountType(){
        return accountType;
    }

    ArrayList getAccountHistory() {
        return accountHistory;
    }

    void addToAccountHistory(String newTransaction) {
        accountHistory.add(newTransaction);
    }
}