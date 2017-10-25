package com.zipcode.macrolabs.atm.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserWarehouseTest {

    @Before
    public void setUp(){
        UserFactory.iteratedUserID = 0;
    }

    @Test
    public void addOnePersonTest(){
        int initial = UserWarehouse.getUsers().size();
        UserFactoryTest.createBob();
        int after = UserWarehouse.getUsers().size();
        int expectedSizeChange = 1;
        int actualSizeChange = after - initial;
        Assert.assertEquals(expectedSizeChange, actualSizeChange);
    }

    @Test
    public void findUserByIDTest(){
        String id = "000000003";
        for (int i = 0; i < 5; i++) {
            UserFactoryTest.createBob();
        }
        User user = UserWarehouse.findUserByID(id);

        Assert.assertEquals(id, user.getUserID());
    }

}
