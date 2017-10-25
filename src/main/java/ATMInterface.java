import java.util.Scanner;

public class ATMInterface {
    private User currentUser;
    private Account currentAccount;

    public void start() {
        UserWarehouse.generateMyUsers();
        displayWelcome();
    }

    private void displayWelcome() {
        System.out.println("Welcome to the ATM");
        newUserOrLogin();
    }

    private void newUserOrLogin() {
        System.out.println("New user or login?");
        System.out.println("1: New User");
        System.out.println("2: Login");
        System.out.println("3: Exit");
        int userInput = -1;
        try {
            userInput = getUserInputInt();
        } catch (Exception e) {
            printInvalidInputMessage();
            newUserOrLogin();
        }
        System.out.println();
        switch (userInput) {
            case 1:
                newUser();
                break;
            case 2:
                login();
                break;
            case 3:
                System.out.println("Goodbye");
                System.exit(0);
                break;
            default:
                printInvalidInputMessage();
                newUserOrLogin();
                break;
        }

    }

    private void newUser() {
        String password = testPasswordRules();
        User newUser = new User(password);
        UserWarehouse.addUser(newUser);
        currentUser = newUser;
        System.out.printf("Verified User %d is now logged in\n", newUser.getUserID());
        System.out.println();
        displayAvailableOptions();
    }

    private String testPasswordRules() {
        boolean isPasswordValid = false;
        String password = "";
        while(!isPasswordValid) {
            System.out.println("Enter your preferred password: (must be at least 6 characters)");
            try {
                password = getUserInputString();
            } catch (Exception e) {
                printInvalidInputMessage();
            }
            System.out.println();
            if(password.length() < 6) {
                printInvalidInputMessage();
            }
            else {
                isPasswordValid = true;
            }
        }
        return password;
    }

    private void login() {
        int userID = loginEnterUserID();
        User userAtLogin = UserWarehouse.returnUserFromID(userID);
        if(userAtLogin != null) {
            boolean loggedInCorrectly = false;
            while (!loggedInCorrectly) {
                String inputPassword = loginEnterPassword();
                if (userAtLogin.isCorrectPassword(inputPassword)) {
                    System.out.printf("Verified User %d is now logged in\n", userID);
                    System.out.println();
                    loggedInCorrectly = true;
                    currentUser = userAtLogin;
                    displayAvailableOptions();
                } else {
                    System.out.println("Sorry, password is incorrect, try again");
                    System.out.println();
                }
            }
        }
        else {
            System.out.println("User does not exist");
            System.out.println();
            newUserOrLogin();
        }
    }

    private int loginEnterUserID() {
        System.out.println("Login screen");
        System.out.println("Enter user ID");
        int userID = -1;
        try {
            userID = getUserInputInt();
        } catch (Exception e) {
            printInvalidInputMessage();
            login();
        }
        System.out.println();
        return userID;
    }

    private String loginEnterPassword() {
        System.out.println("Enter password");
        String inputPassword = "";
        try {
            inputPassword = getUserInputString();
        } catch (Exception e) {
            printInvalidInputMessage();
            login();
        }
        System.out.println();
        return inputPassword;
    }



    private void displayAvailableOptions() {
        System.out.println("Available Options:");
        System.out.println("1: Select Account");
        System.out.println("2: Create Account");
        System.out.println("3: Logout");
        int userInput = -1;
        try {
            userInput = getUserInputInt();
        } catch (Exception e) {
            printInvalidInputMessage();
            displayAvailableOptions();
        }
        System.out.println();
        switch (userInput) {
            case 1:
                displayAvailableAccounts();
                break;
            case 2:
                createAccount();
                break;
            case 3:
                logout();
                break;
            default:
                printInvalidInputMessage();
                displayAvailableOptions();
                break;
        }
    }

