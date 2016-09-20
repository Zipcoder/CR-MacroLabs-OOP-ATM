import butte.emily.ATM.BankAccount;
import butte.emily.ATM.Transaction;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by emilybutte on 9/16/16.
 */
public class BankAccountTest {

    public BankAccount bankAccount = new BankAccount();

    @Test
    public void getBalance() {
        BankAccount expected = BankAccount.getBalance();
        Assert.assertEquals("should return account balance", expected);
    }
}




