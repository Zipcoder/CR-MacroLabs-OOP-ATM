package atmproject.accounts;

import atmproject.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvestmentsAccountTest {

    @Test
    public void constructorTest(){
        User currentUser = new User("Shadow",null,null);
        Double expectedBalance = 15000.0;
        String expectedName = "Investments Account 1";
        InvestmentsAccount account = new InvestmentsAccount(currentUser, expectedBalance, expectedName);

        Double actualBalance = account.getBalance();
        String actualName = account.getAccountName();

        Assert.assertEquals(expectedBalance,actualBalance);
        Assert.assertEquals(expectedName,actualName);
    }

/*    @Test
    public void getMinimumDepositTest() {
        InvestmentsAccount investmentsAccount = new InvestmentsAccount(null,null,null);
        Double expected = 15000.0;
        Double actual = investmentsAccount.getMinimumDeposit();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setMinimumDepositTest() {
        InvestmentsAccount investmentsAccount = new InvestmentsAccount(null,null,null);
        Double expected = 35000.0;
        investmentsAccount.setMinimumDeposit(expected);
        assertEquals(expected,investmentsAccount.getMinimumDeposit());
    }

    @Test
    public void enoughForInitialBalanceFalseTest() {
        InvestmentsAccount investmentsAccount = new InvestmentsAccount(null,null,null);
        Double input = 13000.0;
        String expected = String.format("We apologize. Your starting balance must be at least $%f0", investmentsAccount.getMinimumDeposit());
        String actual = investmentsAccount.enoughForInitialBalance(input);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void enoughForInitialBalanceTrueTest() {
        InvestmentsAccount investmentsAccount = new InvestmentsAccount(null,null,null);
        Double input = 17000.0;
        String expected = "Thank you! Enjoy your new investment account.";
        String actual = investmentsAccount.enoughForInitialBalance(input);
        Assert.assertEquals(expected,actual);
    }
*/
}