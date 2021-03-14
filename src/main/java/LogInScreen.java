import java.util.HashMap;

public class LogInScreen {

    Console c = new Console();
    private String enteredUserName;
    private String enteredPassword;
    private HashMap<String, String> userNamePasswordMap;

    public LogInScreen() {
        // FOR TESTING
        this.userNamePasswordMap = new HashMap<String, String>();
        this.userNamePasswordMap.put("TestAccount", "123");
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
        User newUser = new User(this.enteredUserName, this.enteredPassword);
    }
}

