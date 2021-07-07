import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserVillageTest {

    @Test
    public void addUser() {
        User user = new User(0,"Todd","Password");
        UserVillage uV = new UserVillage(user);
        Integer expected = 1;
        Integer actual = uV.getAllUsers().size();

        Assert.assertEquals(expected,actual);
    }
    
    @Test
    public void setAllUsers() {
        User user = new User(0,"Todd","Password");
        User user2 = new User(0,"Ted","Password");
        User user3 = new User(0,"Toby","Password");

        ArrayList<User> expected = new ArrayList<User>();
        ArrayList<User> actual;
        expected.add(user);
        expected.add(user2);
        expected.add(user3);

        UserVillage uV = new UserVillage();
        uV.setAllUsers(expected);
        actual = uV.getAllUsers();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void createUserTest(){
        UserVillage userVillage = new UserVillage();
        String username = "Chung";
        String password = "password";

        userVillage.createUser(username, password);

        Assert.assertTrue(userVillage.checkUser(username));

    }

    @Test
    public void checkLogInTest(){
        UserVillage userVillage = new UserVillage();
        String username = "Chung";
        String password = "password";
        userVillage.createUser(username, password);

        Boolean checking = userVillage.checkLogIn(username, password);

        Assert.assertTrue(checking);
    }

    @Test
    public void checkLogInTest2(){
        UserVillage userVillage = new UserVillage();
        String username = "chung";
        String password = "password";
        userVillage.createUser(username, password);

        Boolean checking = userVillage.checkLogIn(username, "wrongPassword");

        Assert.assertFalse(checking);
    }

    @Test
    public void checkUserTest(){
        UserVillage userVillage = new UserVillage();
        String username = "Chung";

        //checking is username exist
        Boolean checking = userVillage.checkUser(username);

        Assert.assertFalse(checking);
    }

    @Test
    public void checkUserTest2(){
        UserVillage userVillage = new UserVillage();
        String username = "Chung";
        String password = "password";
        userVillage.createUser(username, password);

        //checking is username exist
        Boolean checking = userVillage.checkUser(username);

        Assert.assertTrue(checking);
    }


}