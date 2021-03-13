import org.junit.Assert;
import org.junit.Test;

public class CustomerWarehouseTest {

    @Test
    public void lookupCustomerTest(){
        //given
        Customer expected = new Customer();
        CustomerWarehouse.addCustomer(expected);

        //when
        Customer actual = CustomerWarehouse.lookupCustomer(expected.getUsername());

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCustomer(){
        //given
//        CustomerWarehouse<Customer> customers = new CustomerWarehouse();
        Customer expected = new Customer();
        CustomerWarehouse.addCustomer(expected);

        //when
        Customer actual = CustomerWarehouse.lookupCustomer(expected.getUsername());

        //then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void removeCustomerTest(){
        //given
        Customer expected = null;
        Customer customer = new Customer();
        CustomerWarehouse.addCustomer(customer);

        //when
        CustomerWarehouse.removeCustomer(customer);
        Customer actual = CustomerWarehouse.lookupCustomer(customer.getUsername());

        //then
        Assert.assertEquals(expected,actual);
    }
}
