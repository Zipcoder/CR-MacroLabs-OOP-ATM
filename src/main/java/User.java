import java.util.ArrayList;

public class User implements Storeable {

    public String firstName;
    public String lastName;
    public String password;
    public Integer userID;
    public Integer cardNumber;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> pendingTransactions;

    public User(String firstName, String lastName, String password, Integer userID, Integer cardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userID = userID;
        this.cardNumber = cardNumber;
        this.accounts = null;
    }

    public User(Integer userId, String password, DB data) {

    }

    public ArrayList<Transaction> getUserHistory() {

        return pendingTransactions;
    }
}
