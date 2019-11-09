package atmproject;

import atmproject.accounts.Account;
import atmproject.accounts.InvestmentsAccount;
import atmproject.accounts.SavingsAccount;

public class AccountMenu {
    SavingsAccount savingsAccount;
    Account checkingAccount;
    InvestmentsAccount investmentsAccount;

    public Account selectAccount(Integer input) {
       Account returnedAccount = null;

        switch (input) {
            case 1:
                returnedAccount = checkingAccount;
            break;
            case 2:
                returnedAccount = savingsAccount;
            break;
            case 3:
                returnedAccount = investmentsAccount;
            break;
            case 4:
                returnedAccount = null;
        }

        return returnedAccount;
    }
}
