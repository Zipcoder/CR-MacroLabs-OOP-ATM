package com.zipcode.macrolabs.atm.transaction;

import com.zipcode.macrolabs.atm.bankaccount.Account;
import com.zipcode.macrolabs.atm.bankaccount.AccountFactory;
import com.zipcode.macrolabs.atm.exceptions.NoMoreTransactionsException;
import com.zipcode.macrolabs.atm.user.User;
import com.zipcode.macrolabs.atm.user.UserFactoryTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TransactionFactoryTest {

    Transaction transaction;
    User user;
    Account account;

    @Before
    public void setUp(){
        user = UserFactoryTest.createBob();
        account = AccountFactory.createNewCheckingAccount(user);
        TransactionFactory.iteratedTransactionID = 0;
    }

    @Test(expected = NoMoreTransactionsException.class)
    public void noMoreTransactionsTest() throws NoMoreTransactionsException{
        TransactionFactory.iteratedTransactionID += (int) Math.pow(10, TransactionFactory.TRANSACTION_ID_LENGTH);
        int nextID = TransactionFactory.nextTransactionID();
    }

    @Test
    public void createWithdrawalTest(){
        transaction = TransactionFactory.createNewWithdrawal(500, account);

        Assert.assertEquals(account, transaction.getOriginAccount());
        Assert.assertTrue(transaction.getDate() instanceof Date);
        Assert.assertTrue(transaction.getTransactionID().length() == TransactionFactory.TRANSACTION_ID_LENGTH);
        Assert.assertEquals(TransactionType.WITHDRAWAL, transaction.getTransactionType());
        Assert.assertEquals(500d, transaction.getAmount(), 0.001);
    }

    @Test
    public void createDepositTest(){
        transaction = TransactionFactory.createNewDeposit(500, account);

        Assert.assertEquals(account, transaction.getOriginAccount());
        Assert.assertTrue(transaction.getDate() instanceof Date);
        Assert.assertTrue(transaction.getTransactionID().length() == TransactionFactory.TRANSACTION_ID_LENGTH);
        Assert.assertEquals(TransactionType.DEPOSIT, transaction.getTransactionType());
        Assert.assertEquals(500d, transaction.getAmount(), 0.001);
    }

    @Test
    public void createTransferTest(){
        Account destAccount = AccountFactory.createNewCheckingAccount(user);
        TransferTransaction transferTransaction = TransactionFactory.createNewTransfer(500, account, destAccount);

        Assert.assertEquals(account, transferTransaction.getOriginAccount());
        Assert.assertEquals(destAccount, transferTransaction.getDestinationAccount());
        Assert.assertTrue(transferTransaction.getDate() instanceof Date);
        Assert.assertTrue(transferTransaction.getTransactionID().length() == TransactionFactory.TRANSACTION_ID_LENGTH);
        Assert.assertEquals(TransactionType.TRANSFER, transferTransaction.getTransactionType());
        Assert.assertEquals(500d, transferTransaction.getAmount(), 0.001);
    }

    @Test
    public void transactionIDIteratorTest(){
        int iterations = 5;
        for (int i = 0; i < iterations; i++) {
            TransactionFactory.createNewWithdrawal(500, account);
        }
        Assert.assertEquals(iterations, TransactionFactory.iteratedTransactionID);
    }
}
