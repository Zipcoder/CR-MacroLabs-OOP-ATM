package atmproject.accounts;

import atmproject.User;
import atmproject.accounts.Account;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;


// Test the expected Account class from ATM.
public class AccountTest {

    @Test
    public void testA0() {
        Account a = new Account(0.0);
        assertEquals(0.0, a.getBalance(), 0.0001);
    }

    @Test
    public void testA00() {
        Account a = new Account(10.0);
        assertEquals(10.0, a.getBalance(), 0.0001);
    }

    @Test
    public void testA1() {
        Account a = new Account(0.0);
        a.deposit(100.0);
        assertEquals(100.0, a.getBalance(), 0.0001);
    }

    @Test
    public void testA2() {
        Account a = new Account(10.0);
        a.deposit(100.0);
        assertEquals(110.0, a.getBalance(), 0.0001);
    }

    @Test
    public void testA3() {
        Account a = new Account(200.0);
        Double actual = a.withdraw(100.0);
        assertEquals(100.0, actual, 0.0001);
    }

    @Test
    public void testA4() {
        Account a = new Account(0.0);
        Double actual = a.withdraw(1.0);
        assertEquals(0.0, actual, 0.0001);
    }

    @Test
    public void testA5() {
        Account a = new Account(10.0);
        Account b = new Account(0.0);
        a.transfer(b, 10.0);
        assertEquals(0.0, a.getBalance(), 0.0001);
        assertEquals(10.0, b.getBalance(), 0.0001);
    }

    @Test
    public void testA6() {
        Account a = new Account(10.0);
        Account b = new Account(0.0);
        a.transfer(b, 100.0); // nothing should happen
        assertEquals(10.0, a.getBalance(), 0.0001);
        assertEquals(0.0, b.getBalance(), 0.0001);
    }

    @Test
    public void getCurrentUserTest() {
        User currentUser = new User("Sabin", "Figaro", 456456);
        Account account = new Account(currentUser, 0.0,null);
        User expected = new User("Sabin", "Figaro", 456456);
        User actual = account.getCurrentUser();

        Assert.assertEquals(actual.getFirstName(),expected.getFirstName());
    }

    @Test
    public void setCurrentUser() {
        User currentUser = new User("Sabin", "Figaro", 456456);
        Account account = new Account(0.0);
        account.setCurrentUser(currentUser);

        Assert.assertEquals(account.getCurrentUser(), currentUser);
    }

    @Test
    public void getBalance() {
        Account account = new Account(0.0);
        Double expected = 0.0;
        Double actual = account.getBalance();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setBalance() {
        Account account = new Account(0.0);
        Double expected = 100.0;
        account.setBalance(expected);

        Assert.assertEquals(expected,account.getBalance());
    }

    @Test
    public void depositTest() {
        Account account = new Account(0.0);
        account.setBalance(100.0);
        Double input = 80.0;
        account.deposit(input);


        Double expected = 180.0;

        Assert.assertEquals(expected,account.getBalance());
    }

    @Test (expected = InvalidParameterException.class)
    public void depositTestFalse() throws InvalidParameterException {
        Account account = new Account(0.0);
        Double input = -80.0;
        account.deposit(input);
    }

    @Test
    public void withdrawTest() {
        Account account = new Account(0.0);
        account.setBalance(100.0);
        Double input = 80.0;
        account.withdraw(input);


        Double expected = 20.0;

        Assert.assertEquals(expected,account.getBalance());
    }

    @Test (expected = InvalidParameterException.class)
    public void withdrawTestFalse() throws InvalidParameterException{
        Account account = new Account(0.0);
        Double input = -80.0;
        account.withdraw(input);
    }

    @Test
    public void getAccountName() {
        Account account = new Account(null,null,"testAccount");
        String expected = "testAccount";
        String actual = account.getAccountName();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setAccountName() {
        Account account = new Account(null,null,null);
        String expected = "testAccount";
        account.setAccountName(expected);

        Assert.assertEquals(expected,account.getAccountName());
    }

    @Test (expected = InvalidParameterException.class)
    public void transferTestFalse() throws InvalidParameterException{
        Account account = new Account(0.0);
        Account account2 = new Account(0.0);
        Double input = -80.0;
        account.transfer(account2, input);
    }
}
