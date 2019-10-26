import junitparams.JUnitParamsRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class ATMTest {

    private  ATM atm;

    @Before
    public void setUp() throws Exception {
        atm = new ATM ("testuserDB.csv", "testaccountDB.csv", "testtransactionDB.csv");
    }

    @After
    public void tearDown() throws Exception {
        atm.getUserDB().clear();
        atm.getAccountDB().clear();
        atm.getTransactionDB().clear();
    }

    @Test
    public void getUserDB() {

        DB foundDB = atm.getUserDB();
        String fileName = foundDB.getFileName();
        Assert.assertEquals("testuserDB.csv",fileName);
    }

    @Test
    public void getTransactionDB() {

        DB foundDB = atm.getTransactionDB();
        String fileName = foundDB.getFileName();
        Assert.assertEquals("testtransactionDB.csv",fileName);
    }

    @Test
    public void getAccountDB() {

        DB foundDB = atm.getAccountDB();
        String fileName = foundDB.getFileName();
        Assert.assertEquals("testaccountDB.csv",fileName);
    }

    @Test
    public void getUserCount() {

        DB userDB = atm.getUserDB();
        userDB.clear();
        Assert.assertEquals((int) 0, (int) userDB.length());
        User user1 = new User("Jim","Brown","goolybib", 12, 12343);
        userDB.addRow(user1.toStringArray());
        Assert.assertEquals((int) 1, (int) userDB.length());
        User user2 = new User("Ji123m","Bro23wn","gool321ybib", 122, 1234313);
        userDB.addRow(user2.toStringArray());
        Assert.assertEquals((int) 2, (int) userDB.length());
    }

    @Test
    public void setCurrentUser() {

        User foundUser = atm.getCurrentUser();
        Assert.assertEquals(foundUser, null);

        User user = new User("Jim","Brown","goolybib", 12, 12343);
        atm.setCurrentUser(user);

        foundUser = atm.getCurrentUser();
        Assert.assertEquals(foundUser, user);
    }

    @Test
    public void authenticate() {
    }

    @Test
    public void getUserInfoByID() {
        DB userDB = atm.getUserDB();
        userDB.clear();

        User user1 = new User("Jim","Brown","goolybib", 12, 12343);
        userDB.addRow(user1.toStringArray());
        User user2 = new User("Ji123m","Bro23wn","gool321ybib", 122, 1234313);
        userDB.addRow(user2.toStringArray());
        User user3 = new User("Jane","Himne","gasdsdool321ybib", 32, 313);
        userDB.addRow(user3.toStringArray());

        String[] actual = atm.getUserInfoByID(122);
        String[] expected = user2.toStringArray();

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void getUserInfoByCardNum() {
    }

    @Test
    public void logOut() {
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