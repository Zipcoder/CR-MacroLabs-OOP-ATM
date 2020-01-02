package com.zipcode.macrolabs.atm.bankaccount;

public class InvestmentAccount extends Account {

    public InvestmentAccount(){ }

    @Override
    public AccountType getAccountType() {
        return AccountType.INVESTMENT;
    }

}
