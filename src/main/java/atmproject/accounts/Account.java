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
        currentUser.addToHistory(String.format("You withdrew $%f.0 from %s.", amount, this.getAccountName()));
        return balance;
    }

    public Double deposit(Double amount) {
        if (amount < 0) {
            throw new InvalidParameterException();
        }
            this.balance = balance + amount;
            currentUser.addToHistory(String.format("You deposited $%f.0 from %s.", amount, this.getAccountName()));
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
        currentUser.addToHistory(String.format("You transfered $%f.0 from %s t0 %s.",amount, this.getAccountName(), destinationAccount.getAccountName()));
        return this.balance;
    }

    public Boolean closeAccount(){
        if (balance > 0.0){
            console.println("Please empty your account before attempting to close.");
            return false;
        }
        currentUser.removeAccount(this.getAccountName());
        return !currentUser.getAccountList().containsValue(this.getAccountName());
    }

    public void addAccount(Account account){
        currentUser.getAccountList().put(accountName,this);
    }
}
