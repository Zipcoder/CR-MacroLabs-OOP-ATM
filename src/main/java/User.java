import java.util.ArrayList;

public class User {
    private String userName;
    private String password;
    private ArrayList accountsArray = new ArrayList();

    User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void clearAccounts(){
        accountsArray.clear();
    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    String getUserName() {
        return userName;
    }

    void setUserPassword(String password) {
        this.password = password;
    }

    String getUserPassword() {
        return password;
    }

    int addAccount(String accountType) {
        Account newAccount = new Account(accountType);
        newAccount.setBalance(0);
        newAccount.setAccountNum();
        accountsArray.add(newAccount);
        return newAccount.getAccountNum();
    }

    ArrayList getAccountsArray() {
        return accountsArray;
    }

    boolean removeAccount(int accountNum) {
        boolean removedAccount = false;
        Account removeAccount = EnterAccount(accountNum);
        if (removeAccount.getBalance() == 0) {
            accountsArray.remove(removeAccount);
            removedAccount = true;
        }
        return removedAccount;
    }

    boolean AccountExist(int accountNum) {
        Account currentAccount;
        for (int i = 0; i < accountsArray.size(); i++) {
            currentAccount = (Account) accountsArray.get(i);
            if (currentAccount.getAccountNum() == accountNum) {
                return true;
            }
        }
        return false;
    }

    Account EnterAccount(int accountNum) {
        Account currentAccount;
        for (int i = 0; i < accountsArray.size(); i++) {
            currentAccount = (Account) accountsArray.get(i);
            if (currentAccount.getAccountNum() == accountNum) {
                return currentAccount;
            }
        }
        return null;

    }

    boolean withdraw(double amount, Account account) {
        boolean withdrawMade = false;
        double currentBalance = account.getBalance();
        String newTransaction;
        if (currentBalance >= amount) {
            withdrawMade = true;
            newTransaction = "Withdraw " + amount;
            account.addToAccountHistory(newTransaction);
            account.setBalance(currentBalance - amount);
        }
        return withdrawMade;
    }

    boolean deposit(double amount, Account account) {
        double currentBalance = account.getBalance();
        account.setBalance(currentBalance + amount);
        String newTransaction = "Deposit  " + amount;
        account.addToAccountHistory(newTransaction);
        return true;
    }

    boolean transfer(double amount, Account fromAccount, Account toAccount) {
        return withdraw(amount, fromAccount) && deposit(amount, toAccount);
    }


}
