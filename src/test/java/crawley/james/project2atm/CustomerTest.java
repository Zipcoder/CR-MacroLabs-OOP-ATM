package crawley.james.project2atm;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * Created by jamescrawley on 9/16/16.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerTest {



    @Test
    public void customerNameTest () {
        Customer customer = new Customer("William Williams", 1784);

        assertEquals("The name should be William Williams.", "William Williams", customer.getName());

    }

    @Test
    public void customerIDTest () {
        Customer customer = new Customer("William Williams", 1784);

        assertEquals("The ID should be 1", 1, customer.getCustomerID());

    }

    @Test
    public void customerPINTest () {
        Customer customer = new Customer("William Williams", 1784);

        assertEquals("The PIN should be 1784.", 1784, customer.getPin());

    }
}
