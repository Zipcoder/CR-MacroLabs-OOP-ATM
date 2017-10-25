package com.zipcode.macrolabs.atm.user;

import com.zipcode.macrolabs.atm.bankaccount.Account;
import com.zipcode.macrolabs.atm.bankaccount.AccountFactory;
import com.zipcode.macrolabs.atm.bankaccount.AccountStatus;
import com.zipcode.macrolabs.atm.bankaccount.AccountType;
import com.zipcode.macrolabs.atm.exceptions.AccountNotEmptyException;

import java.util.ArrayList;
import java.util.List;

public class User {

    String userID;
    String userName;
    String userPassword;
    List<Account> userAccounts = new ArrayList<Account>();

    @Override
    public String toString(){
        String userString = String.format("UserID: %s | User Name: %s", this.getUserID(), this.getUserName());
        return userString;
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public List<Account> getAccounts(){
        return userAccounts;
    }

    public void setUserName(String newUserName){
        this.userName = newUserName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void addAnotherUserToExistingAccount(int accountIndex, User anotherUser){

    }

    public void addAccount(Account newAccount){
        this.userAccounts.add(newAccount);
    }

    public void createNewAccount(AccountType accountType){
        Account newAccount;
        switch(accountType) {
            case CHECKING:
                this.addAccount(AccountFactory.createNewCheckingAccount(this));
                break;
            case SAVINGS:
                this.addAccount(AccountFactory.createNewSavingsAccount(this));
                break;
            case INVESTMENT:
                this.addAccount(AccountFactory.createNewInvestmentAccount(this));
                break;

        }
    }

    public void removeAccount(int accountIndex) throws AccountNotEmptyException {
        Account thisAccount = userAccounts.get(accountIndex);
        if(thisAccount.getBalance() < 0.001d){
            userAccounts.remove(thisAccount);
        } else {throw new AccountNotEmptyException();}
    }

    public void closeAccount(int accountIndex) throws AccountNotEmptyException {
        Account thisAccount = userAccounts.get(accountIndex);
        if(thisAccount.getBalance() < 0.001d){
            thisAccount.setAccountStatus(AccountStatus.CLOSED);
        } else {throw new AccountNotEmptyException();}

    }

    public void setUserID(int userID) {
        this.userID = String.format("%0" + UserFactory.USER_ID_LENGTH + "d", userID);
    }

    public String getUserID() {
        return this.userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getAllUserAccountInfo() {
        String allAcountInfo = "";
        for (Account account: this.getAccounts()) {
             allAcountInfo += account.getAccountInfo();
        }
        return allAcountInfo;
    }
}
