package com.zipcode.macrolabs.atm.user;

import com.zipcode.macrolabs.atm.bankaccount.Account;
import com.zipcode.macrolabs.atm.bankaccount.AccountStatus;
import com.zipcode.macrolabs.atm.bankaccount.AccountType;
import com.zipcode.macrolabs.atm.exceptions.AccountNotEmptyException;
import com.zipcode.macrolabs.atm.exceptions.TransactionAmountIsZeroException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UserTest {

    User user;

    @Before
    public void setUp(){
        user = UserFactoryTest.createBob();
    }

    @Test
    public void getAndSetUserNameTest(){
        user.setUserName("Code Man");
        String expectedName = "Code Man";
        String actualName = user.getUserName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getAndSetUserPasswordTest(){
        user.setUserPassword("dirtydancing");
        String expectedPassword = "dirtydancing";
        String actualPassword = user.getUserPassword();
        Assert.assertEquals(expectedPassword, actualPassword);
    }

    @Test
    public void getAndSetUserIDTest(){
        user.setUserID(55555);
        String expectedUserID = "000055555";
        String actualUserID = user.getUserID();
        Assert.assertEquals(expectedUserID, actualUserID);
    }

    @Test
    public void getAccountInfoTest(){
        user.createNewAccount(AccountType.CHECKING);
        user.createNewAccount(AccountType.SAVINGS);
        user.createNewAccount(AccountType.INVESTMENT);
        System.out.println(user.getAllUserAccountInfo());
    }

    @Test
    public void createAndAddNewAccountTest(){
        int initialAccountCount = user.getAccounts().size();
        user.createNewAccount(AccountType.CHECKING);
        user.createNewAccount(AccountType.SAVINGS);
        user.createNewAccount(AccountType.INVESTMENT);
        int afterAccountCount = user.getAccounts().size();
        int actualCountDifference = afterAccountCount - initialAccountCount;
        int expectedCountDifference = 3;
        Assert.assertEquals(expectedCountDifference, actualCountDifference);
    }

    @Test
    public void addUserToAccountTest(){
        for (int i = 0; i < 5; i++) {
            UserFactory.createNewUser("Uncle Bob", "cleancode");
        }
        user.createNewAccount(AccountType.CHECKING);
        user.createNewAccount(AccountType.SAVINGS);
        user.createNewAccount(AccountType.INVESTMENT);

        int accountIndex = 1;
        int initialAccountUserNumber = user.getAccounts().get(accountIndex).getAccountUsers().size();
        user.addAnotherUserToExistingAccount(accountIndex, UserWarehouse.findUserByID("000000003"));
        int afterAccountUserNumber = user.getAccounts().get(accountIndex).getAccountUsers().size();
        int actualCountDifference = afterAccountUserNumber - initialAccountUserNumber;
        int expectedCountDifference = 1;
        Assert.assertEquals(expectedCountDifference, actualCountDifference);
    }

    @Test
    public void removeAccountExecutionTest() throws AccountNotEmptyException {

        user.createNewAccount(AccountType.CHECKING);
        user.createNewAccount(AccountType.SAVINGS);
        user.createNewAccount(AccountType.INVESTMENT);

        int initialAccountCount = user.getAccounts().size();
        user.removeAccount(0);
        int afterAccountCount = user.getAccounts().size();
        int expectedCountDifference = -1;
        int actualCountDifference = afterAccountCount - initialAccountCount;
        Assert.assertEquals(expectedCountDifference, actualCountDifference);
    }

    @Test(expected = AccountNotEmptyException.class)
    public void removeAccountBalanceExceptionTest() throws TransactionAmountIsZeroException, AccountNotEmptyException {
        user.createNewAccount(AccountType.CHECKING);
        Account activeAccount = user.getAccounts().get(0);

        activeAccount.depositAndMakeTransaction(50);
        user.removeAccount(0);
    }

    @Test
    public void closeAccountStatusTest() throws AccountNotEmptyException {

        user.createNewAccount(AccountType.CHECKING);
        user.closeAccount(0);

        AccountStatus expectedStatus = AccountStatus.CLOSED;
        AccountStatus actualStatus = user.getAccounts().get(0).getAccountStatus();
        Assert.assertEquals(expectedStatus, actualStatus);
    }

    @Test(expected = AccountNotEmptyException.class)
    public void closeAccountBalanceExceptionTest() throws AccountNotEmptyException, TransactionAmountIsZeroException {
        user.createNewAccount(AccountType.CHECKING);
        Account activeAccount = user.getAccounts().get(0);
        activeAccount.depositAndMakeTransaction(50);
        user.closeAccount(0);
    }

}
