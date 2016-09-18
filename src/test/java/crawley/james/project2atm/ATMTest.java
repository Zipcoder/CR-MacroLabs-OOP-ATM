package crawley.james.project2atm;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * Created by jamescrawley on 9/16/16.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ATMTest {

    @Test
    public void createAccountTest () {
        ATM atm = new ATM();
        atm.createAccount(Account.AccountType.SAVINGS, 1, 1, 100);

        assertNotNull("An account should be created.", atm.getAccountManager().getAccount(1, 1));
    }

    @Test
    public void createCustomerTest () {
        ATM atm = new ATM();
        atm.createCustomer("William Williams", 1234);

        assertNotNull("A customer should have been created.", atm.getCustomerManager().getCustomer(1));
    }

    @Test
    public void closeAccountWithNoBalanceTest () {
        ATM atm = new ATM();
        atm.createAccount(Account.AccountType.SAVINGS, 1, 1, 0);
        atm.closeAccount(1, 1);

        assertNull("The account should have been closed.", atm.getAccountManager().getAccount(1, 1));

    }

    @Test
    public void closeAccountWithBalanceTest () {
        ATM atm = new ATM();
        atm.createAccount(Account.AccountType.SAVINGS, 1, 1, 100);
        atm.closeAccount(1, 1);

        assertNotNull("The account should not have been closed.", atm.getAccountManager().getAccount(1, 1));

    }

    @Test
    public void verifyCorrectLoginTest () {

        ATM atm = new ATM();
        atm.createCustomer("William Williams", 1234);

        assert(atm.verifyLoginInfo(1, 1234));

    }

    @Test
    public void verifyIncorrectLoginTest () {

        ATM atm = new ATM();
        atm.createCustomer("William Williams", 1234);

        assert(!atm.verifyLoginInfo(1, 1235));

    }

    @Test
    public void depositTest () {

        ATM atm = new ATM();
        atm.createAccount(Account.AccountType.SAVINGS, 1, 1, 100);
        atm.setCurrentUser(1);
        atm.deposit(1, 50);

        assertEquals("The balance should be $150", 150, atm.getAccountManager().getAccount(1, 1).getBalance(), 0);

    }

    @Test
    public void withdrawalTest () {

        ATM atm = new ATM();
        atm.createAccount(Account.AccountType.SAVINGS, 1, 1, 100);
        atm.setCurrentUser(1);
        atm.withdrawals(1, 50);

        assertEquals("The balance should be $50", 50, atm.getAccountManager().getAccount(1, 1).getBalance(), 0);

    }

    @Test
    public void transferTest () {

        ATM atm = new ATM();
        atm.createAccount(Account.AccountType.SAVINGS, 1, 1, 100);
        atm.createAccount(Account.AccountType.SAVINGS, 1, 2, 100);
        atm.setCurrentUser(1);
        atm.transfer(1, 2, 50);

        assertEquals("The balance should be $50", 50, atm.getAccountManager().getAccount(1, 1).getBalance(), 0);

    }

    @Test
    public void transactionTest () {

        ATM atm = new ATM();
        atm.createCustomer("William Williams", 1234);
        atm.createAccount(Account.AccountType.SAVINGS, 1, 1, 100);
        atm.setCurrentUser(1);
        atm.withdrawals(1, 50);
        atm.deposit(1, 20);

       String expected = "Customer: 1, Account: 1, DEPOSIT: $20.0\n" +
                "Customer: 1, Account: 1, WITHDRAWAL: $50.0\n";

        assertEquals("Customer 1 should have recent transactions on Account 1 " +
                "for depositing $20 and withdrawaling $50 in order of most recent to " +
                "least recent.", expected, atm.getTransactionManager().getTransactions(1));

    }
}
