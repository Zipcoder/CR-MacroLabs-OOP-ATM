public class Menu {

    private Console c;
    private Integer userInput;
    private UserManagement ls;
    private boolean loggedIn;
    private String currentUser;

    public Menu() {
        this.c = new Console();
        this.ls = new UserManagement();
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
        System.out.println("0 - LogOut");
        System.out.println("1 - Withdraw");
        System.out.println("2 - Transfer Funds");
        System.out.println("3 - Check Balance");

        this.userInput = c.getIntegerInput();

        switch (userInput) {
            case 0:
                this.loggedIn = false;
                this.currentUser = "";
                this.printWelcomeMenu();
                break;
            case 1:

            default:
                System.out.println("Invalid input. Please select one of the listed options.");
                break;
            }
        }
}


