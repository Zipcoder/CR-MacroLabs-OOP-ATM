import java.util.Scanner;

public class Menu {

    private Console c;
    private Integer userInput;
    private UserManagement ls;
    private boolean loggedIn;
    private String currentUser;
    private Account userAccount;

    public Menu() {
        this.c = new Console();
        this.ls = new UserManagement();
        this.loggedIn = false;
        this.currentUser = "";
        this.userAccount = new Account();
    }

    public void printMenus() {

        while (true) {
            if (this.loggedIn == false) {
                this.printWelcomeMenu();

            } else {
                this.printUserMenu();
            }
        }

    }

    public void printWelcomeMenu() {
        System.out.println("WELCOME TO THE BANK OF ZIP CODE");
        System.out.println("LOCATED IN WILMINGTON, DELAWARE");
        System.out.println("PRESS 1 TO LOGIN");
        System.out.println("PRESS 2 IF YOU ARE A NEW USER");

        this.userInput = c.getIntegerInput();

        switch (userInput) {
            case 1:
                this.loggedIn = ls.validateLoginCredentials();
                this.currentUser = ls.getEnteredUserName();
                break;
            case 2:
                this.loggedIn = ls.createNewUserAccount();
                this.currentUser = ls.getEnteredUserName();
                break;
            case 3:

            default:
                System.out.println("Invalid input. Please select either 1 or 2.");
        }
    }

    public void printUserMenu() {
        System.out.println("WELCOME " + this.currentUser);
        System.out.println("USER MENU");
        System.out.println("0 - LogOut");
        System.out.println("1 - Deposit");
        System.out.println("2 - Withdraw");
        System.out.println("3 - Transfer Funds");
        System.out.println("4 - Check Balance");

        this.userInput = c.getIntegerInput();

        switch (userInput) {
            case 0:
                this.loggedIn = false;
                this.currentUser = "";
                this.printWelcomeMenu();
                break;
            case 1:
                this.userAccount.depositMoney();
                break;
            case 2:
                this.userAccount.withdrawMoney();
                break;
            case 3:
                this.userAccount.transferMoney();
                break;
            case 4:
                this.userAccount.checkBalance();
                break;
            default:
                System.out.println("Invalid input. Please select one of the listed options.");
                break;
        }
    }
}


