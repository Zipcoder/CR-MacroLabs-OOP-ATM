package foutain.donald.atmproject.bettercopy.UserFunctions;

import java.util.Random;

public class User {

    private String userName;

    private String userPassword;

    private int accountNumber;


    public void setUserInfo(String userPassword, String userName){
        Random rnd = new Random();
        int accountNumber = 100000 + rnd.nextInt(900000);
        this.accountNumber = accountNumber;
        this.userPassword = userPassword;
        this.userName = userName;
        System.out.println("This is your account number. Please me make sure to write it down!\n" + accountNumber);

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
