package atmproject.accounts;

import atmproject.User;
import atmproject.accounts.Account;

public class SavingsAccount extends Account {

    protected Double interestRate;

    public SavingsAccount(User currentUser) {
        super(currentUser);
        super.setBalance(0.0);
        this.interestRate = 0.0005;
    }

    public Double addInterest(){
        balance += (balance * interestRate);
        return balance;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
}
