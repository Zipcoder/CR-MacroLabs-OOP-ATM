package com.zipcode.macrolabs.atm.bankaccount;

import com.zipcode.macrolabs.atm.user.User;
import com.zipcode.macrolabs.atm.user.UserFactoryTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountWarehouseTest {

    @Before
    public void setUp(){
        AccountFactory.iteratedAccountID = 0;
    }

    @Test
    public void addOneAccountTest(){
        int initial = AccountWarehouse.getAccounts().size();
        AccountFactory.createNewCheckingAccount(UserFactoryTest.createBob());
        int after = AccountWarehouse.getAccounts().size();
        int expectedSizeChange = 1;
        int actualSizeChange = after - initial;
        Assert.assertEquals(expectedSizeChange, actualSizeChange);
    }

    @Test
    public void findAccountByIDTest(){
        String id = "000000003";
        User user = UserFactoryTest.createBob();
        for (int i = 0; i < 5; i++) {
            AccountFactory.createNewCheckingAccount(user);
        }
        Account account = AccountWarehouse.findAccountByID(id);

        Assert.assertEquals(id, account.getAccountID());
    }

}


