import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void getBalance() {
        // Given
        Account account = new Checking(0.0, 3,3);
        Double expected = 0.0;


        // Then
        Double actual = account.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    public void deposit_test() {
        // Given
        Account account = new Checking(0.0, 3,3);
        Double expected = 40.0;

        //When
        account.deposit(40.0);

        // Then
        Double actual = account.getBalance();
        assertEquals(expected, actual);

    }

    @Test
    public void withdraw_test() {
        // Given
        Account account = new Checking(80.0, 3,3);
        Double expected = 40.0;

        //When
        account.withdraw(40.0);

        // Then
        Double actual = account.getBalance();
        assertEquals(expected, actual);
    }
    @Test
    public void withdraw_Overdraft_test() {
        // Given
        Account account = new Checking(0.0, 3,3);
        Account account2 = new Checking(40.0, 2,2);
        Double expected = 0.0;

        //When
        if (account.getBalance() > 40.0){
            account.withdraw(40.0);
            account2.deposit(40.0);
        }else {
            System.out.println("Not enough funds");
        }
        // Then
        Double actual = account2.getBalance();
        assertEquals(account2.getBalance(), account.getBalance());
    }
    @Test
    public void risk_test() {
//        Investment account = new Investment(8000.0, 3,3, .09);
//
//        Double actual;
//
//        for (int i = 0; i < 1000; i++) {
//            actual = account.calcReturn();
//            Double minExpected = account.getBalance() - .8 * account.getRisk() * account.getBalance();
//            assertTrue(minExpected <= actual);
//
//            actual = account.calcReturn();
//            Double maxExpected = account.getBalance() + 1.2 * account.getRisk() * account.getBalance();
//            assertTrue(maxExpected >= actual);
//        }
    }



    @Test
    public void getAcctHist() {
    }

    @Test
    public void getOwnerID() {
        // Given
        Account account = new Checking(0.0, 3,3);
        Integer expected = 3;


        // Then
        Integer actual = account.getOwnerID();
        assertEquals(expected, actual);
    }

    @Test
    public void getAcctNum() {
        // Given
        Account account = new Checking(0.0, 3,3);
        Integer expected = 3;


        // Then
        Integer actual = account.getAcctNum();
        assertEquals(expected, actual);

    }

    @Test
    public void calcInterestReturned() {
        // Given
        Savings account = new Savings(80000.0, 3,3, 0.002);
        Double expected = 80160.0;

//        account.calcInterestReturned();

        // Then
        Double actual = account.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    public void setRisk() {
        // Given
        Investment account = new Investment(80000.0, 3,3, 0.09);
        Double expected = 0.9;

        account.setRisk(0.9);

        // Then
        Double actual = account.getRisk();
        assertEquals(expected, actual);
    }
}
