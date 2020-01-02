package com.zipcode.macrolabs.atm.bankaccount;

public class CheckingAccount extends Account {

    public CheckingAccount(){ }

    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}
