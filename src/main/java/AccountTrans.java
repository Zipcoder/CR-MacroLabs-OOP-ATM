
import java.text.NumberFormat;

public class AccountTrans {

    private NumberFormat formatter;
    private Console c;

    public AccountTrans() {
        this.c = new Console();
        this.formatter = NumberFormat.getCurrencyInstance();
    }

    public void depositMoney(BankAccount chosenBankAccount) {
        // Keeps track of which account to deposit money to - checking or saving
            System.out.println("\nYour current " + chosenBankAccount.getAccountType() + " balance is: " + formatter.format(chosenBankAccount.getBalance()) + "\n");
            System.out.println("How much money would you like to deposit?");

            Double deposit;
            deposit = c.getDoubleInput();
            if (deposit < 0) {
                System.out.println("Please enter amount greater than ZERO");
            } else {
                chosenBankAccount.deposit(deposit);
                System.out.println("\nYour " + chosenBankAccount.getAccountType() + " balance is now: " + formatter.format(chosenBankAccount.getBalance()) + "\n");
                chosenBankAccount.printTxn(chosenBankAccount.getAccountType() + " Deposit ", deposit, chosenBankAccount.getBalance());
                System.out.println();
            }
    }

    public void withdrawMoney(BankAccount chosenBankAccount) {

        System.out.println("\nYour current " + chosenBankAccount.getAccountType() + " balance is: " + formatter.format(chosenBankAccount.getBalance()) + "\n");
        System.out.println("How much money would you like to withdraw?");

        Double withdraw;
        withdraw = c.getDoubleInput();
        if (withdraw > chosenBankAccount.getBalance()) {
            System.out.println("INSUFFICIENT BALANCE! Your request will not be processed. \n");
        } else {
            chosenBankAccount.withdraw(withdraw);
            System.out.println("\nYour " + chosenBankAccount.getAccountType() + " balance is now: " + formatter.format(chosenBankAccount.getBalance()) + "\n");
            chosenBankAccount.printTxn(chosenBankAccount.getAccountType() + " withdraw ", withdraw, chosenBankAccount.getBalance() );
            System.out.println();
        }
    }

    public void transferMoney(BankAccount chosenTransferFromAccount, BankAccount chosenTransferToAccount) {
        System.out.println("\nYour current " + chosenTransferFromAccount.getAccountType() + " balance is: " + formatter.format(chosenTransferFromAccount.getBalance()) + "\n");
        System.out.print("How much money do you wish to transfer from " + chosenTransferFromAccount.getAccountType() + " to " + chosenTransferToAccount.getAccountType() + "?: ");

        Double tranAmount;
        tranAmount = c.getDoubleInput();
        if (tranAmount > chosenTransferFromAccount.getBalance()) {
            System.out.println("INSUFFICIENT BALANCE! " + "Please enter a new amount.");
        } else {
            chosenTransferFromAccount.withdraw(tranAmount);
            chosenTransferToAccount.deposit(tranAmount);

            System.out.println("\nYou successfully transferred " + formatter.format(tranAmount) + " from " + chosenTransferFromAccount.getAccountType() + " to " + chosenTransferToAccount.getAccountType());
            System.out.println("\n" + chosenTransferFromAccount.getAccountType() + " Balance: " + formatter.format(chosenTransferFromAccount.getBalance()));
            System.out.println(chosenTransferToAccount.getAccountType() + " Balance: " + formatter.format(chosenTransferToAccount.getBalance()) + "\n");
        }
    }

    public void checkBalance (UserAccount currentUser) {
        System.out.println("\nChecking Balance: " + formatter.format(currentUser.getCheckingAccount().getBalance()));
        System.out.println("Savings Balance: " + formatter.format(currentUser.getSavingsAccount().getBalance()));
        System.out.println("Investment Balance: " + formatter.format(currentUser.getInvestmentAccount().getBalance()) + "\n");
    }


}

/// //Time display
//    public static void getTime(){
//        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        displayValue = (timeFormat.format(now));
//    }
///add switch case 6 for other options : create new account,  close account, print transaction receipt

