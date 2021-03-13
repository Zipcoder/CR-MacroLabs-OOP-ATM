import java.util.ArrayList;

public class AccountWarehouse {
    private static final ArrayList<Account> accounts = new ArrayList<Account>();

    private AccountWarehouse(){

    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static Account findAccountByAcctNumber(int acctNumber) {

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAcctNumber() == acctNumber) {
                return accounts.get(i);
            }
        }return null;
    }

    public static void addAccount(Account account){
        accounts.add(account);
    }

    public static void removeAccount(Account account){
        accounts.remove(account);

    }


}


