package com.zipcode.macrolabs.atm.bankaccount;

public class CheckingAccount extends Account {

    public CheckingAccount(){
        setAccountType();
    }

    @Override
    public void setAccountType() {
        this.accountType = AccountType.CHECKING;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}
