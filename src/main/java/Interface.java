

public class Interface {

    Account account = new Account();
    CreateAccount newAccount = new CreateAccount();
    //LogIn logIn = new LogIn();
    AccountActions accountActions = new AccountActions();


    public void atmApp() {
        Integer choice;

        do {

            Console.println("Please type one of the following options:\n" +
                    "1 = Log in to Account.\n" +
                    "2 = Create new Account.\n" +
                    "3 = Exit ATM.\n");

            choice = Console.getIntegerInput("Enter the choice you would like to make.\n");

            switch (choice) {


                // LogIn Code
                case 1:
                    break;


                // Creating new Account Code
                case 2:
                    break;


                case 3:
                    Console.println("SHUTTING DOOOWWNNNNNN!!!!!!");
                    break;
            }
        } while (choice != 3);

    }
}
