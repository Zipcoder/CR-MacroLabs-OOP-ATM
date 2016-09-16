package io.zihaocastine;

import java.util.ArrayList;

/**
 * Created by zihaocastine on 5/10/16.
 */
public class User {
    private String username;
    private String password;
    private ArrayList<Account> accountList;

    User(String username, String password){
        this.username=username;
        this.password=password;
        accountList=new ArrayList<Account>();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void AccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }
}
