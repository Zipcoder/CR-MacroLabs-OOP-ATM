package crawley.james.project2atm;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class Customer {

    private int customerID;
    private static int customerIDCounter = 0;
    private String name;
    private int pin;

    Customer (String name, int pin) {

        this.name = name;
        this.pin = pin;
        customerID = ++customerIDCounter;

    }

    public void setName (String name) {

        this.name = name;

    }

    public String getName () {

        return name;

    }

    public void setPin (int pin) {

        this.pin = pin;

    }

    public int getPin () {

        return pin;

    }

    public int getCustomerID () {

        return customerID;
    }

}
