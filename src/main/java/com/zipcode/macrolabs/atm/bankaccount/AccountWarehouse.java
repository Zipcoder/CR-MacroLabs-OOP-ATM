package com.zipcode.macrolabs.atm.bankaccount;

import java.util.ArrayList;
import java.util.List;

public class AccountWarehouse {

    private static final List<Account> accounts = new ArrayList<Account>();

    public static void addAccount(Account account) {
        accounts.add(account);
    }

    public static List<Account> getAccounts() {
        return accounts;
    }

    public static Account findAccountByID(String accountID){
        Account accountOut = null;
        for (Account account: accounts){
            if(accountID.equals(account.getAccountID())){
                accountOut = account;
                break;
            }
        }
        return accountOut;
    }
}
