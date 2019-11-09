package atmproject.accounts;

import atmproject.User;

import java.security.InvalidParameterException;

public class Account {

    private User currentUser;
    protected Double balance;
    private Integer accountNumber;

    public Account(User currentUser, Double balance, Integer accountNumber){
        this.currentUser = currentUser;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public Account(Double balance){
        this.balance = balance;
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

    public Double withdraw(Double amount) {
        if (amount < 0) {
            throw new InvalidParameterException();
        }
        this.balance = balance - amount;
        return balance;
    }

    public Double deposit(Double amount) {
        if (amount < 0) {
            throw new InvalidParameterException();
        }
        if(this.balance > amount) {
            this.balance = balance + amount;
            return balance;
        }
        return balance;
    }

    public void transfer(Account destinationAccount, Double amount) {
        if (amount < 0) {
            throw new InvalidParameterException();
        }
        destinationAccount.deposit(amount);
        this.withdraw(amount);
    }

    public boolean closeAccount(){
        if (balance > 0.0){
            return false;
        }
        return currentUser.removeAccount(this) == null;
    }
}
