package crawley.james.project2atm;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class TransactionTest {

    @Test
    public void getFromAccountNumberTest () {

        Transaction transaction = new Transaction(Transaction.TransactionType.WITHDRAWAL, 12, 1, 100);

        assertEquals("The account number should be 1", 1, transaction.getFromAccountNumber());

    }

    @Test
    public void getToAccountNumberTest () {

        Transaction transaction = new Transaction(Transaction.TransactionType.WITHDRAWAL, 12, 1, 2, 100);

        assertEquals("The account number should be 2", 2, transaction.getToAccountNumber());

    }

    @Test
    public void getTransactionTypeTest () {

        Transaction transaction = new Transaction(Transaction.TransactionType.WITHDRAWAL, 12, 1, 100);

        assertEquals("The transaction type should be WITHDRAWAL", Transaction.TransactionType.WITHDRAWAL,
                transaction.getTransactionType());

    }

    @Test
    public void getAmountTest () {

        Transaction transaction = new Transaction(Transaction.TransactionType.WITHDRAWAL, 12, 1, 100);

        assertEquals("The the amount should be $100", 100, transaction.getAmount(), 0);

    }
}
