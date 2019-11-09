import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AccountVillageTest {

    @Test
    public void accountVillageConstructor() {
        AccountVillage newAV = new AccountVillage();
        Integer expectedId = 0;

        Map<Integer, Account> actualAccounts = newAV.getAccounts();
        Integer actualId = newAV.getNextId();

        Assert.assertTrue(actualAccounts.isEmpty());
        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void createAccountTest() {
        AccountVillage newAV = new AccountVillage();
        Integer expectedSize = newAV.getAccounts().size() + 1;
        newAV.createAccount(100.0, "checking");

        Integer actualSize = newAV.getAccounts().size();
        Assert.assertEquals(expectedSize, actualSize);
    }


    @Test
    public void getAccountByIdTesT() {
        AccountVillage newAV = new AccountVillage();
        Double expectedBalance = 100.0;
        Integer expectedAccountId = 1;
        Account account = newAV.createAccount(100.0, "checking");

        Double actualBalance = newAV.getAccountById(1).getBalance();
        Integer actualAccountId = newAV.getAccountById(1).getAccountID();

        Assert.assertEquals(expectedBalance, actualBalance);
        Assert.assertEquals(expectedAccountId, actualAccountId);
    }

    @Test
    public void getAccounts() {
        AccountVillage newAV = new AccountVillage();
        newAV.createAccount(100.0, "checking");
    }

    @Test
    public void setAccounts() {
        Map<Integer, Account> accounts = new HashMap<Integer, Account>();
        accounts.put(1,new Account(22.22, 1));
        accounts.put(2,new Account(34.32, 2));
        AccountVillage accountVillage = new AccountVillage();
        accountVillage.setAccounts(accounts);
        Map<Integer, Account> actual = accountVillage.getAccounts();
        Map<Integer, Account> expected = accounts;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNextIdTest() {
        AccountVillage newAV = new AccountVillage();
        Integer actual = newAV.getNextId();
        Integer expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNextIdTest() {
        AccountVillage newAV = new AccountVillage();
        Integer expected = 2;
        newAV.setNextId(2);
        Integer actual = newAV.getNextId();
        Assert.assertEquals(expected, actual);
    }
}
