package io.zihaocastine;

import java.util.ArrayList;

/**
 * Created by zihaocastine on 5/2/16.
 */
public class Account {
    private AccountType accountType;
    private int accountNumber;
    private String accountName;
    private double balance;
    private double interestRate;
    private Status status;
    private boolean overDraft;
    private ArrayList<String> record;

    public enum AccountType{CHECKING, SAVING, INVESTMENT}
    public enum Status{OPEN, CLOSED, OFACFREEZE}

    Account(AccountType accountType,int accountNumber, String accountName){
        this.accountType=accountType;
        this.accountNumber=accountNumber;
        this.accountName=accountName;
        balance=0;
        interestRate=0;
        status=Status.OPEN;
        overDraft=false;
        record=new ArrayList();
    }

    Account(AccountType accountType,int accountNumber,String accountName,double balance){
        this.accountType=accountType;
        this.accountNumber=accountNumber;
        this.accountName=accountName;
        this.balance=balance;
        interestRate=0;
        status=Status.OPEN;
        overDraft=false;
        record=new ArrayList();
    }

    Account(AccountType accountType,int accountNumber,String accountName,double balance,double interestRate){
        this.accountType=accountType;
        this.accountNumber=accountNumber;
        this.accountName=accountName;
        this.balance=balance;
        this.interestRate=interestRate;
        status=Status.OPEN;
        overDraft=false;
        record=new ArrayList();
    }

    public double getBalance() {
        if(!status.equals(Status.OFACFREEZE)){
            return balance;
        }
        return -9999;
    }

    private void setBalance(double balance) {

            this.balance = balance;
    }

    public boolean debit(double amount){
        if(isAccountOpen()){
            if((balance-amount)>=0) {
                setBalance(balance - amount);
                record.add("debit " + amount);
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public boolean credit(double amount){
        if(isAccountOpen()){
            setBalance(balance+amount);
            record.add("credit "+amount);
            return true;
        }else {
            return false;
        }
    }

    public boolean isAccountOpen(){
        if(status.equals(Status.OPEN)){
            return true;
        }else {
            return false;
        }

    }
    public AccountType getAccountType() {
        return accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }


    public String getAccountName() {
        return accountName;
    }

    public void changeAccountName(String accountName) {
        if(!status.equals(Status.CLOSED)) {
            this.accountName = accountName;
            record.add("changeAccountName "+accountName);
        }
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void changeStatus(Status status) {
        if(!status.equals(Status.CLOSED)) {
            this.status = status;
            record.add("changeStatus"+status);
        }
    }

    public void changeOverDraft(boolean overDraft) {
        this.overDraft = overDraft;
        record.add("changeOverDraft "+overDraft);
    }

    public void setRecord(String steatment) {
        record.add(steatment);
    }

    public ArrayList<String> getRecord() {
        return record;
    }

}
