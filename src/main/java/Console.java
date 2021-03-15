import java.util.Scanner;

public class Console {
    Main main = new Main();
    BreakCheck breakCheck = new BreakCheck();
    Scanner userInput = new Scanner(System.in);

    public void greetingMessage() throws InterruptedException {
        AsciiArtGenerator asciiGet = new AsciiArtGenerator();
        asciiGet.introMessage();
        //System.out.println("\n");
        System.out.println("Welcome to a real financial institution! \n");
    }

    // We will need a prompt to enter a PIN before anything else.
    // link to account object associated with pin in HashMap

    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public String customerPortal(/*String prompt*/) {
        System.out.println("Are you already an account holder at real financial institution?");
        System.out.println("1 - New Customer, 2 - Existing Customer, 3 - Exit");
        //getStringInput(prompt);
        String customerStatus = "";
        boolean invalidInput = true;
        while (invalidInput) {
            customerStatus = userInput.nextLine();
            switch (customerStatus) {
                case "1": {
                    main.newCustomer();
                    invalidInput = false;
                    break;
                }
                case "2": {
                    main.returningCustomer();
                    invalidInput = false;
                    break;
                }
                case "3": {
                    System.out.println("Thank you for choosing a real financial institution.");
                    System.exit(0);
                }
                default: {
                    System.out.println("Please choose from the menu.");
                    break;
                }
            }
        }
        return customerStatus;
    }


    //Simple user Interface
    public String chooseAccount() {
        String accountType = breakCheck.confirmIsNumber();
        System.out.println("You have chosen " + accountType);
        return accountType;
    }
// this will expand to include transfer and other method calls
    public void accountActions() {
        System.out.println("1 - Account Balance(s) 2 - Deposit, 3 - Withdraw, 4 - Transfer, 5 - Choose Account, " +
                "\n6 - Add Account, 7 - Close an Account, 8 - Transaction History\n" +
                " 9 - Return to Main Menu, 10 - Exit");

        String accountAction = "";
        boolean invalidInput = true;
        while (invalidInput) {
            accountAction = userInput.nextLine();
            switch (accountAction) {
                case "1": {
                    main.getAccountSummary();
                    break;
                }
                case "2": {
                    main.depositMade();
                    break;
                }
                case "3": {
                    main.withdrawMade();

                    break;
                }
                case "4": {
                    main.transferMade();
                    break;
                }
                case "5": {
                    main.chooseAccount();
                    break;
                }
                case "6": {
                    main.additionalAccount();
                    break;
                }
                case "7": {
                    main.closeAccount();
                    break;
                }
                case "8": {
                    main.getTransactionHistory();
                    break;
                }
                case "9": {
                    customerPortal();
                    break;
                }
                case "10": {
                    System.out.println("Thank you for choosing real financial institution.");
                    System.exit(0);
                }
                default: {
                    System.out.println("Please choose from the menu.");
                    break;
                }
            }
            accountActions();
        }
    }
}
