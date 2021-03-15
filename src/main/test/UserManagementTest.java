import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class UserManagementTest {

    @Test
    public void testConstructor() {
        UserManagement um = new UserManagement("TestAccount", "123");

        String actual = (String) um.getUserAccountsList().get("TestAccount");
        String actual2 = (String) um.getUserNamePasswordMap().get("TestAccount");

        Assert.assertEquals(actual, null);
    }

    @Test
    public void testValidateUserNameExists() {
        UserManagement um = new UserManagement("TestAccount", "123");

        um.setUpUserAccount();
        boolean actual = um.validateUserNameExists();

        Assert.assertTrue(actual);
    }

    @Test
    public void testValidatePasswordCorrect() {
        UserManagement um = new UserManagement("TestAccount", "123");

        um.setUpUserAccount();
        boolean actual = um.validatePasswordCorrect();

        Assert.assertTrue(actual);
    }

    @Test
    public void setUpUserAccount() {
        UserManagement um = new UserManagement("TestAccount", "123");

        um.setUpUserAccount();
        boolean actualPass = um.validatePasswordCorrect();
        boolean actualUN = um.validateUserNameExists();

        Assert.assertTrue(actualPass);
        Assert.assertTrue(actualUN);
    }

    @Test
    public void closeUserAccount() {
        UserManagement um = new UserManagement("TestAccount", "123");

        um.setUpUserAccount();
        um.closeAccount();

        String actual = (String) um.getUserNamePasswordMap().get("TestAccount");
        String actual2 = (String) um.getUserAccountsList().get("TestAccount");

        Assert.assertEquals(actual, null);
        Assert.assertEquals(actual2, null);
    }

}
