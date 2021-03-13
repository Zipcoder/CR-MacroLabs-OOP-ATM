package AccountsAndTransactions;

import java.util.ArrayList;

public class Account {
    private static double chkAcctBal;


    /*
        Things we need here:
        1. checking accounts
        2. savings accounts
        3. investment accounts
        ***bins would probably be a good way to store this information - have a bin for each user with a slot for each account

        Things we may also need here?
        1. account balance - there's already a balance value in the User.java tab, but it might work better here because we need separate balances in each type of account
        2. account number
        3. BONUS - Persistence
            - create a way to store user information, account balances, etc
            - probably the best way if we get to this would be to save a current state of all account balances to a spreadsheet when we close the ATM app
            - alternately, access the spreadsheet every time any transaction is completed, so that if the program crashes before closing all information is still saved
         */

    //establish all the data stored in the AccountsAndTransactions.Account object:
    //instances of Accounts should have name [firstLast]
    private String firstName;
    private String lastName;
    private int pin;
    private int chkAcctNum;
    private int savAcctNum;
    private int invAcctNum;

    private double savAcctBal;
    private double invAcctBal;
    public ArrayList<String> transactionHistory = new ArrayList<String>();

    //actions that can be called to create a new account bin:
    public Account(String firstName, String lastName, int pin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
    }


    //create getters for all the data stored in the AccountsAndTransactions.Account object:
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPin() {
        return pin;
    }

    public int getChkAcctNum() {
        return chkAcctNum;
    }

    public int getSavAcctNum() {
        return savAcctNum;
    }

    public int getInvAcctNum() {
        return invAcctNum;
    }

    public static double getChkAcctBal() {
        return chkAcctBal;
    }

    public double getSavAcctBal() {
        return savAcctBal;
    }

    public double getInvAcctBal() {
        return invAcctBal;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setChkAcctNum(int chkAcctNum) {
        this.chkAcctNum = chkAcctNum;
    }

    public void setSavAcctNum(int savAcctNum) {
        this.savAcctNum = savAcctNum;
    }

    public void setInvAcctNum(int invAcctNum) {
        this.invAcctNum = invAcctNum;
    }

    public void setChkAcctBal(double chkAcctBal) {
        this.chkAcctBal = chkAcctBal;
    }

    public void setSavAcctBal(double savAcctBal) {
        this.savAcctBal = savAcctBal;
    }

    public void setInvAcctBal(double invAcctBal) {
        this.invAcctBal = invAcctBal;
    }

    public void setTransactionHistory(ArrayList<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
}
