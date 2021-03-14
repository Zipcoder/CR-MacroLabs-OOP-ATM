import java.util.ArrayList;
import java.util.HashMap;

public class WelcomeEngine {

    Console c = new Console();
    private String enteredUserName;
    private String enteredPassword;
    private HashMap<String, String> userNamePasswordMap;
    private HashMap<String, UserAccount> userAccountsList;

    public WelcomeEngine() {
        this.userNamePasswordMap = new HashMap<String, String>();
        // FOR TESTING
        this.userNamePasswordMap.put("TestAccount", "123");
        this.userNamePasswordMap.put("TestAccount2", "456");

        this.userAccountsList = new HashMap<String, UserAccount>();
        // FOR TESTING
        userAccountsList.put("TestAccount", new UserAccount("TestAccount", "123"));
        userAccountsList.put("TestAccount2", new UserAccount("TestAccount2", "456"));
    }

    public String getEnteredUserName() {
        return this.enteredUserName;
    }

    public void getUserName() {
        System.out.println("Username:");
        this.enteredUserName = c.getStringInput();
    }

    public void getPassword() {
        System.out.println("Password");
        this.enteredPassword = c.getStringInput();
    }

    public boolean validateUserNameExists() {
        this.getUserName();
        return this.userNamePasswordMap.containsKey(this.enteredUserName);
    }

    public boolean validatePasswordCorrect() {
        this.getPassword();
        return this.userNamePasswordMap.get(this.enteredUserName).equals(this.enteredPassword);
    }

    public UserAccount validateLoginCredentials() {
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
        int attempts = 0;
        while (attempts < 3) {
            if (this.validateUserNameExists() == false) {
                getPassword();
                setUpUserAccount();
                System.out.println("Congratulations " + this.enteredUserName + "! You have successfully created an account!");
                return userAccountsList.get(this.enteredUserName);
            } else {
                System.out.println("Username is already taken. Please select another.");
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
        System.out.println("Sorry to see you go" + this.enteredUserName + "! Your account is now closed.");
    }
}

