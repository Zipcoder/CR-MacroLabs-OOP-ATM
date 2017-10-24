package io.zipcoder.macrolabs.atm; /**
 * Created by Timothy Rager on 10/24/17.
 */
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class mainTest {

    public final double allowedDeltaShares = 0.0001;
    public final double allowedDeltaDollars = 0.001;

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

        /*Testing Security.equals(null)*/
        Security security=SecurityFactory.createRandomSecurity();
        Security security1=null;

        Assert.assertTrue("The ownerIDs do not match",expected==actual);
    }
}
