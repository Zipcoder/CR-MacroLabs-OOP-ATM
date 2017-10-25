package com.zipcode.macrolabs.atm.user;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserTest.class,
        UserFactoryTest.class,
        UserWarehouseTest.class
})
public class UserTestSuite {
}
