
// Test the expected User class from ATM.

<<<<<<< HEAD
//public class UserAccountTest {
/*
=======
public class UserAccountTest {

>>>>>>> 1665f322a3ea91133cbcc6a5bd4d8d916b3abc72
    @Test   // tests constructor for user with name & password
    public void testGetConstructorUserNamePWTest() {
        String expectedUsername = "User01";
        String expectedPassword = "password123";
        UserAccount testUser = new UserAccount(expectedUsername, expectedPassword);
        String actualUsername = testUser.getUsername();
        String actualPassword = testUser.getPassword();

        Assert.assertEquals(expectedUsername, actualUsername);
        Assert.assertEquals(expectedPassword, actualPassword);
    }

    @Test   // method returns username   how to test: pass in username value, check to make sure username returned
            // is same as what you passed in
    public void testGetUsernameTest() {
        String expectedUsername = "User01";
        String expectedPassword = "password123";
        UserAccount testUser = new UserAccount(expectedUsername, expectedPassword);
        String actualUsername = testUser.getUsername();

        Assert.assertEquals(actualUsername, expectedUsername);
    }

    @Test
    public void testGetUsernameTestNeg() {
        String expectedUsername = "User01";
        String expectedPassword = "password123";
        UserAccount testUser = new UserAccount(expectedUsername, expectedPassword);
        String actualUsername = testUser.getUsername();

        Assert.assertNotEquals(actualUsername, "unknown");
    }

    @Test   // method returns password   how to test: pass in username value, check to make sure username returned
            // is same as what you passed in
    public void testGetPasswordTest() {
        String expectedUsername = "User01";
        String expectedPassword = "password123";
        UserAccount testUser = new UserAccount(expectedUsername, expectedPassword);
        String actualPassword = testUser.getPassword();

        Assert.assertEquals(actualPassword, expectedPassword);
    }

    @Test
    public void testGetPasswordTestNeg() {
        String expectedUsername = "User01";
        String expectedPassword = "password123";
        UserAccount testUser = new UserAccount(expectedUsername, expectedPassword);
        String actualPassword = testUser.getPassword();

        Assert.assertNotEquals(actualPassword, "Unknown");
    }

    @Test
    public void testGetCheckingAccount() {
        String expectedUsername = "User01";
        String expectedPassword = "password123";
        UserAccount testUser = new UserAccount(expectedUsername, expectedPassword);

        String actual = testUser.getCheckingAccount().getAccountType();

        Assert.assertEquals(actual, "Checking");
    }

    @Test
    public void testGetSavingsAccount() {
        String expectedUsername = "User01";
        String expectedPassword = "password123";
        UserAccount testUser = new UserAccount(expectedUsername, expectedPassword);

        String actual = testUser.getSavingsAccount().getAccountType();

        Assert.assertEquals(actual, "Savings");
    }

    @Test
    public void testGetInvestmentAccount() {
        String expectedUsername = "User01";
        String expectedPassword = "password123";
        UserAccount testUser = new UserAccount(expectedUsername, expectedPassword);

        String actual = testUser.getInvestmentAccount().getAccountType();

        Assert.assertEquals(actual, "Investment");
    }
}
