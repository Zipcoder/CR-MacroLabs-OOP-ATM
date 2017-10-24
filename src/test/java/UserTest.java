import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void isCorrectPasswordTest1() {
        //: Given
        User testUser = new User("a");
        boolean expected = false;

        //: When
        boolean actual = testUser.isCorrectPassword("b");

        //: Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isCorrectPasswordTest2() {
        //: Given
        User testUser = new User("a");
        boolean expected = true;

        //: When
        boolean actual = testUser.isCorrectPassword("a");

        //: Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAccountTest() {
        //: Given
        User testUser = new User("a");
        Account testAccount = new Account();
        Account expected = testAccount;

        //: When
        testUser.addAccount(testAccount);
        Account actual = testUser.getAccounts().get(testUser.getAccounts().size()-1);

        //: Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void closeAccountTest1() {
        //: Given
        User testUser = new User("a");
        Account testAccount = new Account();
        testUser.addAccount(testAccount);
        boolean expected = false;

        //: When
        testAccount.deposit(100);
        boolean actual = testUser.closeAccount(testAccount);

        //: Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void closeAccountTest2() {
        //: Given
        User testUser = new User("a");
        Account testAccount = new Account();
        testUser.addAccount(testAccount);
        boolean expected = true;

        //: When
        boolean actual = testUser.closeAccount(testAccount);

        //: Then
        Assert.assertEquals(expected, actual);
    }
}
