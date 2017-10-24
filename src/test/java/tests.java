import org.junit.Assert;
import org.junit.Test;

public class tests {
    ATM atm = ATM.getInstance();




    @Test
    public void addUserTest(){
        int expected = 1;
        atm.addUser("wes","password");
        int actual = atm.returnAllUsersSize();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void UserExistTest(){
        atm.addUser("wes","password");
        boolean expected1 = true;
        boolean expected2 = false;

        boolean actual1 = atm.UserExist("wes","password");
        boolean actual2 = atm.UserExist("bob","password");

        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
    }


    @Test
    public void UserNameTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes","password");
        String expected1 = "wes";
        String expected2 = "bob";

        String actual1 = currentUser.getUserName();
        currentUser.setUserName("bob");
        String actual2 = currentUser.getUserName();

        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
    }

    @Test
    public void UserPasswordTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes","password");
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
        User currentUser = atm.EnterUser("wes","password");
        currentUser.addAccount('c');
        int expected = 1;

        int actual = currentUser.accountsArraySize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeAccountTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes","password");
        currentUser.addAccount('c');
        currentUser.addAccount('s');

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
    public void accountExistTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes","password");
        currentUser.addAccount('c');
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
        User currentUser = atm.EnterUser("wes","password");
        currentUser.addAccount('c');
        Account currentAccount = currentUser.EnterAccount(1);
        char expected = 'c';

        char actual = currentAccount.getType();

        Assert.assertEquals(expected,actual);
    }


    @Test
    public void AccountBalanceTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes","password");
        currentUser.addAccount('c');
        Account currentAccount = currentUser.EnterAccount(1);

        double expected = 500;

        currentAccount.setBalance(500);

        double actual = currentAccount.getBalance();

        Assert.assertEquals(expected,actual,0);

    }

    @Test
    public void depositTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes","password");
        currentUser.addAccount('s');
        Account currentAccount = currentUser.EnterAccount(1);

        double expected = 100;

        currentUser.deposit(100,currentAccount);

        double actual = currentAccount.getBalance();

        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void withdrawTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes","password");
        currentUser.addAccount('s');
        Account currentAccount = currentUser.EnterAccount(1);
        currentAccount.setBalance(100);

        double expected = 50;
        currentUser.withdraw(50,currentAccount);

        double actual = currentAccount.getBalance();

        Assert.assertEquals(expected,actual,0);

    }

    @Test
    public void transferTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes","password");
        currentUser.addAccount('s');
        currentUser.addAccount('c');
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
