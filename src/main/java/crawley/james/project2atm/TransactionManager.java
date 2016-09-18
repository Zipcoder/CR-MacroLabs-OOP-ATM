package crawley.james.project2atm;

import java.util.ArrayList;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class TransactionManager {

    private ArrayList<Transaction> transactions = new ArrayList<>();

    public void addTransaction (Transaction.TransactionType transactionType, int customerID, int accountNumber, double amount) {

        transactions.add(0, new Transaction(transactionType, customerID, accountNumber, amount));

    }

    public void addTransaction (int customerID, int fromAccountNumber, int toAccountNumber, double amount) {

        transactions.add(0, new Transaction(Transaction.TransactionType.TRANSFER, customerID, fromAccountNumber, toAccountNumber, amount));

    }

    public void printTransactions (int customerID) {

        System.out.println(getTransactions(customerID));

    }

    public String getTransactions (int customerID) {

        String transactionList = "";
        for (Transaction transaction : transactions) {
            if (transaction.getCustomerID() == customerID) {
                 transactionList += getProperTransactionList(transaction);
            }
        }

        return transactionList;

    }

    private boolean isTransfer (Transaction transaction) {

        return transaction.getTransactionType().equals(Transaction.TransactionType.TRANSFER);

    }

    private String transferToString (Transaction transaction) {

        return "Customer: " + transaction.getCustomerID() + ", From Account: "
                + transaction.getFromAccountNumber() + ", To Account: "
                + transaction.getToAccountNumber() + ", "
                + transaction.getTransactionType() + ": $" + transaction.getAmount() + "\n";

    }

    private String depositOrWithdrawalToString (Transaction transaction) {

        return "Customer: " + transaction.getCustomerID() + ", Account: "
                + transaction.getFromAccountNumber() + ", " + transaction.getTransactionType()
                + ": $" + transaction.getAmount() + "\n";

    }

    private String getProperTransactionList (Transaction transaction) {

        if (isTransfer(transaction)) {
            return transferToString(transaction);
        } else {
            return depositOrWithdrawalToString(transaction);
        }

    }

}
