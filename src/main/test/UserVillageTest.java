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
    public void getAllUsers() {
        User user = new User(0,"Todd","Password");
        User user2 = new User(1,"Ted","Password");
        User user3 = new User(2,"Toby","Password");

        UserVillage uV = new UserVillage(user);
        uV.addUser(user2);
        uV.addUser(user3);
        ArrayList<User> userList = uV.getAllUsers();
        String actual = "";
        String expected = "012";
        for (int i = 0; i < userList.size(); i++) {
            actual = actual.concat(String.valueOf(userList.get(i).getUserID()));
        }
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
}