package atmproject;

import atmproject.accounts.Account;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getFirstName() {
        User currentUser = new User("Shadow", "???", 3454);
        String expected = "Shadow";
        String actual = currentUser.getFirstName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setFirstName() {
        User currentUser = new User("Shadow", "???", 3454);
        String expected = "Shadow";
        currentUser.setFirstName(expected);
        Assert.assertEquals(expected,currentUser.getFirstName());
    }

    @Test
    public void getLastName() {
        User currentUser = new User("Shadow", "???", 3454);
        String expected = "???";
        String actual = currentUser.getLastName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setLastName() {
        User currentUser = new User("Shadow", "???", 3454);
        String expected = "???";
        currentUser.setLastName(expected);
        Assert.assertEquals(expected,currentUser.getLastName());

    }

    @Test
    public void getPinNumber() {
        User currentUser = new User("Shadow", "???", 3454);
        Integer expected = 7777;
        currentUser.setPinNumber(expected);
        Assert.assertEquals(expected,currentUser.getPinNumber());
    }

    @Test
    public void setPinNumber() {
        User currentUser = new User("Shadow", "???", 3454);
        Integer expected = 7777;
        currentUser.setPinNumber(expected);
        Assert.assertEquals(expected,currentUser.getPinNumber());
    }

    @Test
    public void getUserID() {
        User currentUser = new User("Shadow", "???", 3454);
        Integer expected = 3454;
        Integer actual = currentUser.getUserID();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setUserID() {
        User currentUser = new User("Shadow", "???", 3454);
        Integer expected = 3454;
        currentUser.setUserID(expected);
        Assert.assertEquals(expected,currentUser.getUserID());
    }

    @Test
    public void getAccountList() {
        User currentUser = new User("Shadow", "???", 3454);
        Account account = new Account(currentUser, 500.0, "Checking Account 1");
        String expected = "{" + account.getAccountName() + "=" + account.toString() + "}";
        account.addAccount(account);
        Assert.assertEquals(expected,currentUser.getAccountList().toString());
    }

    @Test
    public void setAccountList() {
        User currentUser = new User("Shadow", "???", 3454);
        Account account = new Account(currentUser, 500.0, "Checking Account 1");
        TreeMap<String, Account> expected = new TreeMap<String, Account>();
        expected.put(account.getAccountName(),account);
        currentUser.setAccountList(expected);
        Assert.assertEquals(expected.toString(),currentUser.getAccountList().toString());
    }

    @Test
    public void getTransactionHistory() {
        User currentUser = new User("Shadow", "???", 3454);
        String expected = "BLAH BLAH BLAH";
        currentUser.addToHistory(expected);
        Assert.assertEquals(("[" + expected + "]"),currentUser.getTransactionHistory().toString());
    }

    @Test
    public void setTransactionHistory() {
        User currentUser = new User("Shadow", "???", 3454);
        String[] expected = {"BLAH BLAH BLAH"};
    }

    @Test
    public void removeAccount() {
    }

    @Test
    public void displayHistory() {
    }
}