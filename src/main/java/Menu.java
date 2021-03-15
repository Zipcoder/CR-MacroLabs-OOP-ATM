public class Menu {

    private UserAccount currentUser;
    private boolean loggedIn;
    private Console c;
    private UserManagement ls;
    private AccountTrans ae;

    public Menu() {
        this.c = new Console();
        this.ls = new UserManagement();
        this.ae = new AccountTrans();
        this.loggedIn = false;
        this.currentUser = null;
    }

    public void printMenus() {

        while (true) { // If user not logged in, show welcome menu
            if (this.loggedIn == false) {
                this.printWelcomeMenu();

            } else { // If user is logged in, show User menu
                this.printUserMenu();
            }
        }

    }

    public void printWelcomeMenu() {
        System.out.println("WELCOME TO THE BANK OF ZIP CODE");
        System.out.println("LOCATED IN WILMINGTON, DELAWARE");
        System.out.println("PRESS 1 TO LOGIN");
        System.out.println("PRESS 2 IF YOU ARE A NEW USER");

        Integer userInput;
        userInput = c.getIntegerInput();

        switch (userInput) {
            case 1: // LOGIN
                this.currentUser = ls.validateLoginCredentials();
                if (this.currentUser != null) {
                    this.loggedIn = true;
                }
                break;
            case 2: // CREATE NEW ACCOUNT
                this.currentUser = ls.createNewUserAccount();
                if (this.currentUser != null) {
                    this.loggedIn = true;
                }
                break;
            default:
                System.out.println("Invalid input. Please select either 1 or 2.");
        }
    }

    public void printUserMenu() {
        System.out.println("WELCOME " + this.currentUser.getUsername());
        System.out.println("USER MENU");
        System.out.println("0 - LogOut");
        System.out.println("1 - Deposit");
        System.out.println("2 - Withdraw");
        System.out.println("3 - Transfer Funds");
        System.out.println("4 - Check Balance");
        System.out.println("5 - Close Account");

        Integer userInput;
        userInput = c.getIntegerInput();

        switch (userInput) {
            case 0:
                this.loggedIn = false;
                this.currentUser = null;
                this.printWelcomeMenu();
                break;
            case 1: // Deposit
                this.ae.depositMoney(this.chooseAccount());
                break;
            case 2: // Withdraw
                this.ae.withdrawMoney(this.chooseAccount());
                break;
            case 3: // Transfer between accounts
                System.out.println("TRANSFER FROM ACCOUNT:");
                BankAccount transferFrom = chooseAccount();
                System.out.println("TRANSFER TO ACCOUNT:");
                BankAccount transferTo = chooseAccount();
                this.ae.transferMoney(transferFrom, transferTo);
                break;
            case 4: // Check Balance
                this.ae.checkBalance(this.currentUser);
                break;
            case 5: // Close Account
                this.ls.closeAccount();
                this.loggedIn = false;
                this.currentUser = null;
                this.printWelcomeMenu();
                break;
            default:
                System.out.println("Invalid input. Please select one of the listed options.");
                break;
        }
    }

    public BankAccount chooseAccount() {
        BankAccount currentAccount = null;
        System.out.println("Which Account would you like to use?");
        System.out.println("Press 0 to Log Out");
        System.out.println("Press 1 for Checking");
        System.out.println("Press 2 for Savings");
        System.out.println("Press 3 for Investment");

        Integer userInput = c.getIntegerInput();

        switch (userInput) {
            case 0: // Log out
                this.loggedIn = false;
                this.currentUser = null;
                this.printWelcomeMenu();
                break;
            case 1: // Choose checking
                currentAccount = this.currentUser.getCheckingAccount();
                break;
            case 2: // Choose savings
                currentAccount = this.currentUser.getSavingsAccount();
                break;
            case 3: // Choose Investments
                currentAccount= this.currentUser.getInvestmentAccount();
                break;
            default:
                System.out.println("Invalid input.");
                this.printUserMenu();
                break;
        }

        return currentAccount;
    }

}


