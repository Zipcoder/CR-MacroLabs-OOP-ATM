package atmproject;

import atmproject.accounts.Account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class User {

    private String firstName;
    private String lastName;
    private Integer pinNumber;
    private Integer accountNumber;
    TreeMap<String, Account> accountList;
    ArrayList<String> transactionHistory;

    public User(String firstName, String lastName, Integer accountNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
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

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
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

    public Account removeAccount(String accountName){
        return accountList.remove(accountName);

    }

    public String displayHistory(){
        Object[] history = transactionHistory.toArray();
        return Arrays.toString(history);
    }
}
