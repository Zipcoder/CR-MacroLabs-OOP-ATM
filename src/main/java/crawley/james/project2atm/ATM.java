package crawley.james.project2atm;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class ATM {

    private int accountNumCounter = 1;
    private int customerIDCounter = 1;
    private UserInputHandler userInputHandler = new UserInputHandler();
    private Display display = new Display();
    private int currentUser;
    private boolean running = true;
    private boolean loggedIn = false;
    private AccountManager accountManager = new AccountManager();
    private TransactionManager transactionManager = new TransactionManager();
    private CustomerManager customerManager = new CustomerManager();

    public void startATM () {

        while (running) {

            display.printWelcomeScreen();

            switch (userInputHandler.getUserInt()) {

                case 1:

                    display.printNewCustomerMenu();
                    String name = userInputHandler.getUserString() + userInputHandler.getUserString();
                    createCustomer(name , getValidUserInt());
                    break;

                case 2:
                    display.printLogin();
                    loginUserIfValidInfo();
                    break;
                case 3:

                    running = false;
                    break;
                default:
                    display.printOptionErrorMessage();

            }
        }

    }

    public void accessServices () {

        while (loggedIn) {
            display.printReturningCustomerMenu();
            switch (getValidUserInt()) {
                case 1:
                    accountTypeOptions();
                    break;
                case 2:
                    display.closeAccountPrompt();
                    closeAccount(getValidUserInt(), currentUser);
                    break;
                case 3:
                    display.transactionPrompt("deposit");
                    deposit(getValidUserInt(), getValidUserDouble());
                    break;
                case 4:
                    display.transactionPrompt("withdrawal");
                    withdrawals(getValidUserInt(), getValidUserDouble());
                    break;
                case 5:
                    display.transactionPrompt();
                    transfer(getValidUserInt(), getValidUserInt(), getValidUserDouble());
                    break;
                case 6:
                    transactions();
                    break;
                case 7:
                    loggedIn = false;
                    currentUser = 0;
                    break;
                default:
                    display.printOptionErrorMessage();
            }
        }

    }

    public void accountTypeOptions () {

        Account.AccountType accountType = null;

        while (accountType == null) {
            display.printAccountTypeOptions();
            switch (getValidUserInt()) {

                case 1:
                    accountType = Account.AccountType.CHECKING;
                    break;
                case 2:
                    accountType = Account.AccountType.SAVINGS;
                    break;
                case 3:
                    accountType = Account.AccountType.INVESTMENT;
                    break;
                default:
                    display.printOptionErrorMessage();
            }
        }

        display.createAccountPrompt();
        createAccount(accountType, currentUser, accountNumCounter, getValidUserDouble());
        display.printSuccessfulCreation("Account", accountNumCounter);
        accountNumCounter++;
    }

    public boolean verifyLoginInfo (int customerID, int pin) {

        if (customerManager.getCustomer(customerID).getPin() == pin) {

            loggedIn = true;
            return true;

        } else {

            return false;
        }

    }

    public void createCustomer (String name, int pin) {

        customerManager.addCustomer(name, pin, customerIDCounter);
        display.printSuccessfulCreation("Customer", customerIDCounter);
        customerIDCounter++;

    }

    public void createAccount (Account.AccountType accountType, int customerID, int accountNumber ,double amount) {

        accountManager.addAccount(accountType, amount, customerID, accountNumber);
        display.transactionSuccessMessage(getUserBalance(accountNumber));

    }

    public void closeAccount (int accountNumber, int customerID) {

        int closedMessageCase = 0;

        if (!isRealAccount(accountNumber)) {

            closedMessageCase = 1;

        } else if (isAccountBalanceZero(accountNumber, customerID)) {

            accountManager.deleteAccount(accountNumber, customerID);
            closedMessageCase = 2;
        }

        display.closeAccountMessage(closedMessageCase);
    }

    public boolean isAccountBalanceZero (int accountNumber, int customerID) {

        if (accountManager.getAccount(accountNumber, customerID).getBalance() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void withdrawals (int accountNumber, double amount) {

        if (isRealAccount(accountNumber)) {
            setUserBalance(getUserBalance(accountNumber) - amount, accountNumber);
            transactionManager.addTransaction(Transaction.TransactionType.WITHDRAWAL, currentUser, accountNumber, amount);
            display.transactionSuccessMessage(getUserBalance(accountNumber));
        } else {

            display.transactionErrorMessage();
        }

    }

    public void deposit (int accountNumber, double amount) {

        if (isRealAccount(accountNumber)) {
            setUserBalance(getUserBalance(accountNumber) + amount, accountNumber);
            transactionManager.addTransaction(Transaction.TransactionType.DEPOSIT, currentUser, accountNumber, amount);
            display.transactionSuccessMessage(getUserBalance(accountNumber));
        } else {

            display.transactionErrorMessage();
        }

    }

    public void transfer (int fromAccountNumber, int toAccountNumber, double amount) {

        if (isRealAccount(fromAccountNumber) && isRealAccount(toAccountNumber)) {
            withdrawals(fromAccountNumber, amount);
            deposit(toAccountNumber, amount);
            transactionManager.addTransaction(currentUser, fromAccountNumber, toAccountNumber, amount);
            display.transactionSuccessMessage(getUserBalance(fromAccountNumber));
        } else {
            display.transactionErrorMessage();
        }
    }

    public void transactions () {

        transactionManager.printTransactions(currentUser);

    }

    public AccountManager getAccountManager () {

        return accountManager;
    }

    public CustomerManager getCustomerManager () {

        return customerManager;

    }

    public TransactionManager getTransactionManager () {

        return transactionManager;

    }

    public void setCurrentUser (int currentUser) {

        this.currentUser = currentUser;
    }

    private double getUserBalance (int accountNumber) {

        return accountManager.getAccount(accountNumber, currentUser).getBalance();

    }

    private void setUserBalance (double amount, int accountNumber) {
        accountManager.getAccount(accountNumber, currentUser).setBalance(amount);
    }

    private int getValidUserInt() {
        int val;

        do {
            val = userInputHandler.getUserInt();
        } while (val == 0);

        return val;
    }

    private double getValidUserDouble() {
        double val;

        do {
            val = userInputHandler.getUserDouble();
        } while (val == 0);

        return val;
    }

    private void loginUserIfValidInfo () {

        int customerID = getValidUserInt();

        if (verifyLoginInfo(customerID, getValidUserInt())) {
            currentUser = customerID;
            accessServices();
        } else {
            display.invalidLoginMessage();
        }

    }

    private boolean isRealAccount (int accountNumber) {

        if (accountManager.getAccount(accountNumber, currentUser) != null) {

            return true;

        } else {

            return false;
        }

    }

}
