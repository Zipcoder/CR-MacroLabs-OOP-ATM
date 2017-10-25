package com.zipcode.macrolabs.atm.transaction;

import com.zipcode.macrolabs.atm.bankaccount.Account;

public class TransferTransaction extends Transaction{

    private Account destinationAccount;

    public TransferTransaction(double amount, Account destinationAccount){
        super(TransactionType.TRANSFER, amount);
        this.destinationAccount = destinationAccount;
    }

    @Override
    public String toString(){
        return String.format("Date: %s | ID: %s | Type: %s | Amount: $%,.2f | From Account: %s | To Account: %s ",
                this.date, this.transactionID, this.transactionType, this.amount, this.originAccount.getAccountID(), this.destinationAccount.getAccountID());
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

}
