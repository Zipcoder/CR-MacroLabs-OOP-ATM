
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

        Scanner input = new Scanner(System.in);
        System.out.println("1: Create Account\n" +
                "2: Login\n" +
                "3: Exit\n");
        userinput = input.nextInt();
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

        }

    }


    public void accountMenu() {
        System.out.println("-----------------\n" +
                "1: Checking \n" +
                "2: Savings\n" +
                "3: Investing\n" +
                "4: Main Menu");
        int userInput;
        Scanner input = new Scanner(System.in);
        userInput = input.nextInt();
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
//            case 5:
//                mainMenu();
//                break;
        }

    }


    public void accountActions() {
        System.out.println("-----------------\n" +
                "1: Check Balance\n" +
                "2: Add Funds\n" +
                "3: Withdraw\n" +
                "4: Transfers\n" +
                "5: Back");
        int userInput;
        Scanner input = new Scanner(System.in);
        userInput = input.nextInt();
        switch (userInput) {
            case 1:
                //check balance
                System.out.println("$" + currentUser.accounts.get(currentAccount).checkBalance());
                accountActions();
                break;
            case 2:
                //add funds/deposit
                System.out.println("Amount to be deposited: ");
                double depoFunds = input.nextDouble();
                currentUser.accounts.get(currentAccount).addFunds(depoFunds);
                accountActions();
                break;
            case 3:
                //withdraw
                System.out.println("Amount to be withdrawn: ");
                double withDrawFunds = input.nextDouble();
                currentUser.accounts.get(currentAccount).withDraw(withDrawFunds);
                accountActions();
                break;
            case 4:
                tranfers();
                break;
            case 5:
                accountMenu();
                break;
        }
    }

    private void tranfers() {
        int userInput;
//      int account = 0;
        int toAccount = 0;
        Scanner input = new Scanner(System.in);

//        System.out.println( "Transfer from: \n" +
//                            "0: Checking\n" +
//                            "1: Savings\n" +
//                            "2: Investing");
//        account = input.nextInt();
        System.out.println("Transfer to: \n" +
                "0: Checking\n" +
                "1: Savings\n" +
                "2: Investing");
        toAccount = input.nextInt();
        System.out.println("Amount to transfer: ");


        double funds = input.nextDouble();
        currentUser.accounts.get(currentAccount).withDraw(funds);
        currentUser.accounts.get(toAccount).addFunds(funds);
        accountActions();

    }

    private void exit() {
        System.exit(0);
    }


}
