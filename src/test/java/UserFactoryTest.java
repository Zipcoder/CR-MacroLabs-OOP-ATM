


import org.junit.Assert;
import org.junit.Test;


public class UserFactoryTest {

    User testUser = new User("jim", "neat");


    @Test
    public void createUserTest() {
        User newUser= testUser;
        String expected = newUser.getUserName();
        User actualUser = UserFactory.createUser("jim", "neat");
        String actual = actualUser.getUserName();


        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setUserNameTest() {

        String expected = testUser.getUserName();
        testUser.setUserName("jim");
        String actual = testUser.getUserName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPassWord() {
        String expected = testUser.getPassword();
        testUser.setPassword("neat");
        String actual = testUser.getPassword();

        Assert.assertEquals(expected, actual);
    }
}