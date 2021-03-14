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

7. Do we need to set up a get password method?
8. Do we need a getter for Accounts[] array of user's accounts?
9. ***** Do we need to use a map for username and passwords? ****
10. Help with syntax for the add/remove functions of user's account array
11. Help with syntax for the get accounts array
12. need console class? manages console interactions. Create a console mock for testing
        (provide scripted user input using this object)
13. persistence = the Dikstra 2 stack algorithm - implement?
14. users are authenticated with a password - generated or provided on user creation?
    generated password created with default constructor?

 */


public class User {

    private String username;
    private String password;  // *** access modifier for this??? if private, do we need a getter for this?
    //public Account[] accounts;


    // CONSTRUCTORS

    // default constructor
    public User() {                           // <- should this constructor set up an Accounts[] array to an empty array of n length?
        //Account[] accounts = new Account[3]; // <- length of array?


    }

    // Constructor for user with name & password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Constructor for user with name, password, and account
    //public User(String username, String password Account[] accounts) {
        //this.username = username;
        //this.password = password;
        //this.accounts = accounts;

    //}

/*
    // METHODS

        // sets userName if none assigned at construction, else resets username
    public void setUsername(String username) {

        this.username = username;
    }

        // sets password if none assigned at construction, else resets password
    public void setPassword(String password) {    // *** access modifier for this???
        this.password = password;

    }

            // returns username as string
    public String getUsername() {

        return username;
    }

        // returns password as string
        public String getPassword() {  // *** access modifier?

        return password;
    }

        // adds new account to end of user's account array
    public void addAccount(Account[] accounts, Account accountToAdd) {
        int i = 0;
        for (Account[] element : accounts) {
            if (element[i] == null) {
                element[i] += accountToAdd;     // **** HELP W THE SYNTAX OF THIS METHOD ***
            }  i++;
        }
    }

        // removes specified account from user's account array, replaces space in index with null
    public void removeAccount(Account[] accounts, Account accountToRemove) {
        int i = 0;
        for (Account[] element : accounts) {    // for each element in the User's array of their accounts,
                                                // check to see if the value at i is equal to the account to remove
            if (element[i] == accountToRemove) {   // if the value at accounts[i] is equal to the account to remove,
                element[i] = null;                 // replace the value at accounts[i] with null
            }   i++;
        }
    }

        // returns accounts, prints accounts array to string
    public Account[] getAccounts() {
        System.out.println(accounts.toString);  // double check syntax on this one?
        return accounts;
    }

*/
}




