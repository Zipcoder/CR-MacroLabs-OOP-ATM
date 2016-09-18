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

    public void printSuccessfulCreation (String newCustOrAcct, int ID) {

        System.out.println("Account created.\nYour " + newCustOrAcct + " ID is: " + ID);
    }

    public void createAccountPrompt () {

        System.out.println("Enter initial balance: ");
    }

    public void printLogin () {

        System.out.println("Enter ID: ");
        System.out.println("Enter PIN: ");

    }

    public void invalidLoginMessage () {

        System.out.println("Error: invalid login info.");

    }

    public void printReturningCustomerMenu () {

        System.out.println("Press 1 to Open an account.\nPress 2 to Close and account.\nPress 3 to deposit." +
                "\nPress 4 to withdrawal.\nPress 5 to transfer.\nPress 6 to get a list of transactions." +
                "\nPress 7 to logout.");

    }

    public void closeAccountMessage (int closedMessageCase) {

        switch (closedMessageCase) {
            case 0:
                System.out.println("Error: cannot close account with balance.");
                break;
            case 1:
                System.out.println("Error: invalid account ID.");
                break;
            case 2:
                System.out.println("Account closed successfully.");
                break;

        }
    }

    public void closeAccountPrompt () {

        System.out.println("Input ID of account to close: ");

    }

    public void printAccountTypeOptions () {

        System.out.println("Press 1 to for a checking account.\nPress 2 for a savings account." +
                "\nPress 3 for an investment account");
    }

    public void transactionPrompt (String transactionType) {

        System.out.println("Enter account ID: \nEnter amount to " + transactionType + ": ");

    }

    public void transactionPrompt () {

        System.out.println("Enter from account ID: \nEnter to account ID: \nEnter amount to transfer: ");

    }

    public void transactionErrorMessage () {

        System.out.println("Error: invalid account number.");

    }

    public void transactionSuccessMessage (double balance) {

        System.out.println("Your new balance is: $" + balance);

    }

    public void printOptionErrorMessage () {

        System.out.println("Invalid option");

    }

}
