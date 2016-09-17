package butte.emily.ATM;
import static butte.emily.ATM.Enums.*;

/**
 * Created by emilybutte on 9/16/16.
 */
public class BankAccount {

    private int balance;
    private AccountStatus accountStatus;
    private int accountNumber;
    private int accountNumberCounter;
    private String accountHolderName;
    private AccountType accountType;

    public BankAccount(int balance) {
        this.balance = balance;
        return;
    }

    public int getBalance() {
        return balance;
    }
}
