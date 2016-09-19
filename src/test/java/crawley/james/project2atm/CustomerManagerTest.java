package crawley.james.project2atm;

import org.junit.Test;
import static  org.junit.Assert.*;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class CustomerManagerTest {

    @Test
    public void testAddCustomers () {
        CustomerManager customerManager = new CustomerManager();
        customerManager.addCustomer("William Williams", 1784, 1);
        assertNotNull("The customer should have been added to the list.", customerManager.getCustomer(1));

    }
}
