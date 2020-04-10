package foutain.donald.atmproject.bettercopy.Tests;

import foutain.donald.atmproject.bettercopy.UserFunctions.User;
import foutain.donald.atmproject.bettercopy.UserFunctions.UserFactory;
import org.junit.Assert;
import org.junit.Test;

public class UserFactoryTests {

    /*@Test
    public void createNewUserTest(){
        //Given:
        UserFactory newUser = new UserFactory();
        String expected = "Donald Fountain" + "Password";

        //When;
        String password = "Password";
        String userName = "Donald Fountain";
        User expectedInput = newUser.createNewUser(userName, password);
        String outPut = expectedInput.getUserName() + expectedInput.getUserPassword();

        //Then:
        Assert.assertEquals(expected, outPut);
    }
*/
    @Test
    public void createNewUserTestLeon(){
        //Given:
        UserFactory userCreator = new UserFactory();
        String expectedUsername = "Donald Fountain";
        String expectedPassword = "Password";

        // : When
        User expectedUser = userCreator.createNewUser(expectedUsername, expectedPassword);
        String actualUsername = expectedUser.getUserName();
        String actualPassword = expectedUser.getUserPassword();


        // : Then
        Assert.assertEquals(expectedPassword, actualPassword);
        Assert.assertEquals(expectedUsername, actualUsername);
    }
}
