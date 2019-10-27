
public class User extends Account {
    private String userID;
    private  String userPassword;

    public User(String firstName, String lastName, String userID, String userPassword) {

        super(firstName, lastName);
        this.userID = userID;
        this.userPassword = userPassword;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
