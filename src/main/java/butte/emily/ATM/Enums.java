package butte.emily.ATM;

/**
 * Created by emilybutte on 9/16/16.
 */
public class Enums {
    public enum AccountType { CHECKING, SAVINGS, INVESTMENT }
    public enum AccountStatus { OPEN, CLOSED, FROZEN }
    public enum OverdraftProtectionStatus { ENABLED, DISABLED, AUTOTRANSFER }
    public enum TransactionType { CREDIT, DEBIT, TRANSFER, CHANGENAME, CHANGEACCOUNTSTATUS }
}
