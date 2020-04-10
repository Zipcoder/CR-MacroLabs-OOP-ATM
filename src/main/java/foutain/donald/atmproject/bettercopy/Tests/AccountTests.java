package foutain.donald.atmproject.bettercopy.Tests;

import foutain.donald.atmproject.bettercopy.AccountFunctions.Account;
import org.junit.Assert;
import org.junit.Test;

public class AccountTests {

    Account newAccount = new Account();

    @Test
    public void getTypeOfAccountTest(){
        String expected = "Checking";

        newAccount.setTypeOfAccount(expected);
        String actual = newAccount.getTypeOfAccount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAccountNumber(){
        int expected = 10000;

        int accountNumber = 10000;
        newAccount.setAccountNumber(accountNumber);
        int actual = newAccount.getAccountNumber();

        Assert.assertEquals(expected, accountNumber);
    }

    @Test
    public void getAccountBalance(){
        double expected = 100.55;

        double accountBalance = 100.55;
        newAccount.setAccountBalance(accountBalance);
        double actual = newAccount.getAccountBalance();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void withDrawMoneyTest(){
        String expected = "Your new account balance is: 200.0";

        double accountBalance = 260;
        double withDrawAmount = 60;
        newAccount.setAccountBalance(accountBalance);
        String actual = newAccount.withdrawMoney(withDrawAmount);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void depositMoneyTest(){
        String expected = "Your new account balance is: 260.0";

        double accountBalance = 200;
        double depositAmount = 60;
        newAccount.setAccountBalance(accountBalance);
        String actual = newAccount.depositMoney(depositAmount);

        Assert.assertEquals(expected,actual);
    }
}
