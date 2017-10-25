import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class tests {
    ATM atm = ATM.getInstance();


    @Test       //Test addUsers and returnAllUserSize
    public void addUserTest(){
        int expected = 1;
        atm.addUser("wes","password");
        int actual = atm.returnAllUsersSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void returnNewAccountNumTest(){
        int expected = 1;

        int actual = atm.returnNewAccountNum();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void UserExistTest(){
        atm.addUser("wes","password");
        boolean expected1 = true;
        boolean expected2 = false;

        boolean actual1 = atm.UserExist("wes");
        boolean actual2 = atm.UserExist("bob");

        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
    }

    @Test
    public void UserIndexTest(){
        int expected1 = 0;
        int expected2 = 1;
        atm.addUser("wes","password");
        atm.addUser("bob","password");

        int actual1 = atm.UserIndex("wes");
        int actual2 = atm.UserIndex("bob");

        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
    }

    @Test
    public void UserNameAndPasswordCorrectTest(){
        atm.addUser("wes","password");
        boolean expected1 = true;
        boolean expected2 = false;

        boolean actual1 = atm.UserNameAndPasswordCorrect("wes","password");
        boolean actual2 = atm.UserNameAndPasswordCorrect("bob","password");

        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
    }

    @Test
    public void EnterUserTest(){
        atm.addUser("wes","password");
        String expected = "wes";

        User currentUser = atm.EnterUser("wes");
        String actual = currentUser.getUserName();

        Assert.assertEquals(expected,actual);

    }

    //--------------------------------------------------------------------

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

        int actual = currentUser.accountsArraySize();
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void accountArraySizeTest(){
        atm.addUser("wes","pass");
        User currentUser = atm.EnterUser("wes");
        int expected1 = 0;
        int expected2 = 1;

        int actual1 = currentUser.accountsArraySize();
        currentUser.addAccount("checking");
        int actual2 = currentUser.accountsArraySize();

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
        int actual2 = currentUser.accountsArraySize();
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

        String actual = currentAccount.getType();

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

    //-----------------------------------------------------------------

    @Test       // test getAccountBalance and setAccountBalance
    public void AccountBalanceTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        currentUser.addAccount("checking");
        Account currentAccount = currentUser.EnterAccount(1);

        double expected = 500;

        currentAccount.setBalance(500);

        double actual = currentAccount.getBalance();

        Assert.assertEquals(expected,actual,0);
    }
    @Test       // test getAccountType and setAccountType
    public void AccountTypeTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");

        String expected = "checking";

        currentUser.addAccount(expected);
        Account currentAccount = currentUser.EnterAccount(1);
        String actual = currentAccount.getType();

        Assert.assertEquals(expected,actual);
    }

    @Test       // test getAccountNum and setAccountNum
    public void AccountNumberTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        currentUser.addAccount("savings");
        Account currentAccount = currentUser.EnterAccount(1);

        int expected = 1;

        int actual = currentAccount.getAccountNum();

        Assert.assertEquals(expected,actual);
    }

    @Test       // test getAccountHistory and addToAccountHistory
    public void accountHistoryTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        currentUser.addAccount("savings");
        Account account = currentUser.EnterAccount(1);
        currentUser.deposit(50,account);
        String expected = "Deposit  50.0";

        ArrayList history = account.getAccountHistory();
        String firstPlace = (String)history.get(0);
        String actual = firstPlace;

        Assert.assertEquals(expected,actual);
    }

}
