package io.zipcoder.macrolabs.atm;

import java.util.ArrayList;

public class Account {
    private String accountName="";
    private final int ownedByUserID;
    private final int accountNumber;
    private static int nextAccountNumber;
    protected double balance=0;
    private ArrayList<String> transactionHistory=new ArrayList<>();

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

    protected String transactionBuilder(String descriptionOfChange, double amount){
        String lineItem="";
        lineItem+=descriptionOfChange + amount;
        return lineItem;
    }

    public void changeBalance(double amount){
        balance+=amount;
        changeTransactionHistory(transactionBuilder("Account, overload changeBalance   ", amount) );

    }

    public double getBalance(){
        return (balance);
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    protected void changeTransactionHistory(String lineItem){
        transactionHistory.add(lineItem);
    }

    public String getAccountName(){
        return accountName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountName(String passedAccountName) {
        accountName = passedAccountName;
    }

    public int getOwnerID(){
        return ownedByUserID;
    }

}
