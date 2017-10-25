package com.zipcode.macrolabs.atm.bankaccount;

import com.zipcode.macrolabs.atm.bankaccount.Account;
import com.zipcode.macrolabs.atm.bankaccount.CheckingAccount;
import com.zipcode.macrolabs.atm.exceptions.*;
import com.zipcode.macrolabs.atm.transaction.Transaction;
import com.zipcode.macrolabs.atm.transaction.TransactionType;
import com.zipcode.macrolabs.atm.user.User;
import com.zipcode.macrolabs.atm.user.UserFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CheckingAccountTest {

    Account account;

    @Before
        public void initialize() {
        User user = UserFactory.createNewUser("Uncle Bob", "cleancode");
        account = AccountFactory.createNewCheckingAccount(user);
    }

    @Test
    public void setAndGetBalanceTest(){
        account.setBalance(1000.00d);

        double expected = 1000.00d;
        double actual = account.getBalance();

        Assert.assertEquals(expected, actual, 0.001d);
    }

    @Test
    public void getAccountTypeTest(){
        AccountType expected = AccountType.CHECKING;
        AccountType actual = account.getAccountType();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAccountIDTest(){
        Assert.assertTrue(account.getAccountID().length() == AccountFactory.ACCOUNT_ID_LENGTH);
        Assert.assertTrue(Integer.valueOf(account.getAccountID()) > 0);
    }

    @Test
    public void withdrawBalanceShouldDecreaseTest() throws BalanceTooLowException, TransactionAmountIsZeroException {

        account.setBalance(1000.00d);

        account.withdrawAndMakeTransaction(500.00d);

        double expected = 500.00d;
        double actual = account.getBalance();

        Assert.assertEquals(expected, actual, 0.001d);

    }

    @Test(expected = TransactionAmountIsZeroException.class)
    public void withdrawShouldBeMoreThanAPennyTest() throws TransactionAmountIsZeroException, BalanceTooLowException {

        account.setBalance(1000.00d);
        account.withdrawAndMakeTransaction(0.00d);

    }

    @Test(expected = BalanceTooLowException.class)
    public void cantWithdrawIfBalanceLessThanAmount() throws BalanceTooLowException, TransactionAmountIsZeroException{

        account.setBalance(50);
        account.withdrawAndMakeTransaction(1000);

    }

    @Test
    public void withdrawShouldMakeWithdrawalTransactionTest() throws BalanceTooLowException, TransactionAmountIsZeroException {

        Transaction transaction;
        account.setBalance(1000.00d);
        transaction = account.withdrawAndMakeTransaction(500.00d);

        Assert.assertTrue(transaction instanceof Transaction && transaction.getTransactionType().equals(TransactionType.WITHDRAWAL));
    }

    @Test
    public void depositBalanceShouldIncreaseTest() throws TransactionAmountIsZeroException {

        account.setBalance(1000.00d);

        account.depositAndMakeTransaction(500.00d);

        double expected = 1500.00d;
        double actual = account.getBalance();

        Assert.assertEquals(expected, actual, 0.001d);

    }
//
    @Test(expected = TransactionAmountIsZeroException.class)
    public void depositShouldBeMoreThanAPennyTest() throws TransactionAmountIsZeroException {

        account.setBalance(1000.00d);
        account.depositAndMakeTransaction(0.00d);

    }

    @Test
    public void depositShouldMakeDepositTransactionTest() throws TransactionAmountIsZeroException {

        Transaction transaction;
        account.setBalance(1000.00d);

        transaction = account.depositAndMakeTransaction(500.00d);

        Assert.assertTrue(transaction instanceof Transaction && transaction.getTransactionType().equals(TransactionType.DEPOSIT));

    }

//    @Test
//    public void transferBalanceShouldMove() {
//
//        Account accountOther = new CheckingAccount();
//        account.setBalance(1000.00d);
//        accountOther.setBalance(1000.00d);
//
//        account.transferAndMakeTransaction(500.00d, accountOther);
//
//        double expected = 500.00d;
//        double expectedOther = 1500.00d;
//        double actual = account.getBalance();
//        double actualOther = accountOther.getBalance();
//
//        Assert.assertEquals(expected, actual, 0.001d);
//        Assert.assertEquals(expectedOther, actualOther, 0.001d);
//    }
//
//
//    public String printHistory(){
//
//        return null;
//
//    }
//
//    public Transaction[] getHistory(){
//
//        return null;
//
//    }
//
//    public abstract accountTypeEnum getAccountType(){
//
//        return null;
//
//    }
//
//    public CheckingAccountTest(){
//
//    }
//
//    @Override
//    public accountTypeEnum getAccountType() {
//        return null;
//    }
}
