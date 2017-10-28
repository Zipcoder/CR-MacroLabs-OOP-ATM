import org.junit.Assert;
import org.junit.Test;

public class atmTest {
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
}
