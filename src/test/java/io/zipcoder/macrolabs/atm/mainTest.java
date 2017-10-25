package io.zipcoder.macrolabs.atm; /**
 * Created by Timothy Rager on 10/24/17.
 */
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class mainTest {

    public final double allowedDeltaShares = 0.0001;
    public final double allowedDeltaDollars = 0.001;

//SECURITY CLASS TESTS

    @Test
    public void testSecurityGetName(){
        String expected="XKCD";
        Security security = new Security(expected, 10.02, 25.12);
        String actual = security.getName();

        Assert.assertEquals("The strings do not match", expected, actual);
    }
    @Test
    public void testSecurityGetNumberOwned(){
        double expected=10.030;
        Security security = new Security("XKCD", expected, 25.12);
        double actual = security.getNumberOwned();

        Assert.assertEquals(expected, actual, allowedDeltaShares);//Seeking reasonable precision within
                                                    // three decimal places
    }

    @Test
    public void testSecurityChangeNumberOwned(){
        //double expected=20.034;
        //double changedBy=0.004;
        double expected=20.026;
        double changedBy=-0.004;
        Security security=new Security("XKCD", 20.03,10);
        security.changeNumberOwned(changedBy);
        double actual=security.getNumberOwned();
        Assert.assertEquals(expected, actual, allowedDeltaShares);
    }

    @Test
    public void testSecurityGetValue(){
        double expected=25.12;
        Security security = new Security("XKCD", 200, 25.12);
        double actual = security.getValue();

        Assert.assertEquals(expected, actual, allowedDeltaDollars);//Seeking reasonable precision within
        // three decimal places
    }

//SECURITYFACTORY TESTS

    @Test
    public void testSecurityFactoryCreateRandomSecurity(){
        Security security=SecurityFactory.createRandomSecurity();

        Assert.assertTrue(security instanceof Security);
    }

    @Test
    public void testSecurityFactoryCreateSecurity_PassedString(){
        Security security=SecurityFactory.createSecurity("XKCD");

        Assert.assertTrue(security instanceof Security);
    }

    @Test
    public void testSecurityFactoryCreateSecurity_PassedStringAndSharesOwned(){
        Security security=SecurityFactory.createSecurity("XKCD", 25);

        Assert.assertTrue(security instanceof Security);
    }

//ACCOUNT TESTS

    @Test
    public void testAccountConstructors(){
        boolean expected=true;
        Account[] twoAccounts = {new Account(1),
                                new Account(2,"Checksorg")};
        boolean actual=false;
        if (twoAccounts[0] instanceof Account && twoAccounts[1] instanceof Account)
            actual=true;

        Assert.assertTrue("Construction failed", expected == actual);
    }

    @Test
    public void testAccountChangeBalanceAndGetBalance(){
        //double expected=10.5;
        double expected=-10.5;
        Account account = new Account(1);
        account.changeBalance(expected);
        double actual=account.getBalance();

        Assert.assertEquals(expected, actual, allowedDeltaDollars);
    }

    @Test
    public void testAccountChangeTransactionHistoryAndGetTransactionHistory() {
        Account account=new Account(1);
        ArrayList<Double> expected=new ArrayList<>();
        expected.add(1.1);
        expected.add(-2.2);//expected contains {1.1, -2.2}

        account.changeBalance(1.1);
        account.changeBalance(-2.2);

        ArrayList<Double> actual = account.getTransactionHistory();

        boolean sameElementsInAL = false;

        if (actual.get(0).equals(expected.get(0)) && actual.get(1).equals(expected.get(1)))
            sameElementsInAL = true;
        Assert.assertTrue("The elements in the ALs were not the same", sameElementsInAL);
    }

    @Test
    public void testAccountSetAccountNameAndGetAccountName(){
        Account account = new Account (1,"For College");
        String expected = "For Boat";
        //account.setAccountName("For Beer");
        account.setAccountName(expected);
        String actual = account.getAccountName();

        Assert.assertEquals("the strings do not match", expected, actual);
    }

    @Test
    public void testAccountGetOwnerID(){
        Account account = new Account(1);
        //int expected = 2;
        int expected = 1;
        int actual = account.getOwnerID();

        Assert.assertTrue("The ownerIDs do not match",expected==actual);
    }

//INVESTMENTACCOUNT TESTS

    @Test
    public void testInvestmentAccountConstructorAndGetCommissionRate(){
        InvestmentAccount ia = new InvestmentAccount(1,
                                                    "Retirement",
                                                    6.95);
        double expected = 6.95;
        double actual = ia.getCommissionRate();
        Assert.assertEquals(expected, actual, allowedDeltaDollars);
    }

    @Test
    public void testInvestmentAccountSetCommissionRate(){
        InvestmentAccount ia = new InvestmentAccount(1,
                "Retirement",
                6.95);
        double expected = 9.95;
        ia.setCommissionRate(expected);
        double actual = ia.getCommissionRate();
        Assert.assertEquals(expected, actual, allowedDeltaDollars);
    }

    @Test
    public void testInvestmentAccountGetSecurityList(){
        InvestmentAccount ia = new InvestmentAccount(1, "Retirement");
        Assert.assertTrue("Null", ia.getSecurityList()!=null);
    }

    //tradeSecurity(String,double)
    //This public method implicitly tests several private methods.
    // If passed positive shares, we buy. If negative, we sell. If 0, return false
    //Tests buySecurity -> generateSecurityToBuy ->isCashAvailableToBuy -> calculateSecuritiesTotalValue
    //          returns true if everything worked as intended, false otherwise.
    //Tests sellSecurity -> isSecurityAvailableToSell -> calculateSecuritiesTotalValue
    //          returns true if everything worked as intended, false otherwise.


    @Test
    public void testInvestmentAccountTradeSecurityPassed_0(){
        InvestmentAccount ia = new InvestmentAccount(1,"R");
        boolean expected=false;
        boolean actual=ia.tradeSecurity("XKCD",0);

        Assert.assertTrue("Shouln't be able to trade on 0 shares", expected==actual);
    }

    @Test
    public void testInvestmentAccountTradeSecurityPassed_Positive(){
        InvestmentAccount ia = new InvestmentAccount(1,"R");
        ia.changeBalance(10000000);//Seed the account with cash
        boolean expected=true;
        boolean actual=ia.tradeSecurity("XKCD",1);

        Assert.assertTrue("Failed to transact", expected==actual);
    }

    @Test
    public void testInvestmentAccountTradeSecurityPassed_Negative(){
        //Must create a security in order to sell it, so we repeat the
        //code from "."_Positive(), above
        InvestmentAccount ia = new InvestmentAccount(1,"R");
        ia.changeBalance(10_000_000);//Seed the account with cash
        boolean expected=true;
        boolean actual=ia.tradeSecurity("XKCD",1);//Placeholder to generate security to sell
        //We can reasonably expect that if, after running the sell, the value of the
        //account's cash position is 10_000_000 - commission*2 then things ran smoothly.
        //Another possibility for testing these methods?
        //System.out.println("$10,000,000 - "+ia.getCommissionRate()*2+" = "+
        //        (10_000_000-(ia.getCommissionRate()*2)));
        actual=ia.tradeSecurity("XKCD",-1);

        Assert.assertTrue("Failed to transact", expected==actual);
    }

}
