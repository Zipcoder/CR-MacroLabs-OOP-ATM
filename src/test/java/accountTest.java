import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class accountTest {
    ATM atm = ATM.getInstance();

    @Test       // test getAccountBalance and setAccountBalance
    public void AccountBalanceTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        currentUser.addAccount("checking");
        Account currentAccount = currentUser.EnterAccount(1);

        double expected = 500;

        currentAccount.setBalance(500);

        double actual = currentAccount.getBalance();

        Assert.assertEquals(expected,actual,0);
    }

    @Test       // test getAccountType and setAccountType
    public void AccountTypeTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");

        String expected = "savings";

        currentUser.addAccount(expected);
        Account currentAccount = currentUser.EnterAccount(1);
        String actual = currentAccount.getAccountType();

        Assert.assertEquals(expected,actual);
    }

    @Test       // test getAccountNum and setAccountNum
    public void AccountNumberTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        currentUser.addAccount("savings");
        Account currentAccount = currentUser.EnterAccount(1);

        int expected = 1;

        int actual = currentAccount.getAccountNum();

        Assert.assertEquals(expected,actual);
    }

    @Test       // test getAccountHistory and addToAccountHistory
    public void accountHistoryTest(){
        atm.addUser("wes","password");
        User currentUser = atm.EnterUser("wes");
        currentUser.addAccount("savings");
        Account account = currentUser.EnterAccount(1);
        currentUser.deposit(50,account);
        String expected = "Deposit  50.0";

        ArrayList history = account.getAccountHistory();
        String actual = (String)history.get(0);


        Assert.assertEquals(expected,actual);
    }

}
