package atmproject.accounts;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsAccountTest {

    @Test
    public void addInterestTest() {
        SavingsAccount savingsAccount = new SavingsAccount(null,null,null);
        savingsAccount.setBalance(500.0);
        Double expected = savingsAccount.getBalance() + (savingsAccount.getBalance() * (savingsAccount).getInterestRate());
        Double actual = savingsAccount.addInterest();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addInterestTest2() {
        SavingsAccount savingsAccount = new SavingsAccount(null,null,null);
        savingsAccount.setBalance(10.0);
        Double expected = savingsAccount.getBalance() + (savingsAccount.getBalance() * (savingsAccount).getInterestRate());
        Double actual = savingsAccount.addInterest();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getInterestRate() {
        SavingsAccount savingsAccount = new SavingsAccount(null,null,null);
        Double expected = 0.0005;
        Double actual = savingsAccount.getInterestRate();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setInterestRate() {
        SavingsAccount savingsAccount = new SavingsAccount(null,null,null);
        Double expected = 0.0007;
        savingsAccount.setInterestRate(0.0007);

        assertEquals(expected,savingsAccount.getInterestRate());
    }
}