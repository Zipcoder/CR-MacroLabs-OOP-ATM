package crawley.james.project2atm;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class Display {

    public void printWelcomeScreen () {

        System.out.println("Welcome!\nPress 1 for for new customer." +
                "\nPress 2 for returning customer.\nPress 3 to Exit.");

    }

    public void printNewCustomerMenu () {

        System.out.println("Enter name: ");
        System.out.println("Enter PIN: ");

    }

    public void printLogin () {

        System.out.println("Enter ID: ");
        System.out.println("Enter PIN: ");

    }

    public void printReturningCustomerMenu () {

        System.out.println("Press 1 to open a new account.\n Press 2 to perform a transaction on an existing account.");

    }

    public void printTransactionMenu () {

        System.out.println("Press 1 to deposit.\nPress 2 to withdrawal.\nPress 3 to transfer.\nPress 4 to Close an account.");

    }
}
