
/*
Questions:
1. instance field password - access modifier for this private? if private, do we need a getter for this?
2. Constructors -
        2.1 a constructor that sets up a user with just their userName & password.. can make a user and not
        necessarily need to assign them an account right away.
        2.2 should default constructor create empty accounts array of specified length? what would be the use
        in that?
3. exceptions - how to set up? intelliJ interface different from the images from Dolio
4. JUnit testing - how to configure?
5. Do we need to set up an account number that has a limit on length? uniformity with account number properties? account number as int data type?
6. Is the return of username a string?
7. Do we need to set up a get password method?
8. Do we need a getter for Accounts[] array of user's accounts?
9. ***** Do we need to use a map for username and passwords? ****

 */








public class User {

    public String userName;
    private String passWord;  // *** access modifier for this??? if private, do we need a getter for this?
    public Account[] accounts;


    // CONSTRUCTORS

    // default constructor
    public User() {                           // <- should this constructor set up an Accounts[] array to an empty array of n length?
        Account[] accounts = new Account[30]; // <- length of array?


    }

    // Constructor for user with name & password
    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    // Constructor for user with name, password, and account
    public User(String userName, String passWord, Account[] accounts) {
        this.userName = userName;
        this.passWord = passWord;
        this.accounts = accounts;

    }


    // METHODS

        // sets userName if none assigned at construction, else resets username
    public void setUserName() {
        this.userName = userName;
    }

        // sets password if none assigned at construction, else resets password
    private void setPassWord() {    // *** access modifier for this???
        this.passWord = passWord;
    }

            // returns username as string
    public String getUserName() {  // *** return type for this?
        return userName;
    }

        // returns password as string
    private String getPassWord() {  // *** access modifier?
        return passWord;
    }

        // adds account to end of user's account array
    public void addAccount(Account[] account, accountNumber) {
        for (Account[] element : accounts) {
            int i = 0;
            if (accounts[i] == null) {
                accounts += accountNumber;
            }
        }
    }

        // removes account from specified index of user's account array
    public void removeAccount(int accountNumber) {}

    public Account[] getAccounts() {
        return accounts;
    }


}



