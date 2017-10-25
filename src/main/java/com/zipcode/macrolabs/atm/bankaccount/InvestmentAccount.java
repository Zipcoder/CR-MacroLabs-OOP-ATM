package com.zipcode.macrolabs.atm.bankaccount;

public class InvestmentAccount extends Account {

    public InvestmentAccount(){
        setAccountType();
    }

    @Override
    public void setAccountType() {
        this.accountType = AccountType.INVESTMENT;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.INVESTMENT;
    }

}
