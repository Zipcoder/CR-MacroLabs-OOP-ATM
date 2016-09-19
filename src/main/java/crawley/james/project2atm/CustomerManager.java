package crawley.james.project2atm;

import java.util.ArrayList;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class CustomerManager {

    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer (String name, int pin, int customerID) {

        customers.add(new Customer (name, pin, customerID));

    }

    public Customer getCustomer (int customerID) {

        for (Customer matchingCustomer: customers) {
            if (matchingCustomer.getCustomerID() == customerID) {
                return matchingCustomer;
            }

        }
        return null;
    }
}
