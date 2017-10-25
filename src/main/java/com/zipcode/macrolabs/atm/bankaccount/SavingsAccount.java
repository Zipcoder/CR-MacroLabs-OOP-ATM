package com.zipcode.macrolabs.atm.bankaccount;

public class SavingsAccount extends Account {

    public SavingsAccount(){ }

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }

}
