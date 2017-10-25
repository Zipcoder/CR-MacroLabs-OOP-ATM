package io.zipcoder.macrolabs.atm;

public class AccountFactory {

    private AccountFactory(){}

    public static InvestmentAccount createInvestment(int passedUserID){
        return (createInvestment(passedUserID, "Investment Account"));
    }

    public static InvestmentAccount createInvestment(int passedUserID,
                                                     String passedAccountName){
        return (createInvestment(passedUserID, passedAccountName, 7.95));

    }

    public static InvestmentAccount createInvestment(int passedUserID,
                                                     String passedAccountName,
                                                     double passedCommissionRate){
        return (new InvestmentAccount(passedUserID, passedAccountName, passedCommissionRate));
    }

    public static SavingAccount createSaving(int passedUserID){
        return (createSaving(passedUserID, "Saving Account"));
    }

    public static SavingAccount createSaving(int passedUserID,
                                                     String passedAccountName){
        return (createSaving(passedUserID, passedAccountName, 0.01));

    }

    public static SavingAccount createSaving(int passedUserID,
                                                     String passedAccountName,
                                                     double passedInterestRate){
        return (new SavingAccount(passedUserID, passedAccountName, passedInterestRate));
    }

}
