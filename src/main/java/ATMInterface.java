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
        int userInput = 1;
        try {
            userInput = getUserInputInt();
        } catch (Exception e) {
            System.out.println();
            System.out.println("Invalid input");
            System.out.println();
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
                break;
            default:
                System.out.println("Invalid input");
                System.out.println();
                newUserOrLogin();
                break;
        }

    }

    private void newUser() {
        System.out.println("Enter your preferred password:");
        String password = "";
        try {
            password = getUserInputString();
        } catch (Exception e) {
            System.out.println();
            System.out.println("Invalid input");
            System.out.println();
            newUser();
        }
        System.out.println();
        User newUser = new User(password);
        UserWarehouse.addUser(newUser);
        currentUser = newUser;
        System.out.printf("Verified User %d is now logged in\n", newUser.getUserID());
        System.out.println();
        displayAvailableOptions();
    }

    private void login() {
        System.out.println("Login screen");
        System.out.println("Enter user ID");
        int userID = 1;
        try {
            userID = getUserInputInt();
        } catch (Exception e) {
            System.out.println();
            System.out.println("Invalid input");
            System.out.println();
            login();
        }
        System.out.println();
        User userAtLogin = UserWarehouse.returnUserFromID(userID);
        if(userAtLogin != null) {
            System.out.println("Enter password");
            String inputPassword = "";
            try {
                inputPassword = getUserInputString();
            } catch (Exception e) {
                System.out.println();
                System.out.println("Invalid input");
                System.out.println();
                login();
            }
            System.out.println();
            if(userAtLogin.isCorrectPassword(inputPassword)) {
                System.out.printf("Verified User %d is now logged in\n", userID);
                System.out.println();
                currentUser = userAtLogin;
            }
            displayAvailableOptions();
        }
        else {
            System.out.println("User does not exist");
            System.out.println();
            newUserOrLogin();
        }
    }

    private void displayAvailableOptions() {
        System.out.println("Available Options:");
        System.out.println("1: Select Account");
        System.out.println("2: Create Account");
        System.out.println("3: Logout");
        int userInput = 1;
        try {
            userInput = getUserInputInt();
        } catch (Exception e) {
            System.out.println();
            System.out.println("Invalid input");
            System.out.println();
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
                System.out.println("Invalid input");
                System.out.println();
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
                System.out.println();
                System.out.println("Invalid input");
                System.out.println();
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
                    System.out.println("Invalid input");
                    System.out.println();
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
                System.out.println();
                System.out.println("Invalid input");
                System.out.println();
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
        System.out.println("What type of account would you like to create?");
        System.out.println("1: " + AccountType.CHECKING);
        System.out.println("2: " + AccountType.SAVINGS);
        System.out.println("3: " + AccountType.INVESTMENT);
        int userInput = 1;
        try {
            userInput = getUserInputInt();
        } catch (Exception e) {
            System.out.println();
            System.out.println("Invalid input");
            System.out.println();
            createAccount();
        }
        System.out.println();

        Account newAccount = new Checking();
        System.out.println("Provide initial balance?");
        System.out.println("1: Yes");
        System.out.println("2: No");
        int userInputBalance = 1;
        try {
            userInputBalance = getUserInputInt();
        } catch (Exception e) {
            System.out.println();
            System.out.println("Invalid input");
            System.out.println();
            createAccount();
        }
        System.out.println();

        double userInputInitBalance = 0;
        if(userInputBalance == 1) {
            System.out.println("Deposit initial balance");
            System.out.print("$");
            try {
                userInputInitBalance = Main.truncateToTwoDecimalPlaces(getUserInputDouble());
            } catch (Exception e) {
                System.out.println();
                System.out.println("Invalid input");
                System.out.println();
                createAccount();
            }
            System.out.println();
        }
        else {
            userInputInitBalance = 0;
        }
        switch (userInput) {
            case 1:
                newAccount = new Checking(userInputInitBalance);
                break;
            case 2:
                newAccount = new Savings(userInputInitBalance);
                break;
            case 3:
                newAccount = new Investment(userInputInitBalance);
                break;
            default:
                System.out.println("Invalid input");
                System.out.println();
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
            System.out.println();
            System.out.println("Invalid input");
            System.out.println();
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
                System.out.println("Invalid input");
                System.out.println();
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
        System.out.println("How much would you like to deposit?");
        System.out.print("$");
        double userInput = 0;
        try {
            userInput = getUserInputDouble();
        } catch (Exception e) {
            System.out.println();
            System.out.println("Invalid input");
            System.out.println();
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
        System.out.println("How much would you like to withdraw?");
        System.out.print("$");
        double userInput = 0;
        try {
            userInput = getUserInputDouble();
        } catch (Exception e) {
            System.out.println();
            System.out.println("Invalid input");
            System.out.println();
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
                System.out.println();
                System.out.println("Invalid input");
                System.out.println();
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
            System.out.println("How much would you like to transfer to the account?");
            System.out.print("$");
            double userInputAmount = 0;
            try {
                userInputAmount = getUserInputDouble();
            } catch (Exception e) {
                System.out.println();
                System.out.println("Invalid input");
                System.out.println();
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

    private void printTransactionHistory() {
        System.out.println(currentAccount.formatTransactionHistory());
        displaySelectedAccountOptions();
    }

    private void closeCurrentAccount() {
        boolean closedCorrectly = currentUser.closeAccount(currentAccount);
        if(closedCorrectly) {
            System.out.println("Account successfully closed");
        }
        else {
            System.out.println("Sorry, unable to close account");
        }
        System.out.println();
        displayAvailableOptions();
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

}
