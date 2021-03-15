import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class SavingsTest {

    @Test
    public void testSavingsAccount() {
        // : Given
        Integer savingsAccountNumber=9999999;
        double savingsAccountBalance=1300.0;
        Savings savingsZero=new Savings(savingsAccountNumber,savingsAccountBalance);
        // : When

        Integer actualSavingsAccountNumber=savingsZero.getAccountNumber();
        double actualSavingsAccountBalance=savingsZero.getBalance();

        // : Then
        Assert.assertEquals(savingsAccountNumber,actualSavingsAccountNumber, 0.00001);
        Assert.assertEquals(savingsAccountBalance,actualSavingsAccountBalance, 0.00001);
    }

    @Test
    public void testDepositToSavings() {
        // : Given
        Integer savingsAccountNumber = 888888888;
        double savingsAccountBalance = 7000.0;
        Savings savingsZero=new Savings(savingsAccountNumber,savingsAccountBalance);

        // : When
        savingsZero.deposit(100.0);
        double expectedSavingsAccountBalance=7100.0;
        double actualSavingsAccountBalance=savingsZero.getBalance();
        System.out.println(actualSavingsAccountBalance);

        // : Then
        Assert.assertEquals(expectedSavingsAccountBalance,actualSavingsAccountBalance, 0.000001);
    }

    @Test
    public void testWithdrawFromSavings() {
        // : Given
        Integer savingsAccountNumber = 888888888;
        double savingsAccountBalance = 9000.0;
        Savings savingsZero=new Savings(savingsAccountNumber,savingsAccountBalance);

        // : When
        savingsZero.withdraw(6000.0);
        double expectedSavingsAccountBalance=3000.0;
        double actualSavingsAccountBalance=savingsZero.getBalance();
        System.out.println(actualSavingsAccountBalance);

        // : Then
        Assert.assertEquals(expectedSavingsAccountBalance, actualSavingsAccountBalance,0.00001);
    }

    @Test
    public void testTransferToCheckingAccount() {
        // : Given
        Integer savingsAccountNumber = 343234321;
        double savingsAccountBalance = 0.0;
        Integer checkingAccountNumber =89898998;
        double checkingAccountBalance=8000.0;
        Checking checkingZero=new Checking(checkingAccountNumber,checkingAccountBalance);
        Savings savingsZero=new Savings(savingsAccountNumber,savingsAccountBalance);

        // : When
        double transferAmountToChecking=3000.0;
        double expectedCheckingAccountBalance=8000.0;
        double expectedSavingsAccountBalance=0.0;
        savingsZero.transferToChecking(checkingZero,transferAmountToChecking);
        double actualCheckingAccountBalance=checkingZero.getBalance();
        double actualSavigsAccountBalance=savingsZero.getBalance();

        System.out.println(checkingZero.getBalance());
        System.out.println(savingsZero.getBalance());

        // : Then
        Assert.assertEquals(expectedCheckingAccountBalance,actualCheckingAccountBalance,0.0000001);
        Assert.assertEquals(expectedSavingsAccountBalance,actualSavigsAccountBalance, 0.000001);

    }

    @Test
    public void testTransferToInvestment() {
        // : Given
        Integer savingsAccountNumber = 7777777;
        double savingsAccountBalance = 6000.0;
        Integer investementAccountNumber = 5555555;
        double investmentAccountBalance = 1000.0;
        Savings savingsZero=new Savings(savingsAccountNumber,savingsAccountBalance);
        Investment investmentZero=new Investment(investementAccountNumber,investmentAccountBalance);

        // : When
        double transferAmountToInvestment=500.0;
        double expectedInvestmentAccountBalance=1500.0;
        double expectedSavingsAccountBalance=5500.0;
        savingsZero.transferToInvestment(investmentZero,transferAmountToInvestment);
        double actualInvestmentAccountBalance=investmentZero.getBalance();
        double actualSavingsAccountBalance=savingsZero.getBalance();

        System.out.println(investmentZero.getBalance());
        System.out.println(savingsZero.getBalance());


        // : Then
        Assert.assertEquals(expectedInvestmentAccountBalance,actualInvestmentAccountBalance,0.0000001);
        Assert.assertEquals(expectedSavingsAccountBalance,actualSavingsAccountBalance, 0.000001);
    }
}