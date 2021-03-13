package AccountsAndTransactions;

import org.junit.Assert;
import org.junit.Test;


public class TransactionsTest {
2

    @Test
    public void depositTest(){
        Account jeff = new Account ("Jeff", "Smith", 1234);
        jeff.setChkAcctBal(100.00);
        Transactions deposit = new Transactions(jeff);
        deposit.deposit(100.00,"checking");
        Assert.assertEquals(200.00,jeff.getChkAcctBal(), 0.0);
        Assert.assertEquals("Deposited $100.00 to checking.", jeff.transactionHistory.get(0));    //make sure it's also printing to transaction history
//        System.out.println(jeff.transactionHistory.get(0));                                              //ignore this - it's just a double check on the format
    }
    // make sure transaction history is getting recorded for deposits


    @Test         //sufficient funds - withdraw completed
    public void withdrawTest(){
        Account jeff = new Account ("Jeff", "Smith", 1234);
        jeff.setSavAcctBal(100.00);
        Transactions withdraw = new Transactions (jeff);
        withdraw.withdraw(50.00, "savings");
        Assert.assertEquals(50.00, jeff.getSavAcctBal(), 0.00);
        Assert.assertEquals("Withdrew $50.00 from savings.", jeff.transactionHistory.get(0));    //make sure it's also printing to transaction history
        //System.out.println(jeff.transactionHistory.get(0));                                              //ignore this - it's just a double check on the format

    }

    @Test         //insufficient funds - withdraw aborted
    public void withdrawTest2(){
        Account jeff = new Account ("Jeff", "Smith", 1234);
        jeff.setSavAcctBal(100.00);
        Transactions withdraw = new Transactions(jeff);
        withdraw.withdraw(200.00, "savings");
        Assert.assertEquals(100.00, jeff.getSavAcctBal(),0.00);
    }

    //write a test to make sure transaction history is getting recorded for withdrawals

    @Test       //from checking to savings
    public void transferTest(){
        Account jeff = new Account ("Jeff", "Smith", 1234);
        jeff.setChkAcctBal(100.00);
        jeff.setSavAcctBal(500.00);
        Transactions transfer = new Transactions(jeff);
        transfer.transfer(50.00, "checking", jeff, "savings");
        Assert.assertEquals(50.00, jeff.getChkAcctBal(), 0.00);
        Assert.assertEquals(550.00, jeff.getSavAcctBal(), 0.00);
    }

    @Test       //from checking to someone else's checking
    public void transferTest2(){
        Account jeff = new Account ("Jeff", "Smith", 1234);
        Account stan = new Account ("Stan", "Smith", 3434);
        jeff.setChkAcctBal(100.00);
        stan.setChkAcctBal(500.00);
        Transactions transfer = new Transactions(jeff);
        transfer.transfer(50.00, "checking", stan, "checking");
        Assert.assertEquals(50.00, jeff.getChkAcctBal(), 0.00);
        Assert.assertEquals(550.00, stan.getChkAcctBal(), 0.00);
    }

    @Test
    public void closeAccount(){
        Account jeff = new Account ("Jeff", "Smith", 1234);
        jeff.setChkAcctBal(0.00);
        jeff.setSavAcctBal(0.00);
        jeff.setInvAcctBal(0.00);
        Transactions closeAccount = new Transactions(jeff);
        closeAccount.closeAccount();
        Assert.assertEquals(null, jeff.getFirstName());
        Assert.assertEquals(null, jeff.getLastName());
        Assert.assertEquals(1000, jeff.getPin());
    }

    @Test
    public void forceCloseAccount(){
        Account jeff = new Account ("Jeff", "Smith", 1234);
        jeff.setChkAcctBal(50.00);
        jeff.setSavAcctBal(150.00);
        jeff.setInvAcctBal(100.00);
        Transactions forceCloseAccount = new Transactions(jeff);
        forceCloseAccount.forceCloseAccount();
        Assert.assertEquals(0.00, jeff.getChkAcctBal(), 0.00);
        Assert.assertEquals(0.00, jeff.getSavAcctBal(),0.00);
        Assert.assertEquals(0.00, jeff.getInvAcctBal(),0.00);
        Assert.assertEquals(null, jeff.getFirstName());
        Assert.assertEquals(null, jeff.getLastName());
        Assert.assertEquals(1000, jeff.getPin());
    }

    //make one last test that tests the transaction history
    @Test
    public void transactionHistoryTest(){
        Account jeff = new Account ("Jeff", "Smith", 1234);
        Transactions history = new Transactions(jeff);
        history.deposit(100.00, "checking");
        history.withdraw(50.00, "checking");
        String[] expected = {"Deposited $100.00 to checking.","Withdrew $50.00 from checking."};
        Assert.assertEquals(expected, history.transactionHistory());

    }

}