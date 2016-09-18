package crawley.james.project2atm;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class Transaction {

    public enum TransactionType {WITHDRAWAL, DEPOSIT, TRANSFER;}

    private TransactionType transactionType;
    private double amount;
    private int customerID;
    private int fromAccountNumber;
    private int toAccountNumber;

    public Transaction (TransactionType transactionType, int customerID, int accountNumber, double amount) {

        this.transactionType = transactionType;
        this.customerID = customerID;
        fromAccountNumber = accountNumber;
        this.amount = amount;

    }

    public Transaction (TransactionType transactionType, int customerID, int fromAccountNumber, int toAccountNumber, double amount) {

        this.transactionType = transactionType;
        this.customerID = customerID;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;


    }

    public  int getFromAccountNumber () {

        return fromAccountNumber;
    }

    public int getToAccountNumber () {

        return toAccountNumber;
    }

    public double getAmount () {

        return amount;
    }

    public TransactionType getTransactionType () {

        return transactionType;
    }

    public int getCustomerID () {

        return customerID;

    }


}
