import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreatorTest {

    @Test
    public void createChecking() {
        // : Given
        double initialDeposit = 5000;

        // : When
        Checking checking101 = Creator.createChecking(initialDeposit);
        double actualBalance = checking101.getBalance();

        System.out.println(checking101.getAccountNumber());
        System.out.println(checking101.getBalance());

        // : Then
        Assert.assertEquals(initialDeposit, actualBalance, 0.00001);
        Assert.assertTrue(checking101.getAccountNumber() <= 999 & checking101.getAccountNumber() >= 100);
    }

    @Test
    public void createSavings() {
        // : Given
        double initialDeposit = 25000;

        // : When
        Savings savings101 = Creator.createSavings(initialDeposit);
        double actualBalance = savings101.getBalance();

        System.out.println(savings101.getAccountNumber());
        System.out.println(savings101.getBalance());

        // : Then
        Assert.assertEquals(initialDeposit, actualBalance, 0.00001);
        Assert.assertTrue(savings101.getAccountNumber() <= 9999 & savings101.getAccountNumber() >= 1000);
    }

    @Test
    public void createInvestment() {
        // : Given
        double initialDeposit = 50000;

        // : When
        Investment investment101 = Creator.createInvestment(initialDeposit);
        double actualBalance = investment101.getBalance();

        System.out.println(investment101.getAccountNumber());
        System.out.println(investment101.getBalance());

        // : Then
        Assert.assertEquals(initialDeposit, actualBalance, 0.00001);
        Assert.assertTrue(investment101.getAccountNumber() <= 99999 & investment101.getAccountNumber() >= 10000);
    }

    @Test
    public void createCustomer() {
        // : Given
        String name = "Bruce Wayne";
        String userName = "Batman";
        String password = "Gotham";
        Checking checking101 = Creator.createChecking(500);
        Savings savings101 = Creator.createSavings(2500);
        Investment investment101 = Creator.createInvestment(5000);

        // : When
        Customer bruce = Creator.createCustomer(name, userName, password, checking101, savings101, investment101);
        String actualName = bruce.getCustomerName();
        String actualUserName = bruce.getUserName();
        String actualPassword = bruce.getPassword();

        System.out.println(bruce.getAccountNumber());

        // : Then
        Assert.assertEquals(name, actualName);
        Assert.assertEquals(userName, actualUserName);
        Assert.assertEquals(password, actualPassword);
    }
}