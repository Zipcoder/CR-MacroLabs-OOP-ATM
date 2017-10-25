package com.zipcode.macrolabs.atm.bankaccount;

public class SavingsAccount extends Account {

    public SavingsAccount(){
        setAccountType();
    }

    @Override
    public void setAccountType() {
        this.accountType = AccountType.SAVINGS;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }

}
