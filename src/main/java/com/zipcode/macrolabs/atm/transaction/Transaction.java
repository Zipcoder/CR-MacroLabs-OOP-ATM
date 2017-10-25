package com.zipcode.macrolabs.atm.transaction;

import com.zipcode.macrolabs.atm.bankaccount.Account;

import java.util.Date;

public class Transaction {

    Date date;
    double amount;
    final TransactionType transactionType;
    String transactionID;
    Account originAccount;

    @Override
    public String toString(){
        return String.format("Date: %s | ID: %s | Type: %s | Amount: $%,.2f | Account: %s ",
                this.date, this.transactionID, this.transactionType, this.amount, this.originAccount.getAccountID());
    }

    public Transaction(TransactionType transactionType, double amount){
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = new Date();
    }

    public TransactionType getTransactionType() {
        return this.transactionType;
    }

    public Date getDate(){
        return this.date;
    }

    public double getAmount(){
        return this.amount;
    }

    public void setTransactionID(int iteratedTransactionID) {
        this.transactionID = String.format( "%0" + TransactionFactory.TRANSACTION_ID_LENGTH + "d", iteratedTransactionID);
    }

    public String getTransactionID(){
        return this.transactionID;
    }

    public Account getOriginAccount(){
        return this.originAccount;
    }

    public void setOriginAccount(Account originAccount){
        this.originAccount = originAccount;
    }

}
