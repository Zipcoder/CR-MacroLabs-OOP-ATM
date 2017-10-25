package com.zipcode.macrolabs.atm.bankaccount;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        CheckingAccountTest.class,
        SavingsAccountTest.class,
        InvestmentAccountTest.class
})

public class AccountTestSuite {}
