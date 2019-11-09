import java.util.HashMap;
import java.util.Map;

public class AccountVillage {
    private Map<Integer, Account> accounts;
    private Integer nextId;


    public AccountVillage() {
        this.accounts = new HashMap<Integer, Account>();
        this.nextId = 0;
    }

    public Account createAccount(Double balance, String accountType) {
        nextId += 1;
        Account account = new Account(balance, nextId);
        this.accounts.put(nextId, account);
        return account;
    }

    public Account getAccountById(Integer id) {
        return this.accounts.get(id);
    }


    ////ACCESSORS AND MUTATORS && GETTERS AND SETTERS/////
    public Map<Integer, Account> getAccounts() {
        return accounts;
    }


    public void setAccounts(Map<Integer, Account> accounts) {
        this.accounts = accounts;
    }

    public Integer getNextId() {
        return nextId;
    }

    public void setNextId(Integer nextId) {
        this.nextId = nextId;
    }
}
