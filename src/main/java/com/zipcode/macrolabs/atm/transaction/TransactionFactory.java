package com.zipcode.macrolabs.atm.transaction;

import com.zipcode.macrolabs.atm.bankaccount.Account;
import com.zipcode.macrolabs.atm.exceptions.NoMoreTransactionsException;

public class TransactionFactory {

    static int iteratedTransactionID = 0;
    public static final int TRANSACTION_ID_LENGTH = 9;

    static int nextTransactionID() throws NoMoreTransactionsException {
        if (("" + iteratedTransactionID).length() <= TRANSACTION_ID_LENGTH) {
            return iteratedTransactionID++;
        } else {
            throw new NoMoreTransactionsException();
        }
    }

    private static Transaction transactionCreatorHelper(Transaction transaction, Account originAccount) {
        try {
            transaction.setTransactionID(nextTransactionID());
        } catch (NoMoreTransactionsException e) {
            e.printStackTrace();
        }
        transaction.setOriginAccount(originAccount);
        return transaction;
    }

    public static Transaction createNewWithdrawal(double amount, Account originAccount) {
        Transaction transaction = new Transaction(TransactionType.WITHDRAWAL, amount);
        return transactionCreatorHelper(transaction, originAccount);
    }

    public static Transaction createNewDeposit(double amount, Account originAccount) {
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount);
        return transactionCreatorHelper(transaction, originAccount);
    }

    public static TransferTransaction createNewTransfer(double amount, Account originAccount, Account destinationAccount) {
        TransferTransaction transaction = new TransferTransaction(amount, destinationAccount);
        return (TransferTransaction) transactionCreatorHelper(transaction, originAccount);
    }
}
