package com.zipcode.macrolabs.atm.bankaccount;

import com.zipcode.macrolabs.atm.exceptions.*;
import com.zipcode.macrolabs.atm.transaction.*;
import com.zipcode.macrolabs.atm.user.*;

import org.junit.*;

import java.util.ArrayList;

public class AccountFactoryTest {

    Account[] accounts = new Account[3];
    User user;
    Account checkingAccount;
    Account savingsAccount;
    Account investmentAccount;

    @Before
    public void setUp(){
        user = UserFactory.createNewUser("Uncle Bob", "cleancode");
        checkingAccount = AccountFactory.createNewCheckingAccount(user);
        accounts[0] = checkingAccount;
        savingsAccount = AccountFactory.createNewSavingsAccount(user);
        accounts[1] = savingsAccount;
        investmentAccount = AccountFactory.createNewInvestmentAccount(user);
        accounts[2] = investmentAccount;
        AccountFactory.iteratedAccountID = 0;
    }

    @After
    public void tearDown(){
        AccountFactory.iteratedAccountID = 0;
    }

    @Test(expected = NoMoreAccountsException.class)
    public void noMoreAccountsTest() throws NoMoreAccountsException {
        AccountFactory.iteratedAccountID += (int) Math.pow(10, AccountFactory.ACCOUNT_ID_LENGTH);
        int nextID = AccountFactory.nextAccountID();
    }


    @Test
    public void setIDTest() {
        int expectedID = 5;
        for(Account account: accounts) {
            account.setAccountID(5);
            int actualID = Integer.valueOf(account.getAccountID());
            Assert.assertEquals(expectedID, actualID);
        }
    }

    @Test
    public void iteratingIDTest(){
        int iterations = 5;
        for (int i = 0; i < iterations; i++) {
            AccountFactory.createNewCheckingAccount(user);
        }
        Assert.assertEquals(iterations, AccountFactory.iteratedAccountID);
    }

    @Test
    public void setAccountBalanceTest(){
        for(Account account: accounts) {
            double expectedBalance = 0.00d;
            Assert.assertEquals(expectedBalance, account.getBalance(), 0.001d);
        }
    }

     @Test
    public void setAccountTypeTest(){

         AccountType expectedType1 = AccountType.CHECKING;
         AccountType accountType1 = checkingAccount.getAccountType();
         System.out.println(accountType1);
         Assert.assertEquals(expectedType1, accountType1);

         AccountType expectedType2 = AccountType.SAVINGS;
         AccountType accountType2 = savingsAccount.getAccountType();
         System.out.println(accountType2);
         Assert.assertEquals(expectedType2, accountType2);

         AccountType expectedType3 = AccountType.INVESTMENT;
         AccountType accountType3 = investmentAccount.getAccountType();
         System.out.println(accountType3);
         Assert.assertEquals(expectedType3, accountType3);
    }

    @Test
    public void setUserTest(){
        for(Account account: accounts) {
            int expectedUserCount = 1;
            ArrayList<User> users = account.getAccountUsers();
            Assert.assertEquals(expectedUserCount, users.size());
        }
    }

    @Test
    public void setAccountStatusTest(){
        for(Account account: accounts) {
            AccountStatus expectedStatus = AccountStatus.ACTIVE;
            Assert.assertEquals(expectedStatus, account.getAccountStatus());
        }
    }

    @Test
    public void setTransactionTest(){
        for(Account account: accounts) {
            int expectedTransactionCount = 0;
            ArrayList<Transaction> transactions = account.getTransactionHistory();
            Assert.assertEquals(expectedTransactionCount, transactions.size());
        }
    }


}
