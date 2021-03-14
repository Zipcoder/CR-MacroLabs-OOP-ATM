import java.util.HashMap;
import java.util.Map;

public class UserAccount {

    private String username;
    private String password;
    private Map<String, BankAccount> userBankAccounts;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
        this.userBankAccounts = new HashMap<String, BankAccount>();
        this.userBankAccounts.put("Checking", new BankAccount("Checking"));
        this.userBankAccounts.put("Savings", new BankAccount("Savings"));
        this.userBankAccounts.put("Investment", new BankAccount("Investment"));
    }

    public BankAccount getCheckingAccount() {
        return this.userBankAccounts.get("Checking");
    }

    public BankAccount getSavingsAccount() {
        return this.userBankAccounts.get("Savings");
    }

    public BankAccount getInvestmentAccount() {
        return this.userBankAccounts.get("Investment");
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

}
