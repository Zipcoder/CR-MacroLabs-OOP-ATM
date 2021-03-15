import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class InvestmentTest {
    @Test
    public void testConstructor() {
        // : Given
        Integer expectedAccountNumber = 777777777;
        Double expectedBalance = 1200.0;
        Investment investmentZero=new Investment(expectedAccountNumber,expectedBalance);

        // : When

        Integer actualAccountNumber=investmentZero.getAccountNumber();
        double actualBalance=investmentZero.getBalance();

         // : Then
        Assert.assertEquals(expectedAccountNumber,actualAccountNumber);
        Assert.assertEquals(expectedBalance,actualBalance,0.00001);
    }

    @Test
    public void testDepositToInvestment() {
        // : Given
        Integer investementAccountNumber = 888888888;
        double investmentAccountBalance = 9000.0;
        Investment investmentZero=new Investment(investementAccountNumber,investmentAccountBalance);

        // : When
        investmentZero.deposit(1000.0);
        double expectedInvestmentAccountBalance=10000.0;
        double actualInvestmentAccountBalance=investmentZero.getBalance();
        System.out.println(actualInvestmentAccountBalance);

        // : Then
        Assert.assertEquals(expectedInvestmentAccountBalance,actualInvestmentAccountBalance, 0.000001);
    }

    @Test
    public void testWithdrawFromInvestment() {
        // : Given
        Integer investementAccountNumber = 888888888;
        double investmentAccountBalance = 9000.0;
        Investment investmentZero=new Investment(investementAccountNumber,investmentAccountBalance);

        // : When
        investmentZero.withdraw(2000.0);
        double expectedInvestmentAccountBalance=7000.0;
        double actualInvestmentAccountBalance=investmentZero.getBalance();
        System.out.println(actualInvestmentAccountBalance);

        // : Then
        Assert.assertEquals(expectedInvestmentAccountBalance,actualInvestmentAccountBalance, 0.00001);
    }

    @Test
    public void testTransferToSavings() {
        // : Given
        Integer investementAccountNumber = 777777777;
        double investmentAccountBalance = 12000.0;
        Integer savingsAccountNumber =11111111;
        double savingsAccountBalance=7000.0;
        Investment investmentZero=new Investment(investementAccountNumber,investmentAccountBalance);
        Savings savingsZero=new Savings(savingsAccountNumber,savingsAccountBalance);

        // : When
        double transferAmountToSaving=3000.0;
        double expectedInvestmentAccountBalance=9000.0;
        double expectedSavingsAccountBalance=10000.0;
        investmentZero.transferToSavings(savingsZero,transferAmountToSaving);
        double actualInvestmentAccountBalance=investmentZero.getBalance();
        double actualSavigsAccountBalance=savingsZero.getBalance();

        System.out.println(investmentZero.getBalance());
        System.out.println(savingsZero.getBalance());

        // : Then
        Assert.assertEquals(expectedInvestmentAccountBalance,actualInvestmentAccountBalance,0.0000001);
        Assert.assertEquals(expectedSavingsAccountBalance,actualSavigsAccountBalance, 0.000001);
    }

    @Test
    public void testTransferToChecking() {
        // : Given
        Integer investementAccountNumber = 888888888;
        double investmentAccountBalance = 9000.0;
        Integer checkingAccountNumber =00077777666;
        double checkingAccountBalance=5000.0;
        Investment investmentZero=new Investment(investementAccountNumber,investmentAccountBalance);
        Checking checkingZero=new Checking(checkingAccountNumber,checkingAccountBalance);
        // : When
        double transferAmountToChecking=500.0;
        double expectedInvestmentAccountBalance=8500.0;
        double expectedCheckingAccountBalance=5500.0;
        investmentZero.transferToChecking(checkingZero,transferAmountToChecking);
        double actualInvestmentAccountBalance=investmentZero.getBalance();
        double actualCheckingAccountBalance=checkingZero.getBalance();

        System.out.println(investmentZero.getBalance());
        System.out.println(checkingZero.getBalance());


        // : Then
        Assert.assertEquals(expectedInvestmentAccountBalance,actualInvestmentAccountBalance,0.0000001);
        Assert.assertEquals(expectedCheckingAccountBalance,actualCheckingAccountBalance, 0.000001);
    }
}