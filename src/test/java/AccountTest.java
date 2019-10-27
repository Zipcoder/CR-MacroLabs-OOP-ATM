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
    public void risk_test() {
        // Given
        Investment account = new Investment(8000.0, 3,3, .09);
        Double expected = .09;

        //When
        account.calcReturn();

        // Then
        Double actual = account.getBalance();
        assertEquals(expected, actual);
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

        account.calcInterestReturned();

        // Then
        Double actual = account.getBalance();
        assertEquals(expected, actual);
    }
}
