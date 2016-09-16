package io.zihaocastine;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zihaocastine on 5/3/16.
 */
public class AccountTest {
    @Test
    public void TestAccount() {
        Account account = new Account(Account.AccountType.CHECKING, 12345, "Zihao");
        String expectedName = "Zihao";
        Assert.assertEquals(expectedName, account.getAccountName());
        Account.AccountType expectedType = Account.AccountType.CHECKING;
        Assert.assertEquals(expectedType, account.getAccountType());
        int expectedNumber = 12345;
        Assert.assertEquals(expectedNumber, account.getAccountNumber());

    }
    @Test
        public void TestBalance() {
        Account account = new Account(Account.AccountType.CHECKING, 12345, "Zihao",500);
        String expectedName="Zihao";
        Assert.assertEquals(expectedName,account.getAccountName());
        Account.AccountType expectedType = Account.AccountType.CHECKING;
        Assert.assertEquals(expectedType,account.getAccountType());
        int expectedNumber=12345;
        Assert.assertEquals(expectedNumber,account.getAccountNumber());
        double expectedBalance=500;
        Assert.assertEquals(expectedBalance,500,0);
    }
    @Test
    public void TestDebit() {
        Account account = new Account(Account.AccountType.CHECKING, 12345, "Zihao",500);
        double expectedBalance=500;
        Assert.assertEquals(expectedBalance,500,0);
        account.debit(50);
        double expectedAfterChecking=450;
        Assert.assertEquals(expectedAfterChecking,account.getBalance(),0);
    }
    @Test
    public void TestCredit() {
        Account account = new Account(Account.AccountType.CHECKING, 12345, "Zihao",500);
        double expectedBalance=500;
        Assert.assertEquals(expectedBalance,500,0);
        account.credit(50);
        double expectedAfterCredit=550;
        Assert.assertEquals(expectedAfterCredit,account.getBalance(),0);
    }


}
