package io.zipcoder.macrolabs.atm;

import java.util.ArrayList;

public class Account {
    private String accountName="";
    private final int ownedByUserID;
    private final int accountNumber;
    private static int nextAccountNumber;
    private double balance=0;
    private ArrayList<Double> transactionHistory=new ArrayList();

    static{
        nextAccountNumber=1;
    }

    //Object initialization block
    {
        accountNumber=nextAccountNumber;
        nextAccountNumber++;
    }

    public Account(int passedOwnerUserID)
    {
        ownedByUserID=passedOwnerUserID;
    }

    public Account(int passedOwnerUserID, String passedAccountName){
        accountName=passedAccountName;
        ownedByUserID=passedOwnerUserID;
    }

    public void changeBalance(double amount){
        balance+=amount;
        changeTransactionHistory(amount);
    }

    public double getBalance(){
        return (balance);
    }

    public ArrayList<Double> getTransactionHistory() {
        return transactionHistory;
    }

    private void changeTransactionHistory(double passedAmount){
        transactionHistory.add(passedAmount);
    }

    public String getAccountName(){
        return accountName;
    }

    public void setAccountName(String passedAccountName) {
        accountName = passedAccountName;
    }

    public int getOwnerID(){
        return ownedByUserID;
    }

}
