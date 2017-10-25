package foutain.donald.atmproject.bettercopy.AccountFunctions;

import java.util.ArrayList;

public class Account {

    private int accountNumber;

    private double accountBalance;

    private String typeOfAccount;

    private ArrayList<String> transactionHistory;

    //Getter and Setter for TypeOfAccount

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    //Getter and Setter for AccountNumber

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    //Getter and Setter for AccountBalance

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    //Getter and Setter for TransactionHistory

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(ArrayList<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    //Methods for Accounts

    public String withdrawMoney(double withdrawAmount){

        this.accountBalance -= withdrawAmount;

        return "Your new account balance is: " + accountBalance;
    }

    public String closeAccount(){

        return "Your account has been closed";
    }

    public String depositMoney(double depositAmount){

        this.accountBalance += depositAmount;

        return "Your new account balance is: " + accountBalance;
    }

    public ArrayList<String > printTransactionHistory(ArrayList<String> transactionHistory){

        return this.transactionHistory;
    }

    public String openAccountType(){

        return "You have just opened a " + typeOfAccount;
    }
}
