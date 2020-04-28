import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class UserTest {

    User testUser1 = new User("test", "neat");

    User testUser2 = new User("test", "neat");
    User testUser3 = new User("test", "neat");
    private ArrayList<Account> accounts = new ArrayList();

    {
        CheckingAccount checking = new CheckingAccount();
        SavingsAccount savings = new SavingsAccount();
        InvestmentAccount invest = new InvestmentAccount();
        accounts.add(checking);
        accounts.add(savings);
        accounts.add(invest);
    }


    @Test
    public void addCheckingAccount() {
//        int expected = accounts.size();
        CheckingAccount checking = new CheckingAccount();
        accounts.add(checking);
        int expected = accounts.size();
        int actual = accounts.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addSavingsAccount() {
//        int expected = accounts.size();
        SavingsAccount savings = new SavingsAccount();
        accounts.add(savings);
        int expected = accounts.size();
        int actual = accounts.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addInvestmentAccount() {
//        int expected = accounts.size();
        InvestmentAccount invest = new InvestmentAccount();
        accounts.add(invest);
        int expected = accounts.size();
        int actual = accounts.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getUserNameTest() {
        String expected = "test";
        String actual = testUser1.getUserName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getId() {
        int expected = 1;
        int actual = testUser1.getId();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getIdTest() {
        int expected = 2;
        int actual = testUser2.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPassword() {
        String expected = "neat";
        String actual = testUser1.getPassword();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPassword() {
        String expected = testUser1.getPassword();
        testUser1.setPassword("neat");
        String actual = testUser1.getPassword();
        Assert.assertEquals(expected, actual);

    }
}