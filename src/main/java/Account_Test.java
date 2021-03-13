import org.junit.Assert;
import org.junit.Test;

public class Account_Test {

    @Test
    public void AccountTest() {
        //: Given
        Account getBalNumTypeTest = new Account(123, 123, "Checking");
        double expected = 123;
        int expected2 = 123;
        String expected3 = "Checking";

        //: When
        double actual = getBalNumTypeTest.getBalance();
        int actual2 = getBalNumTypeTest.getAccountNum();
        String actual3 = getBalNumTypeTest.getAccountType();

        //: Then
        Assert.assertTrue(expected == actual);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);

    }

    @Test
    public void withdrawTest() {
        //: Given
        Account withdrawTest = new Account(123, 456, "Savings");
        double expected = 100;
        int expected2 = 456;
        String expected3 = "Savings";
        //: When
        double actual = withdrawTest.withdraw(23);
        int actual2 = 456;
        String actual3 = "Savings";
        //: Then
        Assert.assertTrue(expected == actual);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);


    }

    @Test
    public void depositTest() {
        //: Given
        Account depositTest = new Account(123, 789, "Investment");
        double expected = 150;
        int expected2 = 789;
        String expected3 = "Investment";
        //: When
        double actual = depositTest.deposit(27);
        int actual2 = 789;
        String actual3 = "Investment";
        //: Then
        Assert.assertTrue(expected == actual);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void showBalanceTest() {
        //: Given
        Account showBalanceTest = new Account(123,101112,"Checking");
        double expected = 200;
        double expected2 = 200;
        int expected3 = 101112;
        String expected4 = "Checking";
        //: When
        double actual = showBalanceTest.deposit(77);
        double actual2 = showBalanceTest.showBalance(200);
        int actual3 = 101112;
        String actual4 = "Checking";
        //: Then
        Assert.assertTrue(expected == actual);
        Assert.assertTrue (expected2 == actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
    }


}