import org.junit.Assert;
import org.junit.Test;

public class UserTest {
    @Test
    public void userContructorTest(){
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);

        Assert.assertEquals(id, user.getUserID());
        Assert.assertEquals(username, user.getUserName());
        Assert.assertEquals(password, user.getPassword());
    }

    @Test
    public void addingAccountTest(){
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);


        /////i know this test SUCKS!!/////
        Assert.assertTrue(user.addingAccount(id));
    }
    @Test
    public void getUserIdTest(){
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);

        Integer expected = 2;
        user.setUserID(expected);

        Assert.assertEquals(expected, user.getUserID());
    }
    @Test
    public void getUsernameTest(){
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);

        String expected = "Chungsing";
        user.setUserName(expected);

        Assert.assertEquals(expected, user.getUserName());
    }
    @Test
    public void getPasswordTest(){
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);

        String expected = "expectedPassword";
        user.setPassword(expected);

        Assert.assertEquals(expected, user.getPassword());
    }


}
