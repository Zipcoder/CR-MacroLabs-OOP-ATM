
import java.util.ArrayList;
import java.util.Scanner;

public class Console {


    public void Start() {
        mainMenu();
    }

    User currentUser;
    int currentAccount;


    public void login() {
        ArrayList<User> users = UserWarehouse.getList();

        Scanner loginInput = new Scanner(System.in);
        System.out.println("Please enter Username to login: ");
        String userName = loginInput.nextLine();
        System.out.println("Please enter a password: ");
        String userPassword = loginInput.nextLine();


        for (User user : users) {
            if (user.getUserName().contains(userName)) {
                if (user.getPassword().contains(userPassword)) {
                    currentUser = user;
                    accountMenu();
                } else {
                    System.out.println("User does not exist.\n");
                    mainMenu();
                }
            } else {
                System.out.println("User does not exist.\n");
                mainMenu();
            }
        }
        mainMenu();
    }

    private void mainMenu() {
        int userinput;
        boolean continueInput;

        Scanner input = new Scanner(System.in);
        System.out.println("\n-------Welcome-------\n" +
                "1: Create Account\n" +
                "2: Login\n" +
                "3: Exit");
        enterInteger();
        userinput = 0;
        if (input.hasNextInt()) {
            userinput = input.nextInt();
        } else {
            System.out.println("Please try an integer.");
            mainMenu();
        }
        switch (userinput) {
            case 1:
                UserFactory.createUser();
                login();
                break;
            case 2:
                login();
                break;
            case 3:
                exit();
                break;
            default:
                System.out.println("Not a valid selection");
                mainMenu();
        }
    }

    public void accountMenu() {
        System.out.println("-----------------\n" +
                "1: Checking \n" +
                "2: Savings\n" +
                "3: Investing\n" +
                "4: Main Menu");
        enterInteger();

        Scanner input = new Scanner(System.in);
        int userInput;
        userInput = 0;
        if (input.hasNextInt()) {
            userInput = input.nextInt();
        } else {
            System.out.println("Please try an integer.");
            accountMenu();
        }
        switch (userInput) {
            case 1:
                currentAccount = 0;
                accountActions();
                break;
            case 2:
                currentAccount = 1;
                accountActions();
                break;
            case 3:
                currentAccount = 2;
                accountActions();
                break;
            case 4:
                mainMenu();
                break;
            default:
                System.out.println("Not a valid selection.");
                accountMenu();
        }
    }

    public void accountActions() {
        System.out.println("-----------------\n" +
                "1: Check Balance\n" +
                "2: Add Funds\n" +
                "3: Withdraw\n" +
                "4: Transaction History\n" +
                "5: Transfers\n" +
                "6: Back\n");

        enterInteger();
        Scanner input = new Scanner(System.in);
        int userInput;
        userInput = 0;
        if (input.hasNextInt()) {
            userInput = input.nextInt();
        } else {
            System.out.println("Please try an integer.");
            accountActions();
        }
        switch (userInput) {
            case 1:
                //check balance
                System.out.println("$" + currentUser.accounts.get(currentAccount).checkBalance());
                accountActions();
                break;
            case 2:
                //add funds/deposit
                System.out.println("Amount to be deposited: ");
                double depoFunds = 0;
                if (input.hasNextDouble()) {
                    depoFunds = input.nextDouble();
                } else {
                    System.out.println("Please try an integer.");
                    accountActions();
                }
                currentUser.accounts.get(currentAccount).addFunds(depoFunds);
                accountActions();
                break;
            case 3:
                //withdraw
                System.out.println("Amount to be withdrawn: ");
                double withDrawFunds = 0;
                if (input.hasNextDouble()) {
                    withDrawFunds = input.nextDouble();
                } else {
                    System.out.println("Please try an integer.");
                    accountActions();
                }
                currentUser.accounts.get(currentAccount).withDraw(withDrawFunds);
                accountActions();
                break;
            case 4:
                System.out.println("Transaction history:");
                currentUser.accounts.get(currentAccount).printHistory();
                accountActions();
                break;
            case 5:
                tranfers();
                break;
            case 6:
                accountMenu();
                break;
            default:
                accountActions();
        }
    }

    private void tranfers() {
        int userInput;
        int toAccount = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------\n" +
                "Transfer to: \n" +
                "1: Checking\n" +
                "2: Savings\n" +
                "3: Investing\n");

        enterInteger();

        if (input.hasNextInt()) {
            toAccount = input.nextInt();
        } else {
            System.out.println("Please try an integer.");
            tranfers();
        }

        double funds = 0;
        System.out.println("Amount to transfer: ");
        if (input.hasNextDouble()) {
            funds = input.nextDouble();
        } else {
            System.out.println("Please try an integer.");
            tranfers();
        }
        currentUser.accounts.get(currentAccount).withDraw(funds);
        currentUser.accounts.get(toAccount - 1).addFunds(funds);
        accountActions();
    }

    private void enterInteger() {
        System.out.println("Please enter an integer.");
    }

    private void exit() {
        System.exit(0);
    }
}
