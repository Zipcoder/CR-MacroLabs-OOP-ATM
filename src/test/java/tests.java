import org.junit.Assert;
import org.junit.Test;

public class tests {
    ATM atm = new ATM();
    User user = new User();
    Account account = new Account();

    @Test
    public void addUserTest(){
        int expected = 1;
        atm.addUser();
        int actual = atm.returnAllUsersSize();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void findUserTest(){

    }

    @Test
    public void UserNameTest(){
        String expected = "wes";

        user.setUserName("wes");
        String actual = user.getUserName();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void UserPasswordTest(){
        String expected = "password";

        user.setUserPassword("password");
        String actual = user.getUserPassword();

        Assert.assertEquals(expected,actual);
    }


    @Test
    public void addAccountTest(){

        //int expected = 1;
        char expected = 'c';

        Object newAccountObject = user.addAccount('c');


        //int actual = user.returnAccountLength();
        char actual = ;

        Assert.assertEquals(expected,actual);
    }


    @Test
    public void AccountBalanceTest(){

        double expected = 500;

        account.setBalance(500);

        double actual = account.getBalance();

        Assert.assertEquals(expected,actual,0);

    }

    @Test
    public void AccountIndexTest(){
        int expected = 1;

        user.addAccount('c');
        user.addAccount('s');
        int actual = user.findAccountIndex(1);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void addedAccountBalanceTest(){
        char expected = 'c';

        user.addAccount('c');
        //char actual = ;

        //int actual = user.returnAccountLength();

        //Assert.assertEquals(expected,actual);
    }


}
