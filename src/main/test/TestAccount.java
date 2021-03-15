import org.junit.Assert;
import org.junit.jupiter.api.Test;

/*
Test checklist:
Test both constructors
Check balance
Test withdrawal (Both with enough and not enough money in account, withdrawing negative amount...)
Test deposit (make sure positive)

*/

public class TestAccount {


    @Test
    public void constructorTest1() {
        Account a = new Account(0.0);
        Assert.assertEquals(0.0, a.getBalance(), 0.0001);
    }

    @Test
    public void constructorTest2() {
        Account a = new Account(10.0);
        Assert.assertEquals(10.0, a.getBalance(), 0.0001);
    }

    @Test
    public void constructorTest3() {
        Account a = new Account(-5.0, "Investment");
        Assert.assertEquals(0.0, a.getBalance(), 0.0001);
    }

    @Test
    public void constructorTest4() {
        String expected="Investment";
        Account a = new Account(0.0, "Investment");
        Assert.assertEquals(expected, a.getAccountType());
    }



    @Test
    public void closeAccountTest1() {
        Account a = new Account(0.0);
        Assert.assertEquals(true, a.closeAccount());
    }

    @Test
    public void closeAccountTest2() {
        Account a = new Account(10.0);
        Assert.assertEquals(false, a.closeAccount());
    }

    @Test
    public void depositTest() {
        Account a = new Account(0.0);
        a.deposit(100.0);
        Assert.assertEquals(100.0, a.getBalance(), 0.0001);
    }

    @Test
    public void depositTest2() {
        Account a = new Account(10.0);
        a.deposit(100.0);
        Assert.assertEquals(110.0, a.getBalance(), 0.0001);
    }

    @Test
    public void depositTest3() {
        Account a = new Account(10.0);
        a.deposit(-4.0);
        Assert.assertEquals(10.0, a.getBalance(), 0.0001);
    }


    @Test
    public void withdrawTest1() {
        Account a = new Account(200.0);
        Double actual = a.withdraw(100.0);
        Assert.assertEquals(100.0, actual, 0.0001);
    }

    @Test
    public void withdrawTest2() {
        Account a = new Account(0.0);
        Double actual = a.withdraw(1.0);
        Assert.assertEquals(0.0, actual, 0.0001);
    }

    @Test
    public void withdrawTest3() {
        Account a = new Account(0.0);
        Double actual = a.withdraw(-100.0);
        Assert.assertEquals(0.0, actual, 0.0001);
    }

    @Test
    public void transferTest() {
        Account a = new Account(10.0);
        Account b = new Account(0.0);
        a.transfer(b, 10.0);
        Assert.assertEquals(0.0, a.getBalance(), 0.0001);
        Assert.assertEquals(10.0, b.getBalance(), 0.0001);
    }

    @Test
    public void transferTest2() {
        Account a = new Account(10.0);
        Account b = new Account(0.0);
        a.transfer(b, 100.0); // nothing should happen
        Assert.assertEquals(10.0, a.getBalance(), 0.0001);
        Assert.assertEquals(0.0, b.getBalance(), 0.0001);
    }

    @Test
    public void historyTest() {
        Account a = new Account(10.0);
        a.deposit(33.33);
        a.showTransactionHistory();
    }

    @Test
    public void historyTest2() {
        Account a = new Account(57.66);
        a.withdraw(33.32);
        a.showTransactionHistory();
        System.out.println(a.getBalance());
    }

    @Test
    public void historyTest3() {
        Account a = new Account(57.66);
        a.withdraw(33.32);
        a.deposit(2.0);
        a.deposit(8.9);
        a.withdraw(100.0);
        a.deposit(1.1);
        a.withdraw(5.6);
        a.showTransactionHistory();
        System.out.println(a.getBalance());
    }

}
