import org.testng.annotations.Test;
import org.testng.Assert;

// Test the expected Account class from ATM.
public class BankAccountTest {

    @Test
    public void constructorCActTypeTest1() { // tests creation of checking account - type field
        // Arrange
        BankAccount testAccount = new BankAccount("Checking");
        String givenCAcctType = "Checking";
        String returnedCAcctType = testAccount.getAccountType();
        Assert.assertEquals(givenCAcctType, returnedCAcctType);
    }

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
        Assert.assertEquals("Savings", returnedAccountType);
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
        //Arrange
        String givenAccountType = "Investment";
        Double expectedAccountBal = 200.0;
        //Act
        BankAccount testBankAccount = new BankAccount(givenAccountType);
        testBankAccount.setBalance(100.00);
        testBankAccount.deposit(100.0);
        Double returnedAccountBalance = testBankAccount.getBalance();
        //Assert
        Assert.assertEquals(expectedAccountBal, returnedAccountBalance);
    }

    @Test
    public void withdrawTest() {
        //Arrange
        String givenAccountType = "Investment";
        Double expectedAccountBal = 0.0;
        //Act
        BankAccount testBankAccount = new BankAccount(givenAccountType);
        testBankAccount.setBalance(100.00);
        testBankAccount.withdraw(100.0);
        Double returnedAccountBalance = testBankAccount.getBalance();
        //Assert
        Assert.assertEquals(expectedAccountBal, returnedAccountBalance);
    }

    @Test
    public void dateTimeTest() {  // tests return of date and time method
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

}
