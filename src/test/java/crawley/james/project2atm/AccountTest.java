package crawley.james.project2atm;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class AccountTest {


    Account account = new Account(Account.AccountType.SAVINGS, 100, 12);

    @Test
    public void balanceTest () {


        assertEquals("The balance should be $100", 100, account.getBalance(), 0);
    }

    @Test
    public void accountTypeTest () {

        assertEquals("The type should be SAVINGS", Account.AccountType.SAVINGS, account.getAccountType());
    }

    @Test
    public void customerIDTest () {

        assertEquals("The the Customer ID should be 12", 12, account.getCustomerID(), 0);

    }

    @Test
    public void accountNumberTest () {

        assertEquals("The account number should be 1", 1, account.getAccountNumber());

    }

    @Test
    public void interestRateTest () {

        assertEquals("The interest rate should be", 0.05, account.getInterestRate(), 0);

    }

}
