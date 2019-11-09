package atmproject.accounts;

import atmproject.User;

import java.security.InvalidParameterException;

public class Account {

    private User currentUser;
    protected Double balance;

    public Account(User currentUser){
        this.currentUser = currentUser;
        this.balance = 0.0;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double addToBalance(Double input){
        this.balance = balance + input;
        return balance;
    }

    public Double subtractFromBalance(Double input){
        this.balance = balance - input;
        return balance;
    }
    public void withdraw(Double amount) {
        if (amount < 0) {
            throw new InvalidParameterException();
        }

    }

    public void deposit(Double amount) {
        if (amount < 0) {
            throw new InvalidParameterException();
        }

    }

    public void transfer(Double amount) {
        if (amount < 0) {
            throw new InvalidParameterException();
        }
    }
}
