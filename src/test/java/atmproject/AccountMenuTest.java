package atmproject;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class AccountMenuTest {
    @Test
    public void selectAccount() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        AccountMenu accountmenu = new AccountMenu();
        ATM atm = new ATM();
        UserLogin userLogin = new UserLogin();
        User user = new User("mich", "kin", 1000);

        userLogin.initialAccount(user);

        atm.setCurrentUser(user);


        accountmenu.selectAccount(user);
        Double actual = accountmenu.returnedAccount.getBalance();
        assertTrue(actual == 0.0);
    }

    @Test
    public void getUserSelectedAccount() {
    }

    @Test
    public void getUsersInput() {
    }

    @Test
    public void printAndStoreAccounts() {
    }
}