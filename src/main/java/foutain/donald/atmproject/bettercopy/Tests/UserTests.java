package foutain.donald.atmproject.bettercopy.Tests;

import foutain.donald.atmproject.bettercopy.UserFunctions.User;
import org.junit.Assert;
import org.junit.Test;

public class UserTests {

    @Test
    public void randomAccountGeneratorTest(){
        User newUser = new  User();
        int expected = 0;

        int actual = newUser.randomAccountGenerator();

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getAccountNumberTest(){
        int expected = 0;
        User newUser = new User();

        int newAccountNUmber = 10000;
        newUser.setAccountNumber(newAccountNUmber);
        int actual = newUser.getAccountNumber();

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void getUserName(){
        User newUser = new User();
        String expected = "Donald Fountain";

        String userName = "Donald Fountain";
        newUser.setUserName(userName);
        String actual = newUser.getUserName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getUserPassword(){
        User newUser = new User();
        String expected = "Password";

        String password = "Password";
        newUser.setUserPassword(password);
        String actual = newUser.getUserPassword();

        Assert.assertEquals(expected, actual);
    }
}
