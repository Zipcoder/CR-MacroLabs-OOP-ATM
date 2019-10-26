import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ATMTest {

    private ATM atm;

    @Before
    public void setUp() throws Exception {
        ATM atm = new ATM ("testuserDB.csv", "testaccountDB.csv", "testtransactionDB.csv");
    }

    @After
    public void tearDown() throws Exception {
        atm.getUserDB().clear();
        atm.getAccountDB().clear();
        atm.getTransactionDB().clear();
    }

    @Test
    public void getCurrentUser() {
    }

    @Test
    public void getUserDB() {
    }

    @Test
    public void getTransactionDB() {
    }

    @Test
    public void getAccountDB() {
    }

    @Test
    public void setCurrentUser() {
    }

    @Test
    public void authenticate() {
    }

    @Test
    public void getUserInfoByID() {
    }

    @Test
    public void getUserInfoByCardNum() {
    }

    @Test
    public void logOut() {
    }

    @Test
    public void getUser() {
    }

    @Test
    public void newUser() {
    }

    @Test
    public void getAccountInfoByUser() {
    }

    @Test
    public void loadDBs() {
    }

    @Test
    public void userMenu() {
    }

    @Test
    public void testLogOut() {
    }

    @Test
    public void saveDBs() {
    }
}