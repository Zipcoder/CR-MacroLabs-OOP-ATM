package com.zipcode.macrolabs.atm.user;

import com.zipcode.macrolabs.atm.exceptions.NoMoreUsersException;
import org.junit.*;

public class UserFactoryTest {

    public static User createBob(){
        String name = "Uncle Bob";
        String password = "cleancode";

        return UserFactory.createNewUser(name, password);

    }

    User user;

    @Before
    public void setUp(){
        user = createBob();
        UserFactory.iteratedUserID = 0;
    }

    @After
    public void tearDown(){
        UserFactory.iteratedUserID = 0;
    }

    @Test(expected = NoMoreUsersException.class)
    public void noMoreUserIDsTest() throws NoMoreUsersException {
        UserFactory.iteratedUserID += (int) Math.pow(10, UserFactory.USER_ID_LENGTH);
        int nextID = UserFactory.nextUserID();
    }

    @Test
    public void setAndGetUserIDTestShouldBe7(){
        user.setUserID(7);
        int expectedID = 7;
        int actualID = Integer.valueOf(user.getUserID());
        Assert.assertEquals(expectedID, actualID);
    }

    @Test
    public void iteratingIDTest(){
        int iterations = 5;
        for (int i = 0; i < iterations; i++) {
            createBob();
        }
        Assert.assertEquals(iterations, UserFactory.iteratedUserID);
    }

    @Test
    public void setUserNameTestShouldBeUncleBob(){
        Assert.assertEquals("Uncle Bob", user.getUserName());
    }

    @Test
    public void setUserPasswordShouldBeCleanCode(){
        Assert.assertEquals("cleancode", user.getUserPassword());
    }

    @Test
    public void setUserAccountsTestShouldBeEmpty(){
        Assert.assertEquals(0, user.getAccounts().size());
    }

}
