package atmproject;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class UserLoginTest {

    @Test
    public void getFirstName(){
        String input = "Shadow";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserLogin login = new UserLogin();
        String actual = login.getFirstNameInput();
        Assert.assertEquals(input,actual);
    }

    @Test
    public void getLastName(){
        String input = "???";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserLogin login = new UserLogin();
        String actual = login.getLastNameInput();
        Assert.assertEquals(input,actual);
    }

    @Test
    public void getUserInfo() {
    }

    @Test
    public void getLoginInfo() {
    }

    @Test
    public void getPINInputTest(){

    }

    @Test
    public void createUser() {
    }

    @Test
    public void initialAccountTest(){
        UserLogin login = new UserLogin();
        User currentUser = new User(null,null,null);
        login.initialAccount(currentUser);

        Assert.assertTrue(currentUser.getAccountList().containsKey("Checkings Account#1"));
    }

    @Test
    public void login() {
    }
}