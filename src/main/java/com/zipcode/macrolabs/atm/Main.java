package com.zipcode.macrolabs.atm;

import com.zipcode.macrolabs.atm.navigation.BankAccountManager;

public class Main {

    public static void main(String[] args) {

        BankAccountManager bankAccountManager = new BankAccountManager();
        bankAccountManager.run();

    }
}
