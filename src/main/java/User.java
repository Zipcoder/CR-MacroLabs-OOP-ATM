import AccountsAndTransactions.Account;

import java.util.ArrayList;

public class User {

    private String firstName;
    private String lastName;
    private Integer pin;
    private Double balance;
    private ArrayList<Account> accsStored = new ArrayList<Account>();

    public User() {
    }
    public User(String firstName, String lastName, Integer pin, Double balance) {
        setFirstName(firstName);
        setLastName(lastName);
        setPin(pin);
        setBalance(balance);
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        if (firstName != null){
            this.firstName = firstName;
        }
    }


    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        if (lastName != null){
            this.lastName = lastName;
        }
    }


    public Integer getPin() {
        return pin;
    }
    public void setPin(Integer pin) {
        if (pin != null) {
            this.pin = pin;
        }
    }


    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }
    public void addToBalance(Double amount){
        if (amount > 0){
            balance += amount;
        }
    }
    public void subtractFromBalance(Double amount){
        if (amount > 0){
            balance -= amount;
        }

    }
}
