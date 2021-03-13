import org.junit.Assert;
import org.junit.Test;

public class CheckingTest {

    @Test
    public void CheckingTest(){

        //check constructors


        //given
        Checking checking = new Checking(50000);
        Checking checking2 = new Checking();
        double expected = 50000;
        int expected_account = 1;
        int expected_2nd_account = 2;

        //when
        double actual = checking.getBalance();
        int actual_account = checking.getAcctNumber();
        int actual_2nd_account = checking2.getAcctNumber();

        //then
        Assert.assertTrue("check constructor", expected == actual);
        Assert.assertEquals("check account number", expected_account, actual_account);
        Assert.assertEquals("check account number", expected_2nd_account, actual_2nd_account);

    }

    @Test
    public void depositTest(){

        //given
        Checking checking = new Checking();
        String expected = "Your new balance is $11,000.00";

        //when
        checking.setBalance(6000);
        String actual = checking.deposit(5000);

        //then
        Assert.assertEquals(expected,actual);


    }

    @Test
    public void withdrawlTest(){

        Checking checking = new Checking();
        String expected = "Your new balance is $0.23";

        checking.setBalance(4000.23);
        String actual = checking.withdrawl(4000);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void transferTest(){

        Checking fromChecking = new Checking(3500);
        Savings  toSavings = new Savings(500);

        String expected = "Transfer complete. New 'from' balance is $1,500.00. " +
                "Your new 'to' balance is $2,500.00.";

        String actual = fromChecking.transfer(toSavings, 2000);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest(){
        Savings savings = new Savings();
        String expected = "Account# 1";

        String actual = savings.toString();

        Assert.assertEquals(expected, actual);


    }



}