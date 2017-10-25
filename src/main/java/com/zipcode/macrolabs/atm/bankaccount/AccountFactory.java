package com.zipcode.macrolabs.atm.bankaccount;

import com.zipcode.macrolabs.atm.exceptions.NoMoreAccountsException;
import com.zipcode.macrolabs.atm.user.User;

public class AccountFactory {

    static int iteratedAccountID = 0;
    public static final int ACCOUNT_ID_LENGTH = 9;

    public static int nextAccountID() throws NoMoreAccountsException {
        if((""+ iteratedAccountID).length() <= ACCOUNT_ID_LENGTH) {
            return iteratedAccountID++;
        } else { throw new NoMoreAccountsException(); }
    }

    public static CheckingAccount createNewCheckingAccount(User user) {
        CheckingAccount newCheckingAccount = new CheckingAccount();
        newCheckingAccount.addUser(user);
        try {
            newCheckingAccount.setAccountID(nextAccountID());
        } catch (NoMoreAccountsException e) {
            e.printStackTrace();
        }
        return newCheckingAccount;
    }

    public static SavingsAccount createNewSavingsAccount(User user) {
        SavingsAccount newSavingsAccount = new SavingsAccount();
        newSavingsAccount.addUser(user);
        try {
            newSavingsAccount.setAccountID(nextAccountID());
        } catch (NoMoreAccountsException e) {
            e.printStackTrace();
        }
        return newSavingsAccount;
    }

    public static InvestmentAccount createNewInvestmentAccount(User user) {
        InvestmentAccount newInvestmentAccount = new InvestmentAccount();
        newInvestmentAccount.addUser(user);
        try {
            newInvestmentAccount.setAccountID(nextAccountID());;
        } catch (NoMoreAccountsException e) {
            e.printStackTrace();
        }
        return newInvestmentAccount;
    }

}
