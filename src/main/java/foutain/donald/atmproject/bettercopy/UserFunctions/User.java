package foutain.donald.atmproject.bettercopy.UserFunctions;

import java.util.Random;

public class User {

    private String userPassword;

    private int accountNumber;

    private String userName;



    public int randomAccountGenerator() {
        Random rnd = new Random();
        int accountNumber = 100000 + rnd.nextInt(900000);
        return accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getUserName() { return userName; }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
