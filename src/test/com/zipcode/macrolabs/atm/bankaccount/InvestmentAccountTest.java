package com.zipcode.macrolabs.atm.bankaccount;

import com.zipcode.macrolabs.atm.user.User;
import com.zipcode.macrolabs.atm.user.UserFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvestmentAccountTest {

    Account account;

    @Before
    public void initialize() {
        User user = UserFactory.createNewUser("Uncle Bob", "cleancode");
        account = AccountFactory.createNewInvestmentAccount(user);
    }

    @Test
    public void getAccountTypeTest(){

        AccountType expected = AccountType.INVESTMENT;
        AccountType actual = account.getAccountType();

        Assert.assertEquals(expected, actual);
    }

}
