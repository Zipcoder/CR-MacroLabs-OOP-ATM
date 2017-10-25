import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    ATM atm = ATM.getInstance();
    Scanner scan = new Scanner(System.in);

    void frontPage() {
        System.out.print("\nWelcome\n 1) New User\n 2) Login\n 0) Exit\n");
        switch (catchIntErrorInput()) {
            case 1:
                addUser();
                break;
            case 2:
                loginPage();
                break;
            case 0:
                return;
            default:
                System.out.println("Not a valid input");
                frontPage();
        }
    }

    private void userPage(User user) {
        System.out.print(
                "\n 1) Check balance of account\n 2) Withdraw from account\n 3) Deposit to account" +
                        "\n 4) Transfer from one account to another\n 5) Print account transaction history" +
                        "\n 6) Close account\n 7) Add new account\n 8) User settings\n 0) Logout\n");
        switch (catchIntErrorInput()) {
            case 1:
                balancePrint(user);
                break;
            case 2:
                withdrawPrint(user);
                break;
            case 3:
                depositPrint(user);
                break;
            case 4:
                transferPrint(user);
                break;
            case 5:
                historyPrint(user);
                break;
            case 6:
                closeAccount(user);
                break;
            case 7:
                addAccount(user);
                break;
            case 8:
                userSettingPage(user);
                break;
            case 0:
                frontPage();
                break;
            default:
                userPage(user);
        }
    }

    private void userSettingPage(User user) {
        System.out.println("\nUser Settings\n 1) Change user name\n 2) Change password\n 3) Look at all accounts\n 0) Back");
        switch (catchIntErrorInput()) {
            case 1:
                changeUserNamePage(user);
                break;
            case 2:
                changePasswordPage(user);
                break;
            case 3:
                printAccounts(user);
                break;
            case 0:
                userPage(user);
                break;
            default:
                userSettingPage(user);
        }
    }

    private void transferPrint(User user) {
        System.out.println("Transfer funds\n 1) Transfer to own account\n 2) Transfer to other users account\n 0) Back");
        switch (catchIntErrorInput()) {
            case 1:
                selfTransfer(user);
                break;
            case 2:
                otherUserTransfer(user);
                break;
            case 0:
                userPage(user);
                break;
            default:
                transferPrint(user);
        }
    }

    private void addAccount(User user) {
        System.out.print("What type of account?\n 1) Checking\n 2) Savings\n 3) Investment\n");
        String accountType;
        switch (catchIntErrorInput()) {
            case 1:
                accountType = "Checking  ";
                break;
            case 2:
                accountType = "Savings   ";
                break;
            case 3:
                accountType = "Investment";
                break;
            case 0:
                userPage(user);
            default:
                addAccount(user);
                accountType = "x";
        }
        if (!"x".equals(accountType)) {
            int accountNum = user.addAccount(accountType);
            System.out.print("\nAccount added\n\nNew account number : " + accountNum + "\n");
        }
        userPage(user);
    }

    private int catchIntErrorInput() {
        int output = -1;
        while(output<0) {
            String input = scan.next();
            try {
                output = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        return output;
    }

    private double catchDoubleErrorInput() {
        double output = -1;
        while(output<0) {
            String input = scan.next();
            try {
                output = Double.parseDouble(input);
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        return output;
    }

    private void printAccounts(User user) {
        ArrayList accounts = user.getAccountsArray();
        for (Object account : accounts) {
            printAccountInfo((Account) account);
        }
        userSettingPage(user);
    }

    private void printAccountInfo(Account account) {
        String accountType = account.getAccountType();
        int accountNum = account.getAccountNum();
        double accountBalance = account.getBalance();
        System.out.println("Account type : " + accountType + "\tAccount number : " + accountNum + "\t\tAccount balance\t: " + accountBalance);
    }

    private void historyPrint(User user) {
        Account account = enterAccount(user);
        ArrayList history = account.getAccountHistory();
        System.out.println("Most recent at the bottom");
        for (Object transaction : history) {
            System.out.println((String) transaction);
        }
        userPage(user);
    }

    private void otherUserTransfer(User user) {
        System.out.println("From account");
        Account fromAccount = enterAccount(user);
        System.out.println("User to transfer to");
        User toUser = enterUser();
        Account toAccount = enterAccount(toUser);
        System.out.print("How mush would you like to transfer >> ");
        double amount = catchDoubleErrorInput();
        if (user.withdraw(amount, fromAccount) && toUser.deposit(amount, toAccount)) {
            System.out.println("Transfer made");
        }
        userPage(user);
    }

    private User enterUser() {
        User toUser = null;
        System.out.print("User name >> ");
        String toUserString = scan.next();
        if (atm.UserExist(toUserString)) {
            toUser = atm.EnterUser(toUserString);
        }
        return toUser;
    }

    private void loginPage() {
        System.out.print("LOGIN PAGE\n");
        System.out.print("User Name >> ");
        String userName = scan.next();
        System.out.print("Password  >> ");
        String password = scan.next();
        if (atm.UserNameAndPasswordCorrect(userName, password)) {
            User user = atm.EnterUser(userName);
            System.out.println("\nWelcome back " + user.getUserName());
            userPage(user);
        } else {
            if (atm.UserExist(userName)) {
                System.out.print("Incorrect password\n");
            } else {
                System.out.print("User does not exist\n");
            }
            frontPage();
        }
    }


    private void selfTransfer(User user) {
        System.out.print("From account\n");
        Account fromAccount = enterAccount(user);
        System.out.print("To account\n");
        Account toAccount = enterAccount(user);
        System.out.print("How much would you like to transfer >> ");
        double amount = catchDoubleErrorInput();
        if (user.transfer(amount, fromAccount, toAccount)) {
            System.out.print("Transfer made\n");
            userPage(user);
        } else {
            System.out.print("Transfer not possible\n");
            userPage(user);
        }

    }


    private void changePasswordPage(User user) {
        System.out.print("Current password >> ");
        String input = scan.next();
        if (input.equalsIgnoreCase(user.getUserPassword())) {
            System.out.print("New password >> ");
            input = scan.next();
            user.setUserPassword(input);
            System.out.print("Password changed");
        } else {
            System.out.print("Incorrect password");
        }
        userSettingPage(user);
    }

    private void changeUserNamePage(User user) {
        System.out.print("Current user name >> ");
        String input = scan.next();
        if (input.equalsIgnoreCase(user.getUserName())) {
            System.out.print("New user name >> ");
            input = scan.next();
            user.setUserName(input);
            System.out.print("User name changed\n");
        } else {
            System.out.print("Incorrect user name");
        }
        userSettingPage(user);
    }

    private void closeAccount(User user) {
        Account account = enterAccount(user);
        if (user.removeAccount(account.getAccountNum())) {
            System.out.print("Account removed");
            userPage(user);
        } else {
            System.out.print("Account is not empty");
            userPage(user);
        }
    }


    private void depositPrint(User user) {
        Account account = enterAccount(user);
        System.out.print("Deposit amount  >> ");
        double amount = catchDoubleErrorInput();
        if (user.deposit(amount, account)) {
            System.out.print("Deposit made\n");
            userPage(user);
        } else {
            System.out.print("Deposit not possible\n");
            userPage(user);
        }
    }

    private void withdrawPrint(User user) {
        Account account = enterAccount(user);
        System.out.print("Withdraw amount >> ");
        double amount = catchDoubleErrorInput();
        if (user.withdraw(amount, account)) {
            System.out.print("Withdraw made\n");
            userPage(user);
        } else {
            System.out.print("Withdraw not possible\n");
            userPage(user);
        }
    }

    private void balancePrint(User user) {
        Account account = enterAccount(user);
        System.out.print("\nAccount : " + account.getAccountNum() + "\nBalance : " + account.getBalance() + "\n");
        userPage(user);
    }

    private Account enterAccount(User user) {
        System.out.print("Account number  >> ");
        int input = catchIntErrorInput();
        Account account;
        if (user.AccountExist(input)) {
            account = user.EnterAccount(input);
        } else {
            System.out.print("Account does not exist");
            account = null;
            userPage(user);
        }
        return account;
    }

    private void addUser() {
        System.out.print("New user Name >> ");
        String userName = scan.next();
        System.out.print("New password  >> ");
        String password = scan.next();
        if (atm.UserExist(userName)) {
            System.out.println("\nUser name already exist");
        } else {
            atm.addUser(userName, password);
            System.out.print("\nNew user added\n");
        }
        frontPage();
    }


}
