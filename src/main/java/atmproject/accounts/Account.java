package atmproject.accounts;

import atmproject.Console;
import atmproject.User;

import java.security.InvalidParameterException;

public class Account {

    private User currentUser;
    protected Double balance;
    private String accountName;
    Console console = new Console(System.in,System.out);

    public Account(User currentUser, Double balance, String accountName){
        this.currentUser = currentUser;
        this.balance = balance;
        this.accountName = accountName;
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double withdraw(Double amount) {
        if (amount < 0) {
            throw new InvalidParameterException();
        }
        if(this.balance >= amount) {
            this.balance = balance - amount;
            return balance;
        }
        return balance;
    }

    public Double deposit(Double amount) {
        if (amount < 0) {
            throw new InvalidParameterException();
        }
            this.balance = balance + amount;
            return balance;
    }

    public Double transfer(Account destinationAccount, Double amount) {
        if (amount < 0) {
            throw new InvalidParameterException();
        }
        if(this.balance >= amount) {
            this.withdraw(amount);
            destinationAccount.deposit(amount);
        }
        return this.balance;
    }

}
