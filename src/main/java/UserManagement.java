import java.util.ArrayList;
import java.util.HashMap;

public class UserManagement {

    Console c = new Console();
    private String enteredUserName;
    private String enteredPassword;
    private HashMap<String, String> userNamePasswordMap;
    private ArrayList<User> userAccountsList;

    public UserManagement() {
        this.userNamePasswordMap = new HashMap<String, String>();
        // FOR TESTING
        this.userNamePasswordMap.put("TestAccount", "123");
        this.userNamePasswordMap.put("TestAccount2", "456");

        this.userAccountsList = new ArrayList<User>();
        // FOR TESTING
        userAccountsList.add(new User("TestAccount", "123"));
        userAccountsList.add(new User("TestAccount2", "456"));
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

    public boolean validateLoginCredentials() {
        int attempts = 0;
        while (attempts < 3) {
            if(this.validateUserNameExists() == false) {
                System.out.println("No such user exists.");
                attempts += 1;
            } else if (this.validatePasswordCorrect() == false) {
                System.out.println("Password is incorrect.");
                attempts += 1;
            } else {
                System.out.println("You are now logged in.");
                return true;
            }
        }

        return false;
    }

    public boolean createNewUserAccount() {
        System.out.println("Enter your new username and password.");
        int attempts = 0;
        while (attempts < 3) {
            if (this.validateUserNameExists() == false) {
                getPassword();
                setUpUserAccount();
                System.out.println("Congratulations " + this.enteredUserName + "! You have successfully created an account!");
                return true;
            } else {
                System.out.println("Username is already taken. Please select another.");
                attempts += 1;
            }
        }

        return false;
    }

    public void setUpUserAccount() {
        this.userNamePasswordMap.put(this.enteredUserName, this.enteredPassword);
        this.userAccountsList.add(new User(this.enteredUserName, this.enteredPassword));
    }
}

