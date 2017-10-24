import java.util.ArrayList;

public class User {
    private String userName;
    private String password;
    private ArrayList accountsArray = new ArrayList();

    User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserPassword(String password) {
        this.password = password;
    }
    public String getUserPassword() {
        return password;
    }

    public int accountsArraySize(){
        return accountsArray.size();
    }

    public void addAccount(char accountType) {

        Account newAccount = new Account();
        newAccount.setType(accountType);
        newAccount.setBalance(0);
        newAccount.setAccountNum();

        accountsArray.add(newAccount);
        //return newAccount;
    }

    public boolean removeAccount(int accountNum){
        boolean removedAccount = false;
        Account removeAccount = EnterAccount(accountNum);
        if(removeAccount.getBalance() == 0){
            accountsArray.remove(removeAccount);
            removedAccount = true;
        }
        return removedAccount;
    }

    public boolean AccountExist(int accountNum) {
        int index = -1;
        boolean accountExist = false;
        Account currentAccount;
        for (int i = 0; i < accountsArray.size(); i++) {
            currentAccount = (Account) accountsArray.get(i);
            if (currentAccount.getAccountNum() == accountNum) {
                index = i;
            }
        }
        if (index >= 0) {
            accountExist = true;
        }
        return accountExist;
    }

    public Account EnterAccount(int accountNum) {
        int index = -1;
        Account currentAccount;
        for (int i = 0; i < accountsArray.size(); i++) {
            currentAccount = (Account) accountsArray.get(i);
            if (currentAccount.getAccountNum() == accountNum) {
                index = i;
            }
        }
        if (index >= 0) {
            currentAccount = (Account) accountsArray.get(index);
        }else {
            currentAccount = null;
        }

        return currentAccount;
    }


    public boolean withdraw(double amount,Account account){
        boolean withdrawMade = false;
        double currentBalance = account.getBalance();
        if(currentBalance > amount){
            withdrawMade = true;
            account.setBalance(currentBalance-amount);
        }
        return withdrawMade;
    }

    public boolean deposit(double amount, Account account){
        double currentBalance = account.getBalance();
        account.setBalance(currentBalance+amount);
        return true;
    }

    public boolean transfer(double amount,Account fromAccount,Account toAccount){
        return withdraw(amount,fromAccount) && deposit(amount,toAccount);
    }



}
