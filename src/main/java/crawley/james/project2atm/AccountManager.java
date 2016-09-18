package crawley.james.project2atm;

import java.util.ArrayList;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class AccountManager {

    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount (Account.AccountType accountType, double amount, int customerID, int accountNumber) {

        accounts.add(new Account(accountType, amount, customerID, accountNumber));

    }

    public void deleteAccount (int accountID, int customerID) {

        for (Account matchingAccount: accounts) {
            if (matchingAccount.getAccountNumber() == accountID && matchingAccount.getCustomerID() == customerID) {
                accounts.remove(matchingAccount);
                break;
            }

        }
    }

    public Account getAccount (int accountID, int customerID) {

        for (Account matchingAccount: accounts) {
            if (matchingAccount.getAccountNumber() == accountID && matchingAccount.getCustomerID() == customerID) {
                return matchingAccount;
            }

        }

        return null;

    }

}
