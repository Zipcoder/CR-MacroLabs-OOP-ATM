package com.zipcode.macrolabs.atm.bankaccount;

import com.zipcode.macrolabs.atm.exceptions.BalanceTooLowException;
import com.zipcode.macrolabs.atm.exceptions.TransactionAmountIsZeroException;
import com.zipcode.macrolabs.atm.transaction.Transaction;
import com.zipcode.macrolabs.atm.transaction.TransactionFactory;
import com.zipcode.macrolabs.atm.transaction.TransactionType;
import com.zipcode.macrolabs.atm.user.User;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    protected String accountID;
    protected AccountType accountType;
    private double accountBalance = 0.00d;
    private List<User> accountUsers = new ArrayList<User>();
    private AccountStatus accountStatus = AccountStatus.ACTIVE;
    private List<Transaction> accountTransactionHistory = new ArrayList<Transaction>();

    @Override
    public String toString(){
        String accountInfo = String.format("Account - ID: %s | Type: %s | Balance: %,.2f | Status: %s | Users: %s ",
                this.getAccountID(), this.getAccountType(), this.getBalance(),
                this.getAccountStatus(), this.getAccountUsers());
        return accountInfo;
    }

    public double getBalance() {
        return this.accountBalance;
    }

    public void setBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setAccountID(int accountID) {
        this.accountID = String.format( "%0" + AccountFactory.ACCOUNT_ID_LENGTH + "d", accountID);
    }

    public String getAccountID() {
        return this.accountID;
    }

    public void addUser(User user) {
        accountUsers.add(user);
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }


    public void addTransactionToHistory(Transaction transaction){
        this.getTransactionHistory().add(transaction);
    }

    public Transaction withdrawAndMakeTransaction(double amount) throws TransactionAmountIsZeroException, BalanceTooLowException {

            if(amount >= 0.001) {
                if (this.accountBalance >= amount) {
                this.accountBalance -= amount;
                Transaction newTransaction = TransactionFactory.createNewWithdrawal(amount, this);
                addTransactionToHistory(newTransaction);
                return newTransaction;
            } else { throw new BalanceTooLowException(); }
        } else { throw new TransactionAmountIsZeroException(); }

    }

    public Transaction depositAndMakeTransaction(double amount) throws TransactionAmountIsZeroException {

        if(amount >= 0.001) {
                this.accountBalance += amount;
                Transaction newTransaction = TransactionFactory.createNewDeposit(amount, this);
                addTransactionToHistory(newTransaction);
                return newTransaction;
        } else { throw new TransactionAmountIsZeroException(); }

    }

    public Transaction transferAndMakeTransaction(double amount, Account destinationAccount) throws TransactionAmountIsZeroException, BalanceTooLowException {
        if(amount >= 0.001) {
            if (this.accountBalance >= amount) {
                this.accountBalance -= amount;
                destinationAccount.accountBalance += amount;
                Transaction newTransaction = TransactionFactory.createNewTransfer(amount, this, destinationAccount);
                addTransactionToHistory(newTransaction);
                return newTransaction;
            } else { throw new BalanceTooLowException(); }
        } else { throw new TransactionAmountIsZeroException(); }
    }

    public abstract AccountType getAccountType();

    public void setAccountStatus(AccountStatus accountStatus){
        this.accountStatus = accountStatus;
    }

    public ArrayList<User> getAccountUsers() {
        return (ArrayList<User>) accountUsers;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return (ArrayList<Transaction>) accountTransactionHistory;
    }

    public String printTransactionHistory(){
        String history = "";
        for (Transaction transaction: this.getTransactionHistory()) {
            history += transaction.toString() + "\n";
        }
        return history;
    }
}
