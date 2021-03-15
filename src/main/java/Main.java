import java.util.Scanner;

/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {
    AtmEngine atmEngine = new AtmEngine();
    BreakCheck newCheck = new BreakCheck();
    Scanner userInput = new Scanner(System.in);
    String pin = "";
    Integer currentAccount = 0;

    public static void main(String[] args) throws InterruptedException {
        // build instance of AtmEngine and call that in the
        // instance in the console methods
        Console consoleOut = new Console();
        consoleOut.greetingMessage();
        consoleOut.customerPortal();
        //consoleOut.chooseAccount();
        consoleOut.accountActions();
    }

    public void newCustomer() {

        System.out.println("What type of account would you like to open?");
        String accountType = newCheck.confirmIsNumber();
        System.out.println("What is your initial deposit?");
        Double initialDeposit = newCheck.isDouble();
        pin = newCheck.pinGenerator();
        if(atmEngine.userExists(pin)){
            pin = newCheck.pinGenerator();
        }
        System.out.println("Your new pin is: " + pin);
        Account account = new Account(initialDeposit,accountType);
        atmEngine.addNewAccount(pin, account);
        atmEngine.printAllAccounts(pin);
        currentAccount = 0;
    }

    public void getAccountSummary(){
        atmEngine.printAllAccounts(pin);
    }

    public void depositMade() {
        System.out.print("Amount to be deposited: ");
        Double amount = newCheck.isDouble();
        atmEngine.depositCash(this.pin, currentAccount, amount);
        atmEngine.printAllAccounts(pin);
    }

    public void withdrawMade() {
        System.out.print("Amount to be withdrawn: ");
        Double amount = newCheck.isDouble();
        atmEngine.withdrawCash(pin, currentAccount, amount);
        atmEngine.printAllAccounts(pin);
    }

    public void transferMade() {
        System.out.println("Pull funds from?");
        Integer accountFrom = newCheck.isInteger();
        while (accountFrom > atmEngine.sizeOfAccountList(pin)) {
            System.out.println("Sorry that account is not in our system. Try again:");
            accountFrom = newCheck.isInteger();
        }

        System.out.println("Move funds to?");
        Integer accountTo = newCheck.isInteger();
        while (accountTo > atmEngine.sizeOfAccountList(pin)) {
            System.out.println("Sorry that account is not in our system. Try again:");
            accountTo = newCheck.isInteger();
        }

        System.out.println("Amount to be transferred?");
        Double amount = newCheck.isDouble();

        atmEngine.transfer(this.pin, accountFrom - 1, accountTo - 1, amount);
        atmEngine.printAllAccounts(pin);
    }

    public void chooseAccount() {
        atmEngine.printAllAccounts(pin);
        System.out.println("Choose an account:");
        Integer accountToAccess = newCheck.isInteger();;

        while (accountToAccess > atmEngine.sizeOfAccountList(pin)) {
            System.out.println("Sorry that account is not in our system. Try again:");
            accountToAccess = newCheck.isInteger();
        }
        currentAccount = accountToAccess - 1;
    }

    public void additionalAccount() {
        System.out.println("What type of account would you like to add?");
        String additionalAccountType = newCheck.confirmIsNumber();;
        System.out.println("What is your initial deposit?");
        Double initialDeposit = newCheck.isDouble();
        Account account = new Account(initialDeposit,additionalAccountType);
        atmEngine.addNewAccount(pin, account);
        atmEngine.printAllAccounts(pin);
    }

    public void closeAccount() {
        atmEngine.printAllAccounts(pin);
        System.out.println("Accounts must be empty to close. Make transfers first if necessary.");
        System.out.println("Which account would you like to close?");
        Integer accountToClose = newCheck.isInteger();;
        atmEngine.closeAccount(pin,accountToClose - 1);


    }

    public void returningCustomer() {
        System.out.println("Please enter your PIN: ");
        String returningPin = "";
        returningPin = userInput.nextLine();
        int counter = 5;
        while (!atmEngine.userExists(returningPin) && counter > 0) {
            System.out.println("Sorry that PIN is not in our system.");
            returningPin = userInput.nextLine();
            counter--;
        }
        if (counter == 0) {

            System.out.println("Suspicious activity. ATM powering down.");
            System.exit(0);
        }
        pin = returningPin;
    }

    public void getTransactionHistory() {
        System.out.println("Select one of your accounts.");
        Integer accountSelection = newCheck.isInteger();

        atmEngine.showAccountTransactions(pin, accountSelection-1);
    }
}
