package io.zihaocastine;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zihaocastine on 5/3/16.
 */
public class TransactionTest {
    @Test
    public void makeTransactionDepositsTest(){
        Account account1 = new Account(Account.AccountType.CHECKING, 12345, "Zihao",500);
        Transaction transaction=new Transaction(Transaction.TransactionType.DEPOSITS,200,account1,null);
        transaction.makeTransaction();

        Assert.assertEquals("Value should be 700", 700,account1.getBalance(),0);

    }
    @Test
    public void makeTransactionWithdrawalTest(){
        Account account1 = new Account(Account.AccountType.CHECKING, 12345, "Zihao",500);
        Transaction transaction=new Transaction(Transaction.TransactionType.WITHDRAWALS,200,account1,null);
        transaction.makeTransaction();

        Assert.assertEquals("Value should be 300", 300,account1.getBalance(),0);

    }
    @Test
    public void makeTransactionTransferTest(){
        Account account1 = new Account(Account.AccountType.CHECKING, 12345, "Zihao",500);
        Account account2 = new Account(Account.AccountType.CHECKING, 56789, "Castine",1000);
        Transaction transaction=new Transaction(Transaction.TransactionType.TRANSFERS,200,account1,account2);
        transaction.makeTransaction();
        Assert.assertEquals("account1 balance should be 300", 300,account1.getBalance(),0);
        Assert.assertEquals("account2 balance should be 1200", 1200,account2.getBalance(),0);

    }

}
