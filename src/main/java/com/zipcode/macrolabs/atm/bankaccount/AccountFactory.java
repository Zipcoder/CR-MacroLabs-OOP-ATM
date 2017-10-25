package com.zipcode.macrolabs.atm.bankaccount;

import com.zipcode.macrolabs.atm.exceptions.NoMoreAccountsException;
import com.zipcode.macrolabs.atm.user.User;

public class AccountFactory {

    static int iteratedAccountID = 0;
    static final int ACCOUNT_ID_LENGTH = 9;

    static int nextAccountID() throws NoMoreAccountsException {
        if((""+ iteratedAccountID).length() <= ACCOUNT_ID_LENGTH) {
            return iteratedAccountID++;
        } else { throw new NoMoreAccountsException(); }
    }

    private static Account accountCreatorHelper(Account account, User user){
        try {
            account.setAccountID(nextAccountID());
        } catch (NoMoreAccountsException e) {
            e.printStackTrace();
        }
        account.addUser(user);
        AccountWarehouse.addAccount(account);
        return account;
    }

    public static CheckingAccount createNewCheckingAccount(User user) {
        CheckingAccount account = new CheckingAccount();
        return (CheckingAccount) accountCreatorHelper(account, user);
    }

    public static SavingsAccount createNewSavingsAccount(User user) {
        SavingsAccount account = new SavingsAccount();
        return (SavingsAccount) accountCreatorHelper(account, user);
    }

    public static InvestmentAccount createNewInvestmentAccount(User user) {
        InvestmentAccount account = new InvestmentAccount();
        return (InvestmentAccount) accountCreatorHelper(account, user);
    }

}
