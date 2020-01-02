package com.zipcode.macrolabs.atm;

import com.zipcode.macrolabs.atm.bankaccount.AccountTestSuite;
import com.zipcode.macrolabs.atm.navigation.NavigationTestSuite;
import com.zipcode.macrolabs.atm.transaction.TransactionTestSuite;
import com.zipcode.macrolabs.atm.user.UserTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountTestSuite.class,
        UserTestSuite.class,
        TransactionTestSuite.class,
        NavigationTestSuite.class
})
public class AllTestsSuite {
}
