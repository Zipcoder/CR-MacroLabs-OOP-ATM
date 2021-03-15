
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
            System.out.println("\nYour current Savings balance is: " + formatter.format(chosenBankAccount.getBalance()) + "\n");
            System.out.println("How much money would you like to deposit?");

            Double deposit;
            deposit = c.getDoubleInput();
            if (deposit < 0) {
                System.out.println("Please enter amount greater than ZERO");
            } else {
                chosenBankAccount.deposit(deposit);
                System.out.println("\nYour Savings balance is now: " + formatter.format(chosenBankAccount.getBalance()) + "\n");
                chosenBankAccount.printTxn("Savings Deposit ", deposit, chosenBankAccount.getBalance());
                System.out.println();
            }
    }

    public void withdrawMoney(BankAccount chosenBankAccount) {

        System.out.println("\nYour current Savings balance is: " + formatter.format(chosenBankAccount.getBalance()) + "\n");
        System.out.println("How much money would you like to withdraw?");

        Double withdraw;
        withdraw = c.getDoubleInput();
        if (withdraw > chosenBankAccount.getBalance()) {
            System.out.println("INSUFFICIENT BALANCE! Your request will not be processed. \n");
        } else {
            chosenBankAccount.withdraw(withdraw);
            System.out.println("\nYour Savings balance is now: " + formatter.format(chosenBankAccount.getBalance()) + "\n");
            chosenBankAccount.printTxn("Savings withdraw ", withdraw, chosenBankAccount.getBalance() );
            System.out.println();
        }
    }

    public void transferMoney(BankAccount chosenTransferFromAccount, BankAccount chosenTransferToAccount) {
        System.out.println("\nYour current Savings balance is: " + formatter.format(chosenTransferFromAccount.getBalance()) + "\n");
        System.out.print("How much money do you wish to transfer from Savings to Checking?: ");

        Double tranAmount;
        tranAmount = c.getDoubleInput();
        if (tranAmount > chosenTransferFromAccount.getBalance()) {
            System.out.println("INSUFFICIENT BALANCE! " + "Please enter a different amount.");
        } else {
            chosenTransferFromAccount.withdraw(tranAmount);
            chosenTransferToAccount.deposit(tranAmount);

            System.out.println("\nYou successfully transferred " + formatter.format(tranAmount) + " from Savings to Checking");
            System.out.println("\nChecking Balance: " + formatter.format(chosenTransferFromAccount.getBalance()));
            System.out.println("Savings Balance: " + formatter.format(chosenTransferToAccount.getBalance()) + "\n");
        }
    }

    public void checkBalance (UserAccount currentUser) {
        System.out.println("\nChecking Balance: " + formatter.format(currentUser.getCheckingAccount().getBalance()));
        System.out.println("Savings Balance: " + formatter.format(currentUser.getSavingsAccount().getBalance()));
        System.out.println("Investment Balance: " + formatter.format(currentUser.getInvestmentAccount().getBalance()) + "\n");
    }


}


