package atmproject.accounts;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvestmentsAccountTest {

    @Test
    public void getMinimumDepositTest() {
        InvestmentsAccount investmentsAccount = new InvestmentsAccount(null);
        Double expected = 15000.0;
        Double actual = investmentsAccount.getMinimumDeposit();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setMinimumDepositTest() {
        InvestmentsAccount investmentsAccount = new InvestmentsAccount(null);
        Double expected = 35000.0;
        investmentsAccount.setMinimumDeposit(expected);
        Assert.assertEquals(expected,investmentsAccount.getMinimumDeposit());
    }

    @Test
    public void enoughForInitialBalanceFalseTest() {
        InvestmentsAccount investmentsAccount = new InvestmentsAccount(null);
        Double input = 13000.0;
        String expected = String.format("We apologize. Your starting balance must be at least $%f0", investmentsAccount.getMinimumDeposit());
        String actual = investmentsAccount.enoughForInitialBalance(input);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void enoughForInitialBalanceTrueTest() {
        InvestmentsAccount investmentsAccount = new InvestmentsAccount(null);
        Double input = 17000.0;
        String expected = "Thank you for creating this new account.";
        String actual = investmentsAccount.enoughForInitialBalance(input);
        Assert.assertEquals(expected,actual);
    }

}