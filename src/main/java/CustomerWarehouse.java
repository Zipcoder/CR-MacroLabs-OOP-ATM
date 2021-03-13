import java.util.ArrayList;

public class CustomerWarehouse {

    private static final ArrayList<Customer> customers = new ArrayList<Customer>();



    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static Customer lookupCustomer(String username) {
//        for(Customer currentelement: customers) {
//            if (customers.get(currentelement).getUsername() == username) {
//                return customers.get(currentelement);
//            }
//        }
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getUsername() == username) {
                return customers.get(i);
            }

        }return null;
    }
    public static void addCustomer(Customer customer){
        customers.add(customer);
    }

    public static void removeCustomer(Customer customer){
        customers.remove(customer);
    }
}
