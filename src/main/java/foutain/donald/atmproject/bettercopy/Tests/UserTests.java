package foutain.donald.atmproject.bettercopy.Tests;

import foutain.donald.atmproject.bettercopy.UserFunctions.User;
import org.junit.Assert;
import org.junit.Test;

public class UserTests {
    User newUser = new User();

    @Test
    public void randomAccountGeneratorTest(){
        int expected = 0;

        int actual = newUser.randomAccountGenerator();

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getAccountNumberTest(){
        int expected = 0;

        int newAccountNUmber = 10000;
        newUser.setAccountNumber(newAccountNUmber);
        int actual = newUser.getAccountNumber();

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void getUserName(){
        String expected = "Donald Fountain";

        newUser.setUserName(expected);
        String actual = newUser.getUserName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getUserPassword(){
        String expected = "Password";

        newUser.setUserPassword(expected);
        String actual = newUser.getUserPassword();

        Assert.assertEquals(expected, actual);
    }
}
