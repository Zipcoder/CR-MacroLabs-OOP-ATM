import java.util.ArrayList;

public class User {

    private int id = 0;
    private String username;
    private String password;
    protected static ArrayList<Account> accounts = new ArrayList<Account>();



    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.id = id;
        id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(ArrayList<Account> accounts) {
        User.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Username: " + this.getUserName() +
                "\nPassword: " + this.getPassword() +
                "\nId: " + this.getId();
    }

}
