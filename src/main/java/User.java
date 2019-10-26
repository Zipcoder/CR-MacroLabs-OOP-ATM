import java.util.ArrayList;

public class User {

    private String firstName;
    private String lastName;
    private String password;
    private Integer userID;
    private Integer cardNumber;

    //private ArrayList<Acoount> accounts;

    public User(String firstName, String lastName, String password, Integer userID, Integer cardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userID = userID;
        this.cardNumber = cardNumber;
    }
}
