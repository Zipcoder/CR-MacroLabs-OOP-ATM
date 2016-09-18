package crawley.james.project2atm;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class Account {

    public enum AccountType {SAVINGS, CHECKING, INVESTMENT;}

    private AccountType accountType;
    private double balance;
    private int accountNumber;
    private int customerID;
    private double interestRate;
    private static int accountNumCounter = 1;

    public Account(AccountType accountType, double balance, int customerID) {

        this.accountType = accountType;
        this.balance = balance;
        this.customerID = customerID;
        accountNumber = accountNumCounter++;
        setInterestRate(accountType);


    }


    public AccountType getAccountType() {

        return accountType;

    }

    public int getAccountNumber() {

        return accountNumber;

    }

    public void setInterestRate(AccountType accountType) {

        switch (accountType) {

            case SAVINGS:
                interestRate = 0.05;
                break;
            case CHECKING:
                interestRate = 0.02;
                break;
            case INVESTMENT:
                interestRate = 0.07;
                break;
            default:
                System.out.println("Not a valid account type");
        }
    }

    public double getInterestRate() {

        return interestRate;

    }

    public void setBalance(double balance) {

        this.balance = balance;
    }

    public double getBalance() {

        return balance;
    }

    public int getCustomerID() {

        return customerID;
    }

}
