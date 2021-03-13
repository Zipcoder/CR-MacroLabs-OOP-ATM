import org.junit.Assert;
import org.junit.Test;
import sun.util.resources.cldr.so.CurrencyNames_so;

import java.util.ArrayList;

public class CustomerTest {

    @Test
    public void CustomerTest(){


        //given
        Customer customer = new Customer("luvmykitty47", "fluffy");
        String expected_username = "luvmykitty47";
        String expected_password = "fluffy";

        //when
        String actual_username = customer.getUsername();
        String actual_password = customer.getPassword();


        //then
        Assert.assertEquals("test constructor username", expected_username, actual_username);
        Assert.assertEquals("test constructor password", expected_password, actual_password);
    }

    @Test
    public void openAccount(){
        //given
        Customer customer = new Customer();
        int expected = customer.getCustomerAccounts().size() + 1;

        //when
        customer.openAccount();

        //Account actual = customer.lookupAcctByNumber();
        //when you realize that you're trying to figure out how declare an "expected" object before
        //it's been created, it's time to go to bed.
        int actual =customer.getCustomerAccounts().size();

        //then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void lookupAccountByNumber(){
        //given
        Customer customer = new Customer();
        Account checking = new Checking();
        int expected = checking.getAcctNumber();

        customer.getCustomerAccounts().add(checking);

        //when
        Account lookedUpAccount = customer.lookupAcctByNumber(expected);
        int actual = lookedUpAccount.getAcctNumber();

        //then
        Assert.assertEquals(expected,actual);

    }

//    @Test
//    public void getCustomerAccountsTest(){
//        //given
//        Customer customer = new Customer();
//        ArrayList<Account> customerAccounts = new
//        //when
//
//        //then
//    }
//
//
//    @Test
//    public void getAccountByIndex(){
//        //given
//        Customer customer = new Customer();
//        String expected = "Account# 1";
//
//        //when
//        String actual = customer.getAccountByIndex(0);
//
//        //then
//        Assert.assertEquals(expected, actual);
//
//
//    }
//
//
//    @Test
//    public void addOneAccountTest(){
//        //given
//        Customer customer = new Customer();
//        String expected = "You now have 3 accounts: Account# 1, Account# 2, Account# 3.";
//
//        //when
//        customer.addOneAccount(); //add account 2
//        customer.addOneAccount(); //add account 3
//
//
//        String actual = "You now have " + customer.getNumberOfAccounts() + " accounts: "; // + customer.listAllAccounts()
//
//        //then
//        Assert.assertEquals(expected, actual);
//
//
//    }

//    @Test
//    public void getAccountObjectByIndex(){
//        //given
//        Customer customer = new Customer();
//        Account expected = new Checking();
//
//        //when
//        Account actual = customer.getAccountObjectByIndex(0);
//
//        Assert.assertEquals(expected,actual);




    }

//    @Test
//    public void getAccountList(){
//        //given
//        Customer customer = new Customer();
//        String expected = "Some weird string of objects or hashes";
//
//        //when
//        Objec = customer.getAccountList();
//
//        //then
//        Assert.assertEquals(expected, actual);
//    }


//    @Test
//    public void getOneAccount(){
//        //given
//        Customer customer = new Customer();
//        String expected = "Account 0";
//
//        //when
//        String expected = customer.ArrayList.get(0)
//    }
//
//    @Test
//    public void addOneAccount(){
//       //given
//       Customer customer = new Customer();
//       String expected = "Your new checking account 'gpatselas2' is now available.";
//
//       //when
//       String actual =  customer.addOneAccount();
//
//
//       //then
//        Assert.assertEquals(expected,actual);
//
//    }

    //moved deposit to account class

//    @Test
//    public void depositTest(){
//
//        //given
//        Customer acustomer = new Customer();
//        String expected = "You're new balance is 5000.";
//
//        //when
//        String actual = acustomer.deposit(5000);
//
//        //then
//        Assert.assertEquals(expected,actual);
//
//
//        }







