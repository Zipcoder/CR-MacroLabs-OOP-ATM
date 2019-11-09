package atmproject.accounts;

import atmproject.User;

public class SavingsAccount extends Account {

    public SavingsAccount(User currentUser) {
        super(currentUser);
        Double interestRate = 0.05;
    }


}
