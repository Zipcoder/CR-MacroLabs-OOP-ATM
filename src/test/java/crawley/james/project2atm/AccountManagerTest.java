package crawley.james.project2atm;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * Created by jamescrawley on 9/16/16.
 */


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountManagerTest {

    AccountManager accountManager = new AccountManager();

    @Test
    public void addAccountTest () {

        accountManager.addAccount(Account.AccountType.SAVINGS, 100, 12, 1);
        assertNotNull(accountManager.getAccount(1, 12));

    }

    @Test
    public  void deleteAccountTest () {

        accountManager.addAccount(Account.AccountType.SAVINGS, 0, 12, 1);
        accountManager.deleteAccount(1, 12);
        assertNull(accountManager.getAccount(1, 12));

    }

}