    private void displayAvailableAccounts() {
        if(currentUser.getAccounts().size() == 0) {
            System.out.println("You have no accounts, would you like to create one?");
            System.out.println("1: Create Account");
            System.out.println("2: Logout");
            int userInput = 1;
            try {
                userInput = getUserInputInt();
            } catch (Exception e) {
                printInvalidInputMessage();
                displayAvailableAccounts();
            }
            System.out.println();
            switch (userInput) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    logout();
                    break;
                default:
                    printInvalidInputMessage();
                    displayAvailableAccounts();
                    break;
            }
        }
        else {
            System.out.println("Your available accounts are below, please select the account");
            int index = 1;
            for(Account account: currentUser.getAccounts()) {
                System.out.println(index + ": " + account.getAccountType() + " Available balance: "
                        + String.format("$%.2f",account.getBalance()) + " Account number: " + account.getAccountNumber());
                index++;
            }
            int userInput = 1;
            try {
                userInput = getUserInputInt();
            } catch (Exception e) {
                printInvalidInputMessage();
                displayAvailableAccounts();
            }
            System.out.println();
            Account chosenAccount = currentUser.getAccounts().get(userInput - 1);
            if(chosenAccount != null) {
                currentAccount = chosenAccount;
                displaySelectedAccountOptions();
            }
        }
    }

    private void createAccount() {
        AccountType typeOfAccount = selectTypeOfAccount();
        Account newAccount = new Checking(); // default

        boolean hasInitialBalance = hasInitialBalance();
        double initialBalance = 0;
        if(hasInitialBalance) {
            initialBalance = setInitialBalance();
        }

        switch (typeOfAccount) {
            case CHECKING:
                newAccount = new Checking(initialBalance);
                break;
            case SAVINGS:
                newAccount = new Savings(initialBalance);
                break;
            case INVESTMENT:
                newAccount = new Investment(initialBalance);
                break;
            default:
                printInvalidInputMessage();
                createAccount();
                break;
        }
        currentUser.addAccount(newAccount);
        currentAccount = newAccount;
        System.out.println("Your new account is: " + currentAccount.getAccountType() + " Available balance: "
                + String.format("$%.2f",currentAccount.getBalance()) + " Account number: "
                + currentAccount.getAccountNumber());
        System.out.println();
        displaySelectedAccountOptions();
    }

    private AccountType selectTypeOfAccount() {
        int userInput = -1;
        AccountType typeOfAccount = AccountType.CHECKING;
        while (userInput < 1 || userInput > 3) {
            System.out.println("What type of account would you like to create?");
            System.out.println("1: " + AccountType.CHECKING);
            System.out.println("2: " + AccountType.SAVINGS);
            System.out.println("3: " + AccountType.INVESTMENT);

            try {
                userInput = getUserInputInt();
            } catch (Exception e) {
                printInvalidInputMessage();
                createAccount();
            }
            System.out.println();

            switch (userInput) {
                case 1:
                    typeOfAccount = AccountType.CHECKING;
                    break;
                case 2:
                    typeOfAccount = AccountType.SAVINGS;
                    break;
                case 3:
                    typeOfAccount = AccountType.INVESTMENT;
                    break;
                default:
                    printInvalidInputMessage();
                    break;
            }
        }
        return typeOfAccount;
    }

    private boolean hasInitialBalance() {
        boolean providedInitialBalance = false;
        int userInputBalance = -1;
        while(userInputBalance < 1 || userInputBalance > 2) {
            System.out.println("Provide initial balance?");
            System.out.println("1: Yes");
            System.out.println("2: No");
            try {
                userInputBalance = getUserInputInt();
            } catch (Exception e) {
                printInvalidInputMessage();
                createAccount();
            }
            System.out.println();

            switch (userInputBalance) {
                case 1:
                    providedInitialBalance = true;
                    break;
                case 2:
                    providedInitialBalance = false;
                    break;
                default:
                    printInvalidInputMessage();
                    break;
            }
        }
        return providedInitialBalance;
    }

    private double setInitialBalance() {
        double initialBalance = 0;
        System.out.println("Deposit initial balance (max $25,000)");
        System.out.print("$");
        try {
            initialBalance = Main.truncateToTwoDecimalPlaces(getUserInputDouble());
        } catch (Exception e) {
            printInvalidInputMessage();
            createAccount();
        }
        System.out.println();
        return initialBalance;
    }

    private void logout() {
        System.out.println("You are now logged out");
        System.out.println();
        displayWelcome();
    }

    private void displaySelectedAccountOptions() {
        System.out.println("Available Options:");
        System.out.println("1: Get Available Balance");
        System.out.println("2: Deposit Money Into Account");
        System.out.println("3: Withdraw Money From Account");
        System.out.println("4: Transfer Money to Another Account");
        System.out.println("5: View Transaction History");
        System.out.println("6: Close Account");
        System.out.println("7: Back to Select or Create Account");
        System.out.println("8: Logout");
        int userInput = 1;
        try {
            userInput = getUserInputInt();
        } catch (Exception e) {
            printInvalidInputMessage();
            displaySelectedAccountOptions();
        }
        System.out.println();
        if(userInput < 7) {
            System.out.println(currentAccount.getAccountType() + " Available balance: "
                    + String.format("$%.2f", currentAccount.getBalance()) + " Account number: "
                    + currentAccount.getAccountNumber());
            System.out.println();
        }
        switch (userInput) {
            case 1:
                displayBalance();
                break;
            case 2:
                depositToAccount();
                break;
            case 3:
                withdrawFromAccount();
                break;
            case 4:
                transferToOtherAccount();
                break;
            case 5:
                printTransactionHistory();
                break;
            case 6:
                closeCurrentAccount();
                break;
            case 7:
                displayAvailableOptions();
                break;
            case 8:
                logout();
                break;
            default:
                printInvalidInputMessage();
                displaySelectedAccountOptions();
                break;
        }
    }

    private void displayBalance() {
        System.out.println("The current balance of this account is " + String.format("$%.2f",currentAccount.getBalance()));
        System.out.println();
        displaySelectedAccountOptions();
    }

    private void depositToAccount() {
        System.out.println("How much would you like to deposit? (Max $25,000)");
        System.out.print("$");
        double userInput = 0;
        try {
            userInput = getUserInputDouble();
        } catch (Exception e) {
            printInvalidInputMessage();
            depositToAccount();
        }
        System.out.println();
        boolean depositedCorrectly = currentAccount.deposit(userInput);
        if(depositedCorrectly) {
            System.out.println("Thank you for your deposit");
        }
        else {
            System.out.println("Sorry, unable to deposit");
        }
        System.out.println();
        displaySelectedAccountOptions();
    }

    private void withdrawFromAccount() {
        System.out.println("How much would you like to withdraw? (Max $25,000)");
        System.out.print("$");
        double userInput = 0;
        try {
            userInput = getUserInputDouble();
        } catch (Exception e) {
            printInvalidInputMessage();
            withdrawFromAccount();
        }
        System.out.println();
        boolean withdrewCorrectly = currentAccount.withdraw(userInput);
        if(withdrewCorrectly) {
            System.out.println("Thank you for your withdrawal");
        }
        else {
            System.out.println("Sorry, unable to withdraw");
        }
        System.out.println();
        displaySelectedAccountOptions();

    }

    private void transferToOtherAccount() {
        if(currentUser.getAccounts().size() > 1) {
            Account chosenAccount = selectAvailableTransferAccount();
            System.out.println("How much would you like to transfer to the account?");
            System.out.print("$");
            double userInputAmount = 0;
            try {
                userInputAmount = getUserInputDouble();
            } catch (Exception e) {
                printInvalidInputMessage();
                transferToOtherAccount();
            }
            System.out.println();
            boolean transferredCorrectly = currentAccount.transferTo(chosenAccount, userInputAmount);
            if(transferredCorrectly) {
                System.out.println("Thank you for your transfer");
            }
            else {
                System.out.println("Sorry, unable to transfer");
            }
        }
        else {
            System.out.println("Sorry, no available accounts to transfer to");
        }
        System.out.println();
        displaySelectedAccountOptions();

    }

    private Account selectAvailableTransferAccount() {
        System.out.println("Your available accounts to transfer to are below, please select the account");
        int index = 1;
        int currentAccountIndex = 1;
        for (Account account : currentUser.getAccounts()) {
            if (!account.equals(currentAccount)) {
                System.out.println(index + ": " + account.getAccountType() + " Available balance: "
                        + String.format("$%.2f", account.getBalance()) + " Account number: " + account.getAccountNumber());
                index++;
            }
            else {
                currentAccountIndex = index;
            }
        }
        int userInput = 1;
        try {
            userInput = getUserInputInt();
        } catch (Exception e) {
            printInvalidInputMessage();
            transferToOtherAccount();
        }
        System.out.println();
        Account chosenAccount;
        if(userInput < currentAccountIndex) {
            chosenAccount = currentUser.getAccounts().get(userInput - 1);
        }
        else {
            chosenAccount = currentUser.getAccounts().get(userInput);
        }

        return chosenAccount;
    }

    private void printTransactionHistory() {
        System.out.println(currentAccount.formatTransactionHistory());
        displaySelectedAccountOptions();
    }

    private void closeCurrentAccount() {
        boolean closedCorrectly = currentUser.closeAccount(currentAccount);
        if(closedCorrectly) {
            System.out.println("Account successfully closed");
            System.out.println();
            displayAvailableOptions();
        }
        else {
            System.out.println("Sorry, unable to close account");
            System.out.println();
            displaySelectedAccountOptions();
        }
    }

    private int getUserInputInt() {
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        return choice;
    }

    private double getUserInputDouble() {
        Scanner scan = new Scanner(System.in);
        double input = scan.nextDouble();
        return input;
    }

    private String getUserInputString() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }

    private static void printInvalidInputMessage() {
        System.out.println();
        System.out.println("Invalid input");
        System.out.println();
    }
}
