package atmproject;

import atmproject.accounts.Account;
import atmproject.accounts.InvestmentsAccount;
import atmproject.accounts.SavingsAccount;

import java.util.LinkedHashMap;
import java.util.Map;

public class AccountMenu {
    Account returnedAccount;
    Console console = new Console(System.in, System.out);

    public Account selectAccount(User user) {
        Map<Integer, Account> returnedMap = new LinkedHashMap<>();
        returnedAccount = null;
        Integer counter = 1;
        printAndStoreAccounts(user, returnedMap, counter);
        returnedAccount = getUserSelectedAccount(returnedMap, returnedAccount);


        return returnedAccount;
    }

    public Account getUserSelectedAccount(Map<Integer, Account> returnedMap, Account returnedAccount) {
        while (returnedAccount == null) {
            console.println("\nPlease select an account.");
            Integer input = console.getIntegerInput(":");

            returnedAccount = getUsersInput(returnedMap, returnedAccount, input);

        }
        return returnedAccount;
    }

    public Account getUsersInput(Map<Integer, Account> returnedMap, Account returnedAccount, Integer input) {
        if (returnedMap.containsKey(input)) {
            returnedAccount = returnedMap.get(input);
        } else {
            console.println("\nAccount does not exist. Try again: ");
        }
        return returnedAccount;
    }

    public void printAndStoreAccounts(User user, Map<Integer, Account> returnedMap, Integer counter) {
        console.println("\n");
        for (String s : user.accountList.keySet()) {
            console.println("(" + counter + ")" + " - " + s);
            returnedMap.put(counter, user.accountList.get(s));
            counter++;

        }
    }
}
