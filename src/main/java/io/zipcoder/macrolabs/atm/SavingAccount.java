package io.zipcoder.macrolabs.atm;

public class SavingAccount extends Account{

    private double interestRate;

    public SavingAccount(int passedOwnerUserID) {
        this(passedOwnerUserID, "Saving Account");
    }

    public SavingAccount(int passedOwnerUserID, String passedAccountName){
        this(passedOwnerUserID, passedAccountName, 0.01);
    }

    public SavingAccount(int passedOwnerUserID, String passedAccountName,
                             double passedInterestRate){
        super(passedOwnerUserID, passedAccountName);
        interestRate=passedInterestRate;
    }

    public double getInterestRate(){
        return interestRate;
    }
}
