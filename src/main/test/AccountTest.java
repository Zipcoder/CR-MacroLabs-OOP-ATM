import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class AccountTest {

    @Test
    public void depositTest() {

        //:Given
        BigDecimal balance = new BigDecimal(200);
        BigDecimal depositAmount = new BigDecimal(100);
        Account checkingsAccount = new CheckingsAccount();
        checkingsAccount.setBalance(balance);
        BigDecimal expectedBalance = new BigDecimal(300);

        //:When
        checkingsAccount.deposit(depositAmount);
        BigDecimal actualBalance = checkingsAccount.getBalance();

        //:Then
        Assert.assertEquals("Checking balance", expectedBalance, actualBalance);

    }

    @Test
    public void withdrawalTest() {
        //Given
        BigDecimal balance = new BigDecimal(200);
        BigDecimal withdrawalAmount = new BigDecimal(50);
        Account checkingsAccount = new CheckingsAccount();
        checkingsAccount.setBalance(balance);
        BigDecimal expectedBalance = new BigDecimal(150);

        //When
        checkingsAccount.withdrawal(withdrawalAmount);
        BigDecimal actualBalance = checkingsAccount.getBalance();

        //Then
        Assert.assertEquals("Checking balance", expectedBalance, actualBalance);

    }

    @Test
    public void transferTest() {

        //Given
        BigDecimal balance = new BigDecimal(500);
        BigDecimal transferAmount = new BigDecimal(20);
        Account account1 = new Account(balance);
        Account account2 = new Account(balance);

        account1.transfer(account2, transferAmount);

        BigDecimal expectedaccount1Balance = new BigDecimal(480);
        BigDecimal expectedaccount2Balance = new BigDecimal(520);

        //When
        BigDecimal actualaccount1Balance = account1.getBalance();
        BigDecimal account2Balance = account2.getBalance();

        //Then
        Assert.assertEquals("Account One Balance should equal 480", expectedaccount1Balance, actualaccount1Balance);
        Assert.assertEquals("Account Two Balance should equal 520", expectedaccount2Balance, account2Balance);


    }

    @Test
    public void getBalanceTest() {

        //Given
        BigDecimal balance = new BigDecimal(400);
        Account accountOne = new Account(balance);

       // System.out.println(accountOne.getBalance());

        BigDecimal expectedBalance = new BigDecimal(400);


        //When
        BigDecimal actualBalance = accountOne.getBalance();

        //Then
        Assert.assertEquals("Balance one", expectedBalance, actualBalance);
}




}