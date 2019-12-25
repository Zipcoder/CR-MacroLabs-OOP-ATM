package AccountClasses;


import org.junit.Assert;
import org.junit.Test;

public class CheckingTest {


    @Test
    public void constructorTest()
    {
        Checking testCheck = new Checking();
    }

    @Test
    public void withdrawTest ()
    {
        Checking checkWithdraw  =  new Checking();
        Double expected = -20D;
        Double actual = checkWithdraw.withdraw(20D);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void withdrawTest2 ()
    {
        Checking checkWithdraw  =  new Checking();
        Double expected = -50D;
        Double actual = checkWithdraw.withdraw(50D);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAccountBalTest1 ()
    {
        Checking checkWithdraw  =  new Checking();
        Double expected = 0.0;
        Double actual = checkWithdraw.getAccountBal();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAccountNum1 () {
        Checking accountNum = new Checking();
        Checking accountNum2 = new Checking();
        Checking accountNum3 = new Checking();
        String expected = "A3";
        String actual = accountNum3.getAccountNum();
        Assert.assertEquals(expected, actual);
    }



}