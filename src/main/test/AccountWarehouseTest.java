import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class AccountWarehouseTest {


    @Test
    public void findAccountByAcctNumber(){
        //given
        // ArrayList<Account> accounts = AccountWarehouse.getAccounts();
        Account expected = new Savings();
        AccountWarehouse.addAccount(expected);

        //when
        Account actual = AccountWarehouse.findAccountByAcctNumber(expected.getAcctNumber());

        //then
        Assert.assertEquals(expected,actual);

    }


    @Test
    public void addAccountTest(){
        //given
        Account expected  = new Savings();

        //when
        AccountWarehouse.addAccount(expected);

        //then
        Account actual = AccountWarehouse.findAccountByAcctNumber(expected.getAcctNumber());


        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeAccountTest(){

        //given
        Account expected = null;
        Account acctnumber1 = new Savings();

        //when
        AccountWarehouse.addAccount(acctnumber1);
        AccountWarehouse.removeAccount(acctnumber1);
        Account actual = AccountWarehouse.findAccountByAcctNumber(acctnumber1.getAcctNumber());


        //then
        Assert.assertEquals(expected, actual);

    }

}
