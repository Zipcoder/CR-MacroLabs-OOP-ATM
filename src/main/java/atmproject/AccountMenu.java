package atmproject;

import atmproject.accounts.Account;
import atmproject.accounts.InvestmentsAccount;
import atmproject.accounts.SavingsAccount;

import java.util.LinkedHashMap;
import java.util.Map;

public class AccountMenu {
    Account account;
    Console console = new Console(System.in, System.out);

    public Account selectAccount(User user) {
        Map<Integer, Account> returnedMap = new LinkedHashMap<>();
       Account returnedAccount = null;
       Integer counter = 1;
       console.println("\n");
        for(String s : user.accountList.keySet()) {
            console.println( counter + " " + s);
            returnedMap.put(counter, user.accountList.get(s));
            counter++;

        }
        console.println("\nPlease select an account.");
        Integer input = console.getIntegerInput(":");


       if (returnedMap.containsKey(input)){
           returnedAccount = returnedMap.get(input);
       }


        return returnedAccount;
    }
}
