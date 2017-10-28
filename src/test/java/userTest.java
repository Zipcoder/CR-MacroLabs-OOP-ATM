import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class userTest {
    ATM atm = ATM.getInstance();

    @Test       //Test setUserName and getUserName
    public void setUserNameTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        String expected1 = "wes";
        String expected2 = "bob";

        String actual1 = currentUser.getUserName();
        currentUser.setUserName("bob");
        String actual2 = currentUser.getUserName();

        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
    }

    @Test      //Test setUserPassword and getUserPassword
    public void setUserPasswordTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        String expected1 = "password";
        String expected2 = "newPassword";

        String actual1 = currentUser.getUserPassword();
        currentUser.setUserPassword("newPassword");
        String actual2 = currentUser.getUserPassword();

        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
    }

    @Test
    public void addAccountTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        currentUser.addAccount("checking");
        int expected = 1;

        int actual = currentUser.getAccountsArray().size();

        Assert.assertEquals(expected,actual);
    }


    @Test
    public void accountArraySizeTest(){
        atm.addUser("wes","pass");
        User currentUser = atm.EnterUser("wes");
        int expected1 = 0;
        int expected2 = 1;

        int actual1 = currentUser.getAccountsArray().size();
        currentUser.addAccount("checking");
        int actual2 = currentUser.getAccountsArray().size();

        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
    }

    @Test
    public void getAccountArrayTest(){
        atm.addUser("wes","pass");
        User currentUser = atm.EnterUser("wes");
        int expected = 1;

        currentUser.addAccount("Checking");
        ArrayList accounts = currentUser.getAccountsArray();
        Account account = (Account)accounts.get(0);
        int actual = account.getAccountNum();

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void removeAccountTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        currentUser.addAccount("checking");
        currentUser.addAccount("savings");

        boolean expected1 = true;
        int expected2 = 1;
        boolean expected3 = false;

        boolean actual1 = currentUser.removeAccount(1);
        int actual2 = currentUser.getAccountsArray().size();
        Account currentAccount = currentUser.EnterAccount(2);
        currentAccount.setBalance(50);
        boolean actual3 = currentUser.removeAccount(2);

        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
        Assert.assertEquals(expected3,actual3);


    }

    @Test
    public void AccountExistTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        currentUser.addAccount("checking");
        boolean expected1 = true;
        boolean expected2 = false;

        boolean actual1 = currentUser.AccountExist(1);
        boolean actual2 = currentUser.AccountExist(3);

        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
    }

    @Test
    public void EnterAccountTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        currentUser.addAccount("checking");
        Account currentAccount = currentUser.EnterAccount(1);
        String expected = "checking";

        String actual = currentAccount.getAccountType();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void withdrawTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        currentUser.addAccount("savings");
        Account currentAccount = currentUser.EnterAccount(1);
        currentAccount.setBalance(100);

        double expected = 50;
        currentUser.withdraw(50,currentAccount);

        double actual = currentAccount.getBalance();

        Assert.assertEquals(expected,actual,0);

    }

    @Test
    public void depositTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        currentUser.addAccount("savings");
        Account currentAccount = currentUser.EnterAccount(1);

        double expected = 100;

        currentUser.deposit(100,currentAccount);

        double actual = currentAccount.getBalance();

        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void transferTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        currentUser.addAccount("savings");
        currentUser.addAccount("checking");
        Account firstAccount = currentUser.EnterAccount(1);
        Account secondAccount = currentUser.EnterAccount(2);
        firstAccount.setBalance(100);

        double expected1 = 75;
        double expected2 = 25;

        currentUser.transfer(25,firstAccount,secondAccount);

        double actual1 = firstAccount.getBalance();
        double actual2 = secondAccount.getBalance();

        Assert.assertEquals(expected1,actual1,0);
        Assert.assertEquals(expected2,actual2,0);

    }
}

