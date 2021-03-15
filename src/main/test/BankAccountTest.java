import org.junit.Test;
import org.testng.Assert;

// Test the expected Account class from ATM.
public class BankAccountTest {



    @Test
    public void constructorInitialBalanceTest1() { // tests account balance 0.0 upon creation of BankAccount
        //Arrange
        String givenAccountType = "Checking";
        Double givenCurrentBalance = 0.0;
        //Act
        BankAccount testBankAccount = new BankAccount(givenAccountType);
        Double returnedBalance = testBankAccount.getBalance();
        //Assert
        Assert.assertEquals(givenCurrentBalance, returnedBalance);
    }

    @Test
    public void constructorAcctTypeArgTest2() { // tests creation of BankAccount sets account type
        //Arrange
        String givenAccountType = "Checking";
        //Act
        BankAccount testBankAccount = new BankAccount(givenAccountType);
        String returnedAccountType = testBankAccount.accountType;
        //Assert
        Assert.assertEquals(givenAccountType, returnedAccountType);

    }

    @Test
    public void setTypeTest() { // tests method to reset account type
        //Arrange
        String givenAccountType = "Checking";
        Double givenCurrentBalance = 0.0;
        //Act
        BankAccount testBankAccount = new BankAccount(givenAccountType);
        testBankAccount.setType("Savings");
        String returnedAccountType = testBankAccount.getAccountType();
        //Assert
        Assert.assertEquals(givenAccountType, returnedAccountType);
    }

    @Test
    public void getAccountTypeTest() { // tests method for return account type
        //Arrange
        String givenAccountType = "Checking";
        //Act
        BankAccount testBankAccount = new BankAccount(givenAccountType);
        String returnedAccountType = testBankAccount.getAccountType();
        //Assert
        Assert.assertEquals(givenAccountType, returnedAccountType);
    }

    @Test
    public void setBalanceTest() { // tests method to reset account balance
        //Arrange
        String givenAccountType = "Investment";
        Double givenCurrentBalance = 0.0;
        Double expectedAccountBal = 100.0;
        //Act
        BankAccount testBankAccount = new BankAccount(givenAccountType);
        testBankAccount.setBalance(100.0);
        Double returnedAccountBal = testBankAccount.getBalance();
        //Assert
        Assert.assertEquals(expectedAccountBal, returnedAccountBal);
    }

    @Test
    public void getBalanceTest() { // tests method to reset account balance
        //Arrange
        String givenAccountType = "Investment";
        Double givenCurrentBalance = 0.0;
        Double expectedAccountBal = 100.0;
        //Act
        BankAccount testBankAccount = new BankAccount(givenAccountType);
        testBankAccount.setBalance(100.0);
        Double returnedAccountBal = testBankAccount.getBalance();
        //Assert
        Assert.assertEquals(expectedAccountBal, returnedAccountBal);
    }

    @Test
    public void depositTest() {
    }

    @Test
    public void withdrawTest() {
    }



    @Test
    public void printTxnTest() {
    }

    @Test
    public void dateTimeTest() {
        //Arrange
        String givenAccountType = "Checking";
        //Act
        BankAccount testBankAccount1 = new BankAccount(givenAccountType);
        BankAccount testBankAccount2 = new BankAccount(givenAccountType);
        System.out.println(testBankAccount1.dateTime());
        System.out.println(testBankAccount2.dateTime());
        String expectedDateTime = testBankAccount1.dateTime();
        String returnedDateTime = testBankAccount2.dateTime();
        //Assert
        Assert.assertEquals(expectedDateTime, returnedDateTime);
}


//    @Test
//    public void testA0() {
//        Account a = new Account(0.0);
//        assertEquals(0.0, a.balance(), 0.0001);
//    }
//
//    @Test
//    public void testA00() {
//        Account a = new Account(10.0);
//        assertEquals(10.0, a.balance(), 0.0001);
//    }
//
//    @Test
//    public void testA01() {
//        Account a = new Account(0.0);
//        assertEquals(true, a.closeAccount());
//    }
//
//    @Test
//    public void testA02() {
//        Account a = new Account(10.0);
//        assertEquals(false, a.closeAccount());
//    }
//
//    @Test
//    public void testA1() {
//        Account a = new Account(0.0);
//        a.deposit(100.0);
//        assertEquals(100.0, a.balance(), 0.0001);
//    }
//
//    @Test
//    public void testA2() {
//        Account a = new Account(10.0);
//        a.deposit(100.0);
//        assertEquals(110.0, a.balance(), 0.0001);
//    }
//
//    @Test
//    public void testA3() {
//        Account a = new Account(200.0);
//        Double actual = a.withdraw(100.0);
//        assertEquals(100.0, actual, 0.0001);
//    }
//
//    @Test
//    public void testA4() {
//        Account a = new Account(0.0);
//        Double actual = a.withdraw(1.0);
//        assertEquals(0.0, actual, 0.0001);
//    }
//
//    @Test
//    public void testA5() {
//        Account a = new Account(10.0);
//        Account b = new Account(0.0);
//        a.transfer(b, 10.0);
//        assertEquals(0.0, a.balance(), 0.0001);
//        assertEquals(10.0, b.balance(), 0.0001);
//    }
//
//    @Test
//    public void testA6() {
//        Account a = new Account(10.0);
//        Account b = new Account(0.0);
//        a.transfer(b, 100.0); // nothing should happen
//        assertEquals(10.0, a.balance(), 0.0001);
//        assertEquals(0.0, b.balance(), 0.0001);
//    }


}
