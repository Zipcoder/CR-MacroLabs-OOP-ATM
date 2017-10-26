import java.util.ArrayList;

public class Account {

    private double balance;
    private int accountNum;
    private String accountType;
    private ArrayList<String> transactionHistory = new ArrayList<String>();


    public Account(double balance, int accountNum, String accountType) {
        this.balance = balance;
        this.accountNum = accountNum;
        this.accountType = accountType;

    }

    public double withdraw(double userAmount) {

        this.balance -= userAmount;
        return balance;
    }

    public double deposit(double userAmount) {

        this.balance += userAmount;
        return balance;
    }

    private void transferTo() {


    }

    private void viewTransactions() {

    }

    public double showBalance(double balanceAmount) {

        this.balance = balanceAmount;
        return balanceAmount;
    }

    double getBalance() {

        return balance;
    }

    public void setBalance(double newBalance) {


    }

    int getAccountNum() {

        return accountNum;
    }

    public void setAccountNum(double newAccountNum) {

    }

    String getAccountType() {

        return accountType;
    }

    public ArrayList<String> getTransactionHistory() {

        return transactionHistory;
    }


}
