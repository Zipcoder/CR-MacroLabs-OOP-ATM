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
    public void deposit() {
    }

    @Test
    public void withdraw() {
    }

    @Test
    public void transferWithin() {
    }

    @Test
    public void transferToAnother() {
    }

    @Test
    public void getAcctHist() {
    }
}