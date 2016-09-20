package butte.emily.ATM;

import java.util.HashMap;
import java.util.List;

/**
 * Created by emilybutte on 9/16/16.
 */
public class AccountManager {

    public AccountManager(HashMap<String, List> bankAccounts) {
        BankAccounts = bankAccounts;
    }

    private HashMap<String, List> BankAccounts = new HashMap<String, List>();

    public HashMap<String, List> getBankAccounts() {
        return BankAccounts;
    }

}

