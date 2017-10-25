package foutain.donald.atmproject.bettercopy.AccountFunctions;

import java.util.ArrayList;

public class Account {

    private int accountNumber;

    private double accountBalance;

    private String typeOfAccount;

    private ArrayList<String> transactionHistory;

    public double getAccountBalance(){

        return this.accountBalance;
    }

    public double withdrawMoney(int withdrawAmount){

        this.accountBalance -= withdrawAmount;

        return accountBalance;
    }

    public String closeAccount(){

        return "Your account has been closed";
    }

    public double depositMoney(int depositAmount){

        this.accountBalance += depositAmount;

        return accountBalance;
    }

    public ArrayList<String > printTransactionHistory(ArrayList<String> transactionHistory){

        return this.transactionHistory;
    }

    public String openAccountType(){

        return typeOfAccount;
    }
}
