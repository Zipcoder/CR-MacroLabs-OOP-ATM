package atmproject.accounts;

import atmproject.User;
import atmproject.accounts.SavingsAccount;

public class InvestmentsAccount extends SavingsAccount {

    private Double minimumDeposit;

    public InvestmentsAccount(User currentUser, Double balance, String accountName) {
        super(currentUser, 0.0, accountName);
        super.setInterestRate(0.001);
        this.minimumDeposit = 15000.0;
    }

    public Double getMinimumDeposit() {
        return minimumDeposit;
    }

    public void setMinimumDeposit(Double minimumDeposit) {
        this.minimumDeposit = minimumDeposit;
    }

    public String enoughForInitialBalance(Double input){
        if(input < this.minimumDeposit){
            return String.format("We apologize. Your starting balance must be at least $%f0", minimumDeposit);
        }
        return "Thank you! Enjoy your new investment account.";
    }
}
