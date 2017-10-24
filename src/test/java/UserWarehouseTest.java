import org.junit.Assert;
import org.junit.Test;

public class UserWarehouseTest {

    @Test
    public void addUserTest() {
        //: Given
        UserWarehouse allUsers = new UserWarehouse();
        User testUser = new User("a");
        User expected = testUser;

        //: When
        allUsers.addUser(testUser);
        User actual = UserWarehouse.getAllUsers().get(UserWarehouse.getAllUsers().size()-1);

        //: Then
        Assert.assertEquals(expected, actual);
    }

    /*
    @Test
    public void verifyValidUserIDTest() {
        //: Given
        UserWarehouse allUsers = new UserWarehouse();
        boolean expected = true;

        //: When
        allUsers.addUser(new User("a"));
        allUsers.addUser(new User("a"));
        allUsers.addUser(new User("a"));
        allUsers.addUser(new User("a"));
        boolean actual = UserWarehouse.verifyValidUserID(3);

        //: Then
        Assert.assertEquals(expected, actual);
    }/**/

    @Test
    public void returnUserFromIDTest() {
        //: Given
        UserWarehouse allUsers = new UserWarehouse();
        int expected = 3;

        //: When
        allUsers.addUser(new User("a"));
        allUsers.addUser(new User("a"));
        allUsers.addUser(new User("a"));
        allUsers.addUser(new User("a"));
        int actual = UserWarehouse.returnUserFromID(3).getUserID();

        //: Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void generateMyUsersTest1() {
        //: Given
        UserWarehouse allUsers = new UserWarehouse();
        int expected = 4;

        //: When
        UserWarehouse.generateMyUsers();
        int actual = UserWarehouse.getAllUsers().size();

        //: Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void generateMyUsersTest2() {
        //: Given
        UserWarehouse allUsers = new UserWarehouse();
        boolean expected = true;

        //: When
        UserWarehouse.generateMyUsers();
        boolean actual = UserWarehouse.returnUserFromID(3).isCorrectPassword("cat");

        //: Then
        Assert.assertEquals(expected, actual);
    }
}
