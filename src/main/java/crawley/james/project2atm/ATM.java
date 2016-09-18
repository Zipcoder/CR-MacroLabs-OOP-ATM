package crawley.james.project2atm;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class ATM {

//    private Transaction transaction;
//    private Customer customer;
//    private Account account;
    private UserInputHandler userInputHandler = new UserInputHandler();
    private Display display = new Display();
    private int currentUser;
    private boolean running = true;
    private AccountManager accountManager = new AccountManager();
    private TransactionManager transactionManager = new TransactionManager();
    private CustomerManager customerManager = new CustomerManager();

    public void accountTypeOptions () {
        switch (userInputHandler.getUserInt()) {

            case 1: break;
            case 2: break;
            case 3: break;
        }

    }

    public void createAccount (Account.AccountType accountType, int customerID, double amount) {

        accountManager.addAccount(accountType, amount, customerID);

    }

    public void createCustomer (String name, int pin) {

        customerManager.addCustomer(name, pin);
    }

    public void closeAccount (int accountNumber, int customerID) {

        if (isAccountBalanceZero(accountNumber, customerID)) {
            accountManager.deleteAccount(accountNumber, customerID);
        }

    }

    public void accessCustomerAccount () {

    }

    public void accessServices () {

    }

    public boolean isAccountBalanceZero (int accountNumber, int customerID) {

        if (accountManager.getAccount(accountNumber, customerID).getBalance() == 0) {
            return true;
        } else {
            return false;
        }
    }


    public void exitProgram () {

    }

    public void logIN () {

    }

    public void logOUT () {

    }

    public boolean verifyLoginInfo (int customerID, int pin) {

        if (customerManager.getCustomer(customerID).getPin() == pin) {

            return true;

        } else {

            return false;
        }

    }

    public void withdrawals (int accountNumber, double amount) {

        setUserBalance(getUserBalance(accountNumber) - amount, accountNumber);
        transactionManager.addTransaction(Transaction.TransactionType.WITHDRAWAL, currentUser, accountNumber, amount);

    }

    public void deposit (int accountNumber, double amount) {

        setUserBalance(getUserBalance(accountNumber) + amount, accountNumber);
        transactionManager.addTransaction(Transaction.TransactionType.DEPOSIT, currentUser, accountNumber, amount);

    }

    public void transfer (int fromAccountNumber, int toAccountNumber, double amount) {

        withdrawals(fromAccountNumber, amount);
        deposit(toAccountNumber, amount);
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

    public void startATM () {

        while (running) {

            display.printWelcomeScreen();

            switch (userInputHandler.getUserInt()) {

                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    running = false;
                    break;
            }
        }

    }

    private double getUserBalance (int accountNumber) {

        return accountManager.getAccount(accountNumber, currentUser).getBalance();

    }

    private void setUserBalance (double amount, int accountNumber) {
        accountManager.getAccount(accountNumber, currentUser).setBalance(amount);
    }


}
