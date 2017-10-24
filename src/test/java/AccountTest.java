import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    @Test
    public void depositTest1() {
        //: Given
        Account testAccount = new Account();
        double expected = 50.25;

        //: When
        testAccount.deposit(50.25);
        double actual = testAccount.getBalance();

        //: Then
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void depositTest2() {
        //: Given
        Account testAccount = new Account();
        String expected = "Deposited $50.25, Account balance $50.25";

        //: When
        testAccount.deposit(50.25);
        String actual = testAccount.getTransactionHistory().get(testAccount.getTransactionHistory().size()-1);

        //: Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void depositTest3() {
        //: Given
        Account testAccount = new Account();
        double expected = 0;

        //: When
        testAccount.deposit(0);
        double actual = testAccount.getBalance();

        //: Then
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void depositTest4() {
        //: Given
        Account testAccount = new Account();
        String expected = "Deposited $8.00, Account balance $8.00";

        //: When
        testAccount.deposit(8);
        String actual = testAccount.getTransactionHistory().get(testAccount.getTransactionHistory().size()-1);

        //: Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void depositTest5() {
        //: Given
        Account testAccount = new Account();
        boolean expected = false;

        //: When
        boolean actual = testAccount.deposit(-10);

        //: Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void withdrawTest1() {
        //: Given
        Account testAccount = new Account();
        double expected = 145;

        //: When
        testAccount.deposit(200);
        testAccount.withdraw(55);
        double actual = testAccount.getBalance();

        //: Then
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void withdrawTest2() {
        //: Given
        Account testAccount = new Account();
        String expected = "Withdrew $99.99, Account balance $0.01";

        //: When
        testAccount.deposit(100);
        testAccount.withdraw(99.99);
        String actual = testAccount.getTransactionHistory().get(testAccount.getTransactionHistory().size()-1);

        //: Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void withdrawTest3() {
        //: Given
        Account testAccount = new Account();
        boolean expected = false;

        //: When
        testAccount.deposit(100);
        boolean actual = testAccount.withdraw(110);

        //: Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void withdrawTest4() {
        //: Given
        Account testAccount = new Account();
        boolean expected = true;

        //: When
        testAccount.deposit(100);
        boolean actual = testAccount.withdraw(100);

        //: Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void transferToTest1() {
        //: Given
        Account testAccount1 = new Account();
        Account testAccount2 = new Account();
        double expected = 100;

        //: When
        testAccount1.deposit(200);
        testAccount2.deposit(400);
        testAccount1.transferTo(testAccount2, 100);
        double actual = testAccount1.getBalance();

        //: Then
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void transferToTest2() {
        //: Given
        Account testAccount1 = new Account();
        Account testAccount2 = new Account();
        String expected = "Deposited $8.00, Account balance $408.00";

        //: When
        testAccount1.deposit(200);
        testAccount2.deposit(400);
        testAccount1.transferTo(testAccount2, 8);
        String actual = testAccount2.getTransactionHistory().get(testAccount2.getTransactionHistory().size()-1);

        //: Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void formatTransactionHistoryTest() {
        //: Given
        Account testAccount = new Account();
        String expected = "Deposited $100.00, Account balance $100.00\nWithdrew $50.00, Account balance $50.00\n" +
                "Deposited $300.33, Account balance $350.33\nWithdrew $106.66, Account balance $243.67\n";

        //: When
        testAccount.deposit(100);
        testAccount.withdraw(50);
        testAccount.deposit(300.33);
        testAccount.withdraw(106.66);
        String actual = testAccount.formatTransactionHistory();

        //: Then
        Assert.assertEquals(expected,actual);
    }
}
