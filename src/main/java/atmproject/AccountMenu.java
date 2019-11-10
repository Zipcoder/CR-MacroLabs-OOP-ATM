package atmproject;

import atmproject.accounts.Account;
import atmproject.accounts.InvestmentsAccount;
import atmproject.accounts.SavingsAccount;

import java.util.Map;

public class AccountMenu {
    Account account;
    Console console = new Console(System.in, System.out);

    public Account selectAccount(User user) {
       Account returnedAccount = null;
       Integer counter = 1;
       console.println("\n");
        for(String s : user.accountList.keySet()) {
            console.println(s);
        }
        console.println("\nPlease select an account.");
        String input = console.getStringInput(":");

       if (user.accountList.containsKey(input)){
           returnedAccount = user.accountList.get(input);
       }


        return returnedAccount;
    }
}
