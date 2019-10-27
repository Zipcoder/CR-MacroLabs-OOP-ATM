import junitparams.JUnitParamsRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Date;
import java.util.Arrays;

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
    public void getUserInfoByCardNumTest() {
        DB userDB = atm.getUserDB();
        userDB.clear();

        User user1 = new User("Jim","Brown","goolybib", 12, 12343);
        userDB.addRow(user1.toStringArray());
        User user2 = new User("Ji123m","Bro23wn","gool321ybib", 122, 1234313);
        userDB.addRow(user2.toStringArray());
        User user3 = new User("Jane","Himne","gasdsdool321ybib", 32, 313);
        userDB.addRow(user3.toStringArray());

        String[] actual = atm.getUserInfoByCardNum(1234313);
        String[] expected = user2.toStringArray();

        Assert.assertEquals(actual,expected);

        actual = atm.getUserInfoByCardNum(313);
        expected = user3.toStringArray();

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void getUserRowByID() {
        DB userDB = atm.getUserDB();
        userDB.clear();

        User user1 = new User("Jim","Brown","goolybib", 12, 12343);
        userDB.addRow(user1.toStringArray());
        User user2 = new User("Ji123m","Bro23wn","gool321ybib", 122, 1234313);
        userDB.addRow(user2.toStringArray());
        User user3 = new User("Jane","Himne","gasdsdool321ybib", 32, 313);
        userDB.addRow(user3.toStringArray());

        int actual = atm.getUserRowByID(122);
        int expected = 1;

        Assert.assertEquals(actual,expected);

        actual = atm.getUserRowByID(12);
        expected = 0;

        Assert.assertEquals(actual,expected);

        actual = atm.getUserRowByID(32);
        expected = 2;

        Assert.assertEquals(actual,expected);

        actual = atm.getUserRowByID(323232);
        expected = -1;

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void getAccountInfoByID() {
        DB accountDB = atm.getAccountDB();
        accountDB.clear();

        Account account1 = new Checking(1532.34,23,1232123);
        accountDB.addRow(account1.toStringArray());
        Account account2 = new Savings(120.43,12,333223, 0.01);
        accountDB.addRow(account2.toStringArray());
        Account account3 = new Investment(234023.23,42,9948, 0.06);
        accountDB.addRow(account3.toStringArray());

        String[] actual = atm.getAccountInfoByID(333223);
        String[] expected = account2.toStringArray();

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void getAccountRowByID() {
        DB accountDB = atm.getAccountDB();
        accountDB.clear();

        Account account1 = new Checking(1532.34,23,1232123);
        accountDB.addRow(account1.toStringArray());
        Account account2 = new Savings(120.43,12,333223, 0.01);
        accountDB.addRow(account2.toStringArray());
        Account account3 = new Investment(234023.23,42,9948, 0.06);
        accountDB.addRow(account3.toStringArray());

        int actual = atm.getAccountRowByID(333223);
        int expected = 1;

        Assert.assertEquals(expected, actual);

        actual = atm.getAccountRowByID(1232123);
        expected = 0;

        Assert.assertEquals(expected, actual);

        actual = atm.getAccountRowByID(9948);
        expected = 2;

        Assert.assertEquals(expected, actual);

        actual = atm.getAccountRowByID(99323248);
        expected = -1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAccountIDsByUserTest() {
        DB accountDB = atm.getAccountDB();
        accountDB.clear();

        DB userDB = atm.getUserDB();
        userDB.clear();

        User user1 = new User("Jim","Brown","goolybib", 98, 12343);
        userDB.addRow(user1.toStringArray());
        User user2 = new User("Ji123m","Bro23wn","gool321ybib", 42, 1234313);
        userDB.addRow(user2.toStringArray());
        User user3 = new User("Jane","Himne","gasdsdool321ybib", 33, 313);
        userDB.addRow(user3.toStringArray());


        Account account1 = new Checking(1532.34,23,1232123);
        accountDB.addRow(account1.toStringArray());
        Account account2 = new Savings(120.43,12,33, 0.01);
        accountDB.addRow(account2.toStringArray());
        Account account3 = new Investment(234023.23,42,48, 0.06);
        accountDB.addRow(account3.toStringArray());
        Account account4 = new Checking(1532.34,42,5423);
        accountDB.addRow(account4.toStringArray());
        Account account5 = new Savings(120.43,98,333223, 0.01);
        accountDB.addRow(account5.toStringArray());
        Account account6 = new Investment(234023.23,42,9948, 0.06);
        accountDB.addRow(account6.toStringArray());
        Account account7 = new Checking(1532.34,23,515);
        accountDB.addRow(account7.toStringArray());
        Account account8 = new Savings(120.43,12,749, 0.01);
        accountDB.addRow(account8.toStringArray());
        Account account9 = new Investment(234023.23,42,904, 0.06);
        accountDB.addRow(account9.toStringArray());

        int[] rows = atm.getAccountRowsByUser(user1);
        String [] accountInfo;
        int[] accts = {333223};
        for (int i = 0; i < rows.length; i++) {
            accountInfo =  atm.getAccountInfoByRow(rows[i]);
            Assert.assertEquals("user1", (int)user1.getUserID(), (int) Integer.parseInt(accountInfo[1]));
            Assert.assertEquals("user1", (int)accts[i], (int) Integer.parseInt(accountInfo[0]));
        }

        int[] rows2 = atm.getAccountRowsByUser(user2);
        String [] accountInfo2;
        int[] accts2 = {48,5423,9948,904};
        for (int i = 0; i < rows2.length; i++) {
            accountInfo2 =  atm.getAccountInfoByRow(rows2[i]);
            Assert.assertEquals("user2", (int)user2.getUserID(), (int) Integer.parseInt(accountInfo2[1]));
            Assert.assertEquals("user2", (int)accts2[i], (int) Integer.parseInt(accountInfo2[0]));
        }

        int[] rows3 = atm.getAccountRowsByUser(user3);
        String [] accountInfo3;
        int[] accts3 = {};
        for (int i = 0; i < rows3.length; i++) {
            accountInfo3 =  atm.getAccountInfoByRow(rows3[i]);
            Assert.assertEquals("user3", (int)user3.getUserID(), (int) Integer.parseInt(accountInfo3[1]));
            Assert.assertEquals("user3", (int)accts3[i], (int) Integer.parseInt(accountInfo3[0]));
        }
    }

    @Test
    public void getAccountByInfoTest() {
        DB accountDB = atm.getAccountDB();
        accountDB.clear();

        Account account1 = new Checking(1532.34,23,1232123);
        accountDB.addRow(account1.toStringArray());
        Account account2 = new Savings(120.43,12,33, 0.01);
        accountDB.addRow(account2.toStringArray());
        Account account3 = new Investment(234023.23,42,48, 0.06);
        accountDB.addRow(account3.toStringArray());
        Account account4 = new Checking(1532.34,42,5423);
        accountDB.addRow(account4.toStringArray());
        Account account5 = new Savings(120.43,98,333223, 0.01);
        accountDB.addRow(account5.toStringArray());

        Assert.assertTrue("acct1", account1.equals(atm.getAccountByInfo(account1.toStringArray())));
        Assert.assertTrue("acct2", account2.equals(atm.getAccountByInfo(account2.toStringArray())));
        Assert.assertTrue("acct5", account5.equals(atm.getAccountByInfo(account5.toStringArray())));
        Assert.assertEquals(null, atm.getAccountByInfo(new String[] {"","","","",""}));

    }

    @Test
    public void getAccountsForUserTest() {
        DB accountDB = atm.getAccountDB();
        accountDB.clear();

        DB userDB = atm.getUserDB();
        userDB.clear();

        User user1 = new User("Jim","Brown","goolybib", 98, 12343);
        userDB.addRow(user1.toStringArray());
        User user2 = new User("Ji123m","Bro23wn","gool321ybib", 42, 1234313);
        userDB.addRow(user2.toStringArray());
        User user3 = new User("Jane","Himne","gasdsdool321ybib", 33, 313);
        userDB.addRow(user3.toStringArray());


        Account account1 = new Checking(1532.34,23,1232123);
        accountDB.addRow(account1.toStringArray());
        Account account2 = new Savings(120.43,12,33, 0.01);
        accountDB.addRow(account2.toStringArray());
        Account account3 = new Investment(234023.23,42,48, 0.06);
        accountDB.addRow(account3.toStringArray());
        Account account4 = new Checking(1532.34,42,5423);
        accountDB.addRow(account4.toStringArray());
        Account account5 = new Savings(120.43,98,333223, 0.01);
        accountDB.addRow(account5.toStringArray());
        Account account6 = new Investment(234023.23,42,9948, 0.06);
        accountDB.addRow(account6.toStringArray());
        Account account7 = new Checking(1532.34,23,515);
        accountDB.addRow(account7.toStringArray());
        Account account8 = new Savings(120.43,12,749, 0.01);
        accountDB.addRow(account8.toStringArray());
        Account account9 = new Investment(234023.23,42,904, 0.06);
        accountDB.addRow(account9.toStringArray());

        ArrayList<Account> actual = atm.getAccountsforUser(user1);

        Assert.assertEquals("user1", (int) 1, (int) actual.size());
        Assert.assertTrue("user1.1", Arrays.equals(account5.toStringArray(),actual.get(0).toStringArray()));

        actual = atm.getAccountsforUser(user2);

        Assert.assertEquals("user2", (int) 4, (int) actual.size());
        Assert.assertTrue("user2.1", Arrays.equals(account6.toStringArray(),actual.get(2).toStringArray()));
        Assert.assertTrue("user2.3", Arrays.equals(account3.toStringArray(),actual.get(0).toStringArray()));
    }

    @Test
    public void saveUserToDBTest() {
        DB userDB = atm.getUserDB();
        userDB.clear();

        User user1 = new User("Jim","Brown","goolybib", 12, 12343);
        atm.saveUserToDB(user1);
        User user2 = new User("Ji123m","Bro23wn","gool321ybib", 122, 1234313);
        atm.saveUserToDB(user2);
        User user3 = new User("Jane","Himne","gasdsdool321ybib", 32, 313);
        atm.saveUserToDB(user3);

        String[] actual = atm.getUserInfoByID(122);
        String[] expected = user2.toStringArray();

        Assert.assertEquals(actual,expected);

        actual = atm.getUserInfoByID(12);
        expected = user1.toStringArray();

        Assert.assertEquals(actual,expected);

        int actual2 = userDB.length();
        int expected2 = 3;

        Assert.assertEquals(actual,expected);

        User user4 = new User("Ji123m","Bro23wn","gool321ysdasdbib", 12, 1234313);
        atm.saveUserToDB(user4);

        actual2 = userDB.length();
        expected2 = 3;

        Assert.assertEquals(actual,expected);

        actual = atm.getUserInfoByID(12);
        expected = user4.toStringArray();

        Assert.assertEquals(actual,expected);

        expected = user1.toStringArray();

        Assert.assertNotEquals(actual,expected);

    }

    @Test
    public void savePendingTransactionsTest() {
        DB transactionDB = atm.getTransactionDB();
        transactionDB.clear();
        Assert.assertEquals((int)0, (int)transactionDB.length());

        Transaction trans1 = new Transaction(123.42, new Date(2014, 1, 6, 11,23, 40 ),23,"Opened account", true);
        Transaction trans2 = new Transaction(-23.57, new Date(2015, 2, 7, 10,23, 3 ),12,"Withdrawal", false);
        ArrayList<Transaction> pendingTransactions = new ArrayList<Transaction>();
        pendingTransactions.add(trans1);
        pendingTransactions.add(trans2);

        atm.savePendingTransactionsToDB(pendingTransactions);

        Assert.assertEquals((int)2, (int)transactionDB.length());

        transactionDB.clear();
        Assert.assertEquals((int)0, (int)transactionDB.length());

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