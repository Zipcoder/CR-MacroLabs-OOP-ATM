import java.util.ArrayList;

public class User {
    private int userID;
    private String password;
    private ArrayList<Account> accounts = new ArrayList<Account>(3);

    private static int nextID = 1;

    public User(String aPassword) {
        userID = nextID;
        nextID++;
        password = aPassword;
    }


    public int getUserID() {
        return userID;
    }

    public boolean isCorrectPassword(String input) {
        return password.equals(input);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account newAccount) {
        accounts.add(newAccount);
    }

    public boolean closeAccount(Account accountToRemove) {
        if(accountToRemove.getBalance() > 0) {
            return false;
        }
        else {
            return accounts.remove(accountToRemove);
        }
    }
}
