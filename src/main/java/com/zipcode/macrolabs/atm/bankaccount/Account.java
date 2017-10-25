package com.zipcode.macrolabs.atm.bankaccount;

import com.zipcode.macrolabs.atm.exceptions.BalanceTooLowException;
import com.zipcode.macrolabs.atm.exceptions.TransactionAmountIsZeroException;
import com.zipcode.macrolabs.atm.transaction.Transaction;
import com.zipcode.macrolabs.atm.transaction.TransactionFactory;
import com.zipcode.macrolabs.atm.user.User;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    protected int accountID = 0;
    protected AccountType accountType;
    private double accountBalance = 0.00d;
    private List<User> accountUsers = new ArrayList<User>();
    private AccountStatus accountStatus = AccountStatus.ACTIVE;
    private List<Transaction> accountTransactionHistory = new ArrayList<Transaction>();


    public double getBalance() {
        return this.accountBalance;
    }

    public void setBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountID() {
        return String.format( "%0" + AccountFactory.ACCOUNT_ID_LENGTH + "d", accountID);
    }

    public void addUser(User user) {
        accountUsers.add(user);
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountInfo(){
        String accountInfo = String.format("Account - ID: %s | Type: %s | Balance: %,.2f | Status: %s | Users: %s\n",
                this.getAccountID(), this.getAccountType(), this.getBalance(),
                this.getAccountStatus(), this.getAccountUsers());
        return accountInfo;
    }

    public Transaction withdrawAndMakeTransaction(double amount) throws TransactionAmountIsZeroException, BalanceTooLowException {

            if(amount >= 0.001) {
                if (this.accountBalance >= amount) {
                this.accountBalance -= amount;
                Transaction newTransaction = TransactionFactory.createNewTransaction();
                return newTransaction;
            } else { System.out.println("Sorry, your balance is too low! Requested: " + amount + ". Available: " + this.accountBalance + ".");
                    throw new BalanceTooLowException(); }
        } else { throw new TransactionAmountIsZeroException(); }

    }

    public Transaction depositAndMakeTransaction(double amount) throws TransactionAmountIsZeroException {

        if(amount >= 0.001) {
                this.accountBalance += amount;
                Transaction newTransaction = TransactionFactory.createNewTransaction();
                return newTransaction;
        } else { throw new TransactionAmountIsZeroException(); }

    }

    public Transaction transferAndMakeTransaction(double amount, String destinationAccountID){
        return null;
    }

    public String printHistory(){
        return null;
    }

    public Transaction[] getHistory(){
        return null;
    }

    public abstract void setAccountType();

    public abstract AccountType getAccountType();

    public void setAccountStatus(AccountStatus accountStatus){
    }


    public ArrayList<User> getAccountUsers() {
        return (ArrayList<User>) accountUsers;
    }


    public ArrayList<Transaction> getTransactionHistory() {
        return (ArrayList<Transaction>) accountTransactionHistory;
    }
}
