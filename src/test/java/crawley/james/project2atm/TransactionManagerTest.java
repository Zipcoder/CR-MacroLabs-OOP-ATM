package crawley.james.project2atm;

import org.junit.Test;
import static  org.junit.Assert.*;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class TransactionManagerTest {

    @Test
    public void addDepositOrWithdrawalTest () {

        TransactionManager transactionManager = new TransactionManager();
        transactionManager.addTransaction(Transaction.TransactionType.DEPOSIT, 12, 1, 50);

        assertEquals("The customer ID should be 12, ID 1 and amount +$50.", "Customer: 12, Account: 1, DEPOSIT: $50.0\n",
                transactionManager.getTransactions(12));
    }

    @Test
    public void addTransferTest () {

        TransactionManager transactionManager = new TransactionManager();
        transactionManager.addTransaction(12, 1, 2, 50);

        assertEquals("The customer ID should be 12, From ID 1, To ID and amount $50.", "Customer: 12, From Account: 1, To Account: 2, TRANSFER: $50.0\n",
                transactionManager.getTransactions(12));

    }
}
