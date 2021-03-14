import java.util.Scanner;

public class ATM {

    private Console c;
    private Integer userInput;
    private LogInScreen ls;
    private boolean loggedIn;
    private String currentUser;

    public ATM () {
        this.c = new Console();
        this.ls = new LogInScreen();
        this.loggedIn = false;
        this.currentUser = "";
    }

    public void printMenus() {

        while(true) {
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
            default:
                System.out.println("Invalid input. Please select either 1 or 2.");
        }
    }

    public void printUserMenu() {
        System.out.println("WELCOME " + this.currentUser);
        System.out.println("USER MENU");
        System.out.println("1 - LogOut");

        this.userInput = c.getIntegerInput();

        switch (userInput) {
            case 1:
                this.loggedIn = false;
                this.currentUser = "";
                this.printWelcomeMenu();
                break;
            default:
                System.out.println("Invalid input. Please select one of the listed options.");
                break;
            }
        }
}


