


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UserFactoryTest {

    User testUser = new User("", "", 1);


    @Test
    public void createUserTest() {
        User expected = new User("jim","pass",1);
        User actual=UserFactory.createUser("jim","pass",1);
        Assert.assertEquals(expected,actual);
    }

//    @Test
//    public void setUserNameTest() {
//        String expected = "Jim";
//        String actual = testUser.setUserName("Jim");
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void setPassWord() {
//        String expected = "neat";
//        String actual = testUser.setPassword("neat");
//        Assert.assertEquals(expected, actual);
//    }
}