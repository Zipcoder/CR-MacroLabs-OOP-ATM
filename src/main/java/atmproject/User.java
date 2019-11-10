package atmproject;

import atmproject.accounts.Account;
import atmproject.accounts.SavingsAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class User {
    private Console console = new Console(System.in,System.out);
    private String firstName;
    private String lastName;
    private Integer pinNumber;
    private Integer userID;
    private ArrayList<String> transactionHistory;
    TreeMap<String, Account> accountList;

    public User(String firstName, String lastName, Integer userID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.pinNumber = 0;
        this.accountList = new TreeMap<String, Account>();
        this.transactionHistory = new ArrayList<String>();

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(Integer pinNumber) {
        this.pinNumber = pinNumber;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer accountNumber) {
        this.userID = accountNumber;
    }

    public TreeMap<String, Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(TreeMap<String, Account> accountList) {
        this.accountList = accountList;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(ArrayList<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
    public void addToHistory(String transaction){
        transactionHistory.add(transaction);
    }

    public void removeAccount(Account account){
        if (account.getBalance() > 0.0){
            console.println("Please empty your account before attempting to close.");
        }
        accountList.remove(account.getAccountName());
    }

    public void addAccount(Account account) {
        accountList.put(account.getAccountName(), account);
    }

    public String displayHistory(){
        StringBuilder sb = new StringBuilder();
        for(String s : transactionHistory){
            sb.append("**").append(s);
        }
        return sb.toString();
    }
}
