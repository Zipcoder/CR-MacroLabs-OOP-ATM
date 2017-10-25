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
}
