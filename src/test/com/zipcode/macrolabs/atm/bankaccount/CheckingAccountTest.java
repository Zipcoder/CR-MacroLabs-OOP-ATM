package com.zipcode.macrolabs.atm.bankaccount;

import com.zipcode.macrolabs.atm.bankaccount.Account;
import com.zipcode.macrolabs.atm.bankaccount.CheckingAccount;
import com.zipcode.macrolabs.atm.exceptions.*;
import com.zipcode.macrolabs.atm.transaction.Transaction;
import com.zipcode.macrolabs.atm.transaction.TransactionFactory;
import com.zipcode.macrolabs.atm.transaction.TransactionType;
import com.zipcode.macrolabs.atm.transaction.TransferTransaction;
import com.zipcode.macrolabs.atm.user.User;
import com.zipcode.macrolabs.atm.user.UserFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class CheckingAccountTest {

    Account account;
    User user;

    @Before
        public void initialize() {
        user = UserFactory.createNewUser("Uncle Bob", "cleancode");
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
    public void IDSetterGetterTest() {
        int expectedID = 5;
        account.setAccountID(5);
        int actualID = Integer.valueOf(account.getAccountID());
        Assert.assertEquals(expectedID, actualID);
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

    @Test
    public void transferBalanceShouldMove() throws BalanceTooLowException, TransactionAmountIsZeroException {
        Account destAccount = AccountFactory.createNewCheckingAccount(user);
        account.setBalance(1000.00d);
        destAccount.setBalance(1000.00d);

        account.transferAndMakeTransaction(500.00d, destAccount);

        double expected = 500.00d;
        double expectedDest = 1500.00d;
        double actual = account.getBalance();
        double actualDest = destAccount.getBalance();

        Assert.assertEquals(expected, actual, 0.001d);
        Assert.assertEquals(expectedDest, actualDest, 0.001d);
    }

    @Test(expected = TransactionAmountIsZeroException.class)
    public void transferShouldBeMoreThanAPennyTest() throws TransactionAmountIsZeroException, BalanceTooLowException {
        Account destAccount = AccountFactory.createNewCheckingAccount(user);
        account.setBalance(1000.00d);
        account.transferAndMakeTransaction(0.00d, destAccount);
    }

    @Test
    public void transferShouldMakeTransferTransactionTest() throws TransactionAmountIsZeroException, BalanceTooLowException {
        Transaction transaction;
        Account destAccount = AccountFactory.createNewCheckingAccount(user);
        account.setBalance(1000.00d);

        transaction = account.transferAndMakeTransaction(500.00d, destAccount);

        Assert.assertTrue(transaction instanceof TransferTransaction && transaction.getTransactionType().equals(TransactionType.TRANSFER));

    }

    @Test
    public void getUsersNotNull(){
        Assert.assertTrue(account.getAccountUsers().size() > 0);
    }

    @Test
    public void getHistoryIsNotNullTest(){
        Assert.assertNotNull(account.getTransactionHistory());
    }

    @Test
    public void printHistoryIsStringTest() throws BalanceTooLowException, TransactionAmountIsZeroException {
        for (int i = 0; i < 5; i++) {
            account.depositAndMakeTransaction(500);
        }
        Assert.assertTrue(account.printTransactionHistory().length() > 0);
    }
}
