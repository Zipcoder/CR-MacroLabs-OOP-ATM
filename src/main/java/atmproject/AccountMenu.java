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


       String input = console.getStringInput("please select an Account:\n");
        for(String s : user.accountList.keySet()) {
            console.println(s);
        }

       if (user.accountList.containsKey(input)){
           returnedAccount = user.accountList.get(input);
       }


        return returnedAccount;
    }
}
