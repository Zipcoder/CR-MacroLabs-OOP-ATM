import java.io.IOException;

public class ATM {

    private User currentUser;
    private DB userDB;
    private DB transactionDB;
    private DB accountDB;

    public ATM() {
        this.currentUser = null;
        try {
            this.userDB = new DB("users.csv", 5);
            this.transactionDB = new DB("transactions.csv", 5);
            this.accountDB = new DB("accounts.csv", 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public DB getUserDB() {
        return userDB;
    }

    public DB getTransactionDB() {
        return transactionDB;
    }

    public DB getAccountDB() {
        return accountDB;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User authenticate(int cardNumber, String password) {
        return new User();
    }

    public void logOut (User currentUser) {

    }

    // log in user
    public void getUser() {
        // find user in DB

        // check PW

        // instantiate user

    }

    // add new user - called by getUser()
    public User newUser() {
        return null;
    }


    // load database info from disk
    public void loadDBs() {

    }

    // deal with the user's choices
    public void userMenu() {

    }

    // log out user
    public void logOut() {

    }

    // save DBs to disk
    public void saveDBs() {

    }

    public void serviceLoop() {

        // authenticate a user (or die trying)
        // only returns null if the magic secret exit code is called
        getUser();
        if (this.currentUser == null) { return; }

        loadDBs();

        userMenu();

        logOut();

        saveDBs();

        serviceLoop();
    }
}
