import java.util.HashMap;

public class UserManagement {

    Console c = new Console();
    private String enteredUserName;
    private String enteredPassword;
    private HashMap<String, String> userNamePasswordMap;
    private HashMap<String, UserAccount> userAccountsList;

    public UserManagement() {
        this.userNamePasswordMap = new HashMap<String, String>();
        this.userAccountsList = new HashMap<String, UserAccount>();
    }

    // Need this one for testing
    public UserManagement(String username, String password) {
        this.userNamePasswordMap = new HashMap<String, String>();
        this.userAccountsList = new HashMap<String, UserAccount>();
        this.enteredPassword = password;
        this.enteredUserName = username;
    }

    // Need this one for testing
    public HashMap getUserNamePasswordMap() {
        return this.userNamePasswordMap;
    }

    // Need this one for testing
    public HashMap getUserAccountsList() {
        return this.userAccountsList;
    }

    public void getInputUserName() {
        System.out.println("Username:");
        this.enteredUserName = c.getStringInput();
    }

    public void getInputPassword() {
        System.out.println("Password:");
        this.enteredPassword = c.getStringInput();
    }

    public boolean validateUserNameExists() {
        return this.userNamePasswordMap.containsKey(this.enteredUserName);
    }

    public boolean validatePasswordCorrect() {
        return this.userNamePasswordMap.get(this.enteredUserName).equals(this.enteredPassword);
    }

    public UserAccount validateLoginCredentials() {
        getInputUserName();
        getInputPassword();
        if(this.validateUserNameExists() == false) {
            System.out.println("No such user exists.");
        } else if (this.validatePasswordCorrect() == false) {
            System.out.println("Password is incorrect.");
        } else {
            System.out.println("You are now logged in.");
            return userAccountsList.get(this.enteredUserName);
        }

        return null;
    }

    public UserAccount createNewUserAccount() {
        System.out.println("Enter your new username and password.");
        getInputUserName();
        int attempts = 0;
        while (attempts < 3) {
            if (this.validateUserNameExists() == false) {
                getInputPassword();
                setUpUserAccount();
                System.out.println("Congratulations " + this.enteredUserName + "! You have successfully created an account!");
                return userAccountsList.get(this.enteredUserName);
            } else {
                System.out.println("Username is already taken. Be a bit more original!");
                attempts += 1;
            }
        }
        return null;
    }

    public void setUpUserAccount() {
        this.userNamePasswordMap.put(this.enteredUserName, this.enteredPassword);
        this.userAccountsList.put(this.enteredUserName, new UserAccount(this.enteredUserName, this.enteredPassword));
    }

    public void closeAccount() {
        this.userNamePasswordMap.remove(this.enteredUserName);
        this.userAccountsList.remove(this.enteredUserName);
        System.out.println("Sorry to see you go " + this.enteredUserName + "! Your account is now closed...Oh, you want your money? LOL");
    }
}

