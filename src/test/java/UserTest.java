import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class UserTest {

    User testUser = new User("test", "neat", 1);
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
        CheckingAccount checking = new CheckingAccount();
        accounts.add(checking);
        int expected = accounts.size();
        int actual = accounts.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addSavingsAccount() {
        SavingsAccount savings = new SavingsAccount();
        accounts.add(savings);
        int expected = accounts.size();
        int actual = accounts.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addInvestmentAccount() {
        InvestmentAccount invest = new InvestmentAccount();
        accounts.add(invest);
        int expected = accounts.size();
        int actual = accounts.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getUserNameTest() {
        String expected = "test";
        String actual = testUser.getUserName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getId() {
        int expected = 1;
        int actual = testUser.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPassword() {
        String expected = "neat";
        String actual = testUser.getPassword();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPassword() {
        String expected = testUser.getPassword();
        testUser.setPassword("neat");
        String actual = testUser.getPassword();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void checkBalanceCheckingTest() {
        double expected = 20;
        double actual = accounts.get(0).addFunds(20);

        Assert.assertEquals(expected, actual, 0);
    }
}