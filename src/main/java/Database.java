import java.util.ArrayList;
import java.util.Arrays;

public class Database {
    private static volatile ArrayList<Customer> currentCustomers = new ArrayList<Customer>();

    public static void addCustomer(Customer customer) {
        currentCustomers.add(customer);
    }

    public static void addMultipleCustomers(Customer... customer) {
        currentCustomers.addAll(Arrays.asList(customer));
    }

    public static Customer getCustomerByName(String name) {
        for(Customer customer : currentCustomers) {
            if(customer.getCustomerName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    public static Customer getCustomerByUsername(String username) {
        for(Customer customer : currentCustomers) {
            if(customer.getUserName().equals(username)) {
                return customer;
            }
        }
        return null;
    }

    public static void removeCustomer(Customer customer) {
        currentCustomers.remove(customer);
    }

    public static Integer getNumberOfCustomers() {
        return currentCustomers.size();
    }

    public static void removeAllCustomers() {
        currentCustomers.clear();
    }


}
