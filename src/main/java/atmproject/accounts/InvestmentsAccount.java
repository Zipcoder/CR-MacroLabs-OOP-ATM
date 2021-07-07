package atmproject.accounts;

import atmproject.User;
import atmproject.accounts.SavingsAccount;

public class InvestmentsAccount extends SavingsAccount {

    public InvestmentsAccount(User currentUser, Double balance, String accountName) {
        super(currentUser, balance, accountName);
        super.setInterestRate(0.001);
    }
}
