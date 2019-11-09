package atmproject.accounts;

import atmproject.User;

public class Account {

    private User currentUser;
    private Double balance;

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

    public Double addToBalance(Double balance, Double input){
        this.balance = balance + input;
        return balance;
    }

    public Double subtractFromBalance(Double balance, Double input){
        this.balance = balance - input;
        return balance;
    }
}
