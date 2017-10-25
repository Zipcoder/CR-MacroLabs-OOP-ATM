import java.util.ArrayList;
import java.util.Random;

public class Account {
    private int accountNumber;
    private AccountType accountType;
    private double balance;
    private ArrayList<String> transactionHistory = new ArrayList<String>();

    public Account() {
        this(AccountType.CHECKING);
    }

    public Account(AccountType type) {
        this(type, 0);
    }

    public Account(AccountType type, double initialBalance) {
        Random rand = new Random();
        accountNumber = rand.nextInt(1000000);
        accountType = type;
        if(initialBalance < 0) {
            balance = 0;
        }
        else if(initialBalance > 25000) {
            balance = 25000;
        }
        else {
            balance = Main.truncateToTwoDecimalPlaces(initialBalance);
        }
    }

    public boolean deposit(double amount) {
        if(amount > 25000) {
            amount = 25000;
        }
        else {
            amount = Main.truncateToTwoDecimalPlaces(amount);
        }
        if(amount > 0) {
            balance += amount;
            transactionHistory.add(String.format("Deposited $%.2f, Account balance $%.2f", amount, balance));
            return true;
        }
        else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if(amount > 25000) {
            amount = 25000;
        }
        else {
            amount = Main.truncateToTwoDecimalPlaces(amount);
        }
        if(amount > 0) {
            if(balance >= amount) {
                balance -= amount;
                transactionHistory.add(String.format("Withdrew $%.2f, Account balance $%.2f", amount, balance));
                return true;
            }
        }

        return false;
    }

    public boolean transferTo(Account otherAccount, double amount) {
        if(amount > 25000) {
            amount = 25000;
        }
        else {
            amount = Main.truncateToTwoDecimalPlaces(amount);
        }
        boolean validWithdraw = this.withdraw(amount);
        if(validWithdraw) {
            boolean depositWorked = otherAccount.deposit(amount);
            return depositWorked;
        }
        return false;
    }

    public String formatTransactionHistory() {
        String output = "";
        for(String transaction: transactionHistory) {
            output += transaction + "\n";
        }
        return output;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
