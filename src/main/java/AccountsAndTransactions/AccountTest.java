package AccountsAndTransactions;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void AccountTest(){
        Account jeff = new Account("Jeff", "Smith",1234);
        Assert.assertEquals("Jeff", jeff.getFirstName());
        Assert.assertEquals("Smith", jeff.getLastName());
        Assert.assertEquals(1234, jeff.getPin());
    }

}