package atmproject;

import atmproject.accounts.Account;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private String firstName;
    private String lastName;
    private Integer pinNumber;
    private Integer accountNumber;
    HashMap<String, Account> accountList;
    ArrayList<String> transactionHistory;

    public User(String firstName, String lastName, Integer accountNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pinNumber = accountNumber;
        this.pinNumber = 0;
        this.accountList = new HashMap<String, Account>();
        this.transactionHistory = new ArrayList<String>();

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
