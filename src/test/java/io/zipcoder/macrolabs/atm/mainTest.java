package io.zipcoder.macrolabs.atm; /**
 * Created by Timothy Rager on 10/24/17.
 */

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class mainTest {

    public final double allowedDeltaShares = 0.0001; //Securities to three decimal places-->Accuracy, not formatting
    public final double allowedDeltaDollars = 0.001; //Dollars to two decimal places     -->Accuracy, not formatting

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
    public void testSecurityChangeNumberOwned_PassNegative(){
        double expected=20.026;
        double changedBy=-0.004;
        Security security=new Security("XKCD", 20.03,10);
        security.changeNumberOwned(changedBy);
        double actual=security.getNumberOwned();
        Assert.assertEquals(expected, actual, allowedDeltaShares);
    }

    @Test
    public void testSecurityChangeNumberOwned_PassPositive(){
        double expected=20.034;
        double changedBy=0.004;
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

        Assert.assertEquals(expected, actual, allowedDeltaDollars);
    }

//SECURITYFACTORY TESTS

    @Test
    public void testSecurityFactoryCreateRandomSecurity(){
        Security security=SecurityFactory.createRandomSecurity();
        //We'll check the fields of security and if they are not of the correct type / format
        // then set to false (ie, name should be three characters long, value and numberOwned
        //should be positive

        Assert.assertTrue(security.getValue()>=0);
        Assert.assertTrue(security.getNumberOwned()>=0);
        Assert.assertTrue(security.getName().length()==3);

    }

    @Test
    public void testSecurityFactoryCreateSecurity_PassedString(){
        Security security=SecurityFactory.createSecurity("XKCD");

        Assert.assertTrue(security.getValue()>=0);
        Assert.assertTrue(security.getNumberOwned()>=0);
        Assert.assertTrue(security.getName().length()==4);
    }

    @Test
    public void testSecurityFactoryCreateSecurity_PassedStringAndSharesOwned(){
        Security security=SecurityFactory.createSecurity("XKCD", 25);

        Assert.assertTrue(security.getValue()>=0);
        Assert.assertTrue(security.getNumberOwned()>=0);
        Assert.assertTrue(security.getName().length()==4);
    }

//ACCOUNT TESTS
    @Test
    public void testAccountGetAccountNumber()
    {
        Account account=new Account(1);
        Account secondAccount=new Account(1);
        int expected=secondAccount.getAccountNumber();

        for (int i=1; i<=10; i++)
        {
            account=new Account(i);
            expected++;
        }
        for (int i=1; i<=10; i++)
        {
            secondAccount=new Account(i);
            expected++;
        }
        int actual = secondAccount.getAccountNumber();

        Assert.assertEquals("Account numbers don't match", expected, actual);
    }
    @Test
    public void testAccountConstructors(){
        Account[] twoAccounts = {new Account(1),
                                new Account(2,"Checksorg")};
        Assert.assertTrue(twoAccounts[0].getAccountName().isEmpty());
        Assert.assertTrue(!(twoAccounts[1].getAccountName().isEmpty()));
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
        ArrayList<String> expected=new ArrayList<>();

        expected.add("Account, overload changeBalance   1.1");
        expected.add("Account, overload changeBalance   -2.2");//expected contains {1.1, -2.2}

        account.changeBalance(1.1);
        account.changeBalance(-2.2);

        ArrayList<String> actual = account.getTransactionHistory();

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
    public void testInvestmentAccountConstructorPassedIdOnly(){
        InvestmentAccount ia = new InvestmentAccount(1);
        String expected = "Investment Account";
        String actual = ia.getAccountName();
        Assert.assertEquals("Constructor sans nickname default not working", expected, actual);
    }

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
    //This public method implicitly runs several private methods.
    // If passed positive shares, we buy. If negative, we sell. If 0, return false
    //Tests buySecurity -> generateSecurityToBuy ->isCashAvailableToBuy -> calculateSecuritiesTotalValue
    //          returns true if everything worked as intended, false otherwise.
    //Tests sellSecurity -> isSecurityAvailableToSell -> calculateSecuritiesTotalValue
    //          returns true if everything worked as intended, false otherwise.
    //
    //Note that as a consequence of calling calculateSecuritiesTotalValue() we also
    //call the setters for securitiesTotalValue and totalAccountValue.


    @Test
    public void testInvestmentAccountTradeSecurityPassed_0(){
        InvestmentAccount ia = new InvestmentAccount(1,"R");
        boolean expected=false;
        boolean actual=ia.tradeSecurity("XKCD",0);

        Assert.assertTrue("Shouldn't be able to trade on 0 shares", expected==actual);
    }

    @Test
    public void testInvestmentAccountTradeSecurityPassed_PositiveCreatesSecurity(){
        InvestmentAccount ia = new InvestmentAccount(1,"R");
        ia.changeBalance(10000000);//Seed the account with cash
        boolean expected=true;
        boolean actual=ia.tradeSecurity("XKCD",1);

        Assert.assertTrue("Failed to transact", expected==actual);
    }

    @Test
    public void testInvestmentAccountTradeSecurityPassed_PositiveSecurityPreexisting(){
        InvestmentAccount ia = new InvestmentAccount(1,"R");
        ia.changeBalance(10000000);//Seed the account with cash
        boolean expected=true;
        boolean actual=ia.tradeSecurity("XKCD",1);

        actual=ia.tradeSecurity("XKCD", 10);//Buy more of the existing

        Assert.assertTrue("Failed to transact", expected==actual);
    }

    @Test
    public void testInvestmentAccountChangeBalanceWithTransactionBuilder(){
        InvestmentAccount ia = new InvestmentAccount(1,"R");
        ia.changeBalance("Testing change balance with transactionBuilder : ", 10000000);//Seed the account with cash
        String expected = "Testing change balance with transactionBuilder : 1.0E7";
        String actual = ia.getTransactionHistory().get(0);

        Assert.assertEquals("Strings don't match", expected, actual);
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

    @Test
    public void testInvestmentAccountTradeSecurityPassedPositive_NotEnoughCash(){
        InvestmentAccount ia = new InvestmentAccount(1,"R");
        //ia.changeBalance(10000000);//Seed the account with cash
        boolean expected=false;
        boolean actual=ia.tradeSecurity("XKCD",1);

        Assert.assertTrue("Failed to transact", expected==actual);
    }

    @Test
    public void testInvestmentAccountTradeSecurityPassedNegative_NotEnoughShares(){
        //Must create a security in order to sell it, so we repeat the
        //code from "."_Positive(), above
        InvestmentAccount ia = new InvestmentAccount(1,"R");
        ia.changeBalance(10_000_000);//Seed the account with cash
        boolean expected=false;
        boolean actual=ia.tradeSecurity("XKCD",1);//Placeholder to generate security to sell
        //We can reasonably expect that if, after running the sell, the value of the
        //account's cash position is 10_000_000 - commission*2 then things ran smoothly.
        //Another possibility for testing these methods?
        //System.out.println("$10,000,000 - "+ia.getCommissionRate()*2+" = "+
        //        (10_000_000-(ia.getCommissionRate()*2)));
        actual=ia.tradeSecurity("XKCD",-2);

        Assert.assertTrue("Failed to transact", expected==actual);
    }

    @Test
    public void testInvestmentAccountGetAccountTotalValue(){

        double expected;
        double actual;
        double passCash=1000;
        double sharesToTrade=10;
        InvestmentAccount ia = new InvestmentAccount(1,"R");
        ia.changeBalance(passCash);//Seed the account with cash
        if (ia.tradeSecurity("XKCD", sharesToTrade))
        {
            actual=ia.getAccountTotalValue();
            expected=(passCash) - ia.getCommissionRate();
        }
        else
        {
            actual=ia.getAccountTotalValue();
            expected=passCash;
        }

        Assert.assertEquals(expected, actual, allowedDeltaDollars);
    }

//ACCOUNTFACTORY TESTS

    @Test
    public void testAccountFactoryCreateInvestment(){
        InvestmentAccount ia = new InvestmentAccount(0);//Use minimal constructor to populate default
                                                                        // fields for comparison
        InvestmentAccount iaUserId= AccountFactory.createInvestment(1);
        InvestmentAccount iaUserIdAndAccountName= AccountFactory.createInvestment(2,
                                                                                  "Retirement");
        InvestmentAccount iaUserIdAccountNameAndCommissionRate= AccountFactory.createInvestment(3,
                                                                                                "Brokerage",
                                                                                                6.95);
        Assert.assertTrue("User ID failed",
                          iaUserId.getOwnerID()==1 &&
                                   ia.getAccountName().equals(iaUserId.getAccountName()) &&
                                   iaUserId.getCommissionRate()==ia.getCommissionRate());
        Assert.assertTrue("User ID & AccountName failed",
                          iaUserIdAndAccountName.getOwnerID()==2 &&
                                   "Retirement".equals(iaUserIdAndAccountName.getAccountName()) &&
                                   iaUserIdAndAccountName.getCommissionRate()==ia.getCommissionRate());
        Assert.assertTrue("User ID & AccountName & CommissionRate failed",
                          iaUserIdAccountNameAndCommissionRate.getOwnerID()==3 &&
                                   "Brokerage".equals(iaUserIdAccountNameAndCommissionRate.getAccountName()) &&
                                   iaUserIdAccountNameAndCommissionRate.getCommissionRate()==6.95);
    }

    @Test
    public void testAccountFactoryCreateSaving(){
        SavingAccount sa = new SavingAccount(0);//Use minimal constructor to populate default
                                                                // fields for comparison
        SavingAccount saUserId= AccountFactory.createSaving(1);
        SavingAccount saUserIdAndAccountName= AccountFactory.createSaving(2,
                "For Boat");
        SavingAccount saUserIdAccountNameAndInterestRate= AccountFactory.createSaving(3,
                "For Beer",
                0.05);
        Assert.assertTrue("User ID failed",
                saUserId.getOwnerID()==1 &&
                        sa.getAccountName().equals(saUserId.getAccountName()) &&
                        saUserId.getInterestRate()==sa.getInterestRate());
        Assert.assertTrue("User ID & AccountName failed",
                saUserIdAndAccountName.getOwnerID()==2 &&
                        "For Boat".equals(saUserIdAndAccountName.getAccountName()) &&
                        saUserIdAndAccountName.getInterestRate()==sa.getInterestRate());
        Assert.assertTrue("User ID & AccountName & InterestRate failed",
                saUserIdAccountNameAndInterestRate.getOwnerID()==3 &&
                        "For Beer".equals(saUserIdAccountNameAndInterestRate.getAccountName()) &&
                        saUserIdAccountNameAndInterestRate.getInterestRate()==0.05);
    }

//SAVINGACCOUNT TESTS

    @Test
    public void testSavingAccountConstructors(){
        SavingAccount sa = new SavingAccount(0);//Load defaults for comparisons

        Assert.assertTrue(sa.getOwnerID()==0 &&
                                    "Saving Account".equals(sa.getAccountName()) &&
                                    sa.getInterestRate()==0.01);
    }

//CHECKINGACCOUNT TESTS

}
