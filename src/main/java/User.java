import java.util.ArrayList;

public class User {

    private String userName;
    private String password;
    private ArrayList<Account> userAccounts = new ArrayList<Account>();

    public User (String userName, String password) {

        this.userName = userName;
        this.password = password;

    }

    public String createAccount () {

    }

    private void closeAccount () {

    }

    private void logIn () {


    }

    public String getUserName () {

        return userName;
    }

    public String checkPassword () {

        return password;
    }

    public ArrayList<Account> getAccountFromAL () {

        return userAccounts;
    }


}
