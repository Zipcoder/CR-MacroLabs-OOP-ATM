package butte.emily.ATM;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by emilybutte on 9/16/16.
 */
public class AccountManagerTest {

    public AccountManager accountmanager = new AccountManager();

    @Test
    public void getBankAccounts() {
        HashMap<String, ArrayList<BankAccount>> expected = getBankAccounts();
        Assert.assertEquals("should return BankAccounts hashmap", expected);
    }




}
