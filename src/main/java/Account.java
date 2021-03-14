import java.text.NumberFormat;
import java.util.Scanner;
public class Account {

    public Account() {
        checking.setType("Checking");
        checking.setBalance(0.00);

        savings.setType("Savings");
        savings.setBalance(0.00);

        TxnHistory.setType("Transaction");
    }

    // Create and instantiate checking  Account objects
    TranscationHist checking = new TranscationHist();
    // Create and instantiate checking  Account objects
    TranscationHist savings = new TranscationHist();
    TranscationHist TxnHistory = new TranscationHist();
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private Console c;
    Scanner sc = new Scanner(System.in);
    boolean session = true;


    public void depositMoney() {
        System.out.print("Enter (1) for Savings or (2) for Checking: ");
        Integer depAccount = sc.nextInt();

// Keeps track of which account to deposit money to - checking or saving
        if (depAccount == 1) {
            System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");
            System.out.println("How much money would you like to deposit?");

            Double deposit = sc.nextDouble();
            if (deposit < 0) {
                System.out.println("Please enter amount greater than ZERO");
            } else {
                savings.deposit(deposit);
                System.out.println("\nYour Savings balance is now: " + formatter.format(savings.getBalance()) + "\n");
                TxnHistory.printTxn("Savings Deposit ", deposit, savings.getBalance());
            }
        } else if (depAccount == 2) {
            System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");
            System.out.println("How much money would you like to deposit?");

            Double deposit = sc.nextDouble();
            if (deposit < 0) {
                System.out.println("Please enter amount greater than ZERO");
            } else {
                checking.deposit(deposit);
                System.out.println("\nChecking balance is now: " + formatter.format(checking.getBalance()) + "\n");
                TxnHistory.printTxn("Checking Deposit", deposit, checking.getBalance());
            }
        } else {
            System.out.println("Please enter valid input (1 for Savings and 2 for Checking)");
        }

    }

    public void withdrawMoney() {
        System.out.print("\nEnter (1) for Savings or (2) for Checking: ");
        Integer witAccount = sc.nextInt(); // Keeps track of which account to withdraw from
        if (witAccount == 1) {
            System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");
            System.out.println("How much money would you like to withdraw?");

            Double withdraw = sc.nextDouble();
            if (withdraw > savings.balance) {
                System.out.println("INSUFFICIENT BALANCE! " + "Please enter a different amount");
            } else {
                savings.withdraw(withdraw);
                System.out.println("\nYour Savings balance is now: " + formatter.format(savings.getBalance()) + "\n");
                TxnHistory.printTxn("Savings withdraw ", withdraw, savings.getBalance());
            }
        } else if (witAccount == 2) {
            System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");
            System.out.println("How much money would you like to withdraw?");

            Double withdraw = sc.nextDouble();
            if (withdraw > checking.balance) {
                System.out.println("INSUFFICIENT BALANCE! " + "Please enter a different amount");
            } else {
                checking.withdraw(withdraw);
                System.out.println("\nYour Checking balance is now: " + formatter.format(checking.getBalance()) + "\n");
                TxnHistory.printTxn("Checking withdraw", withdraw, checking.getBalance());
            }
        }

    }

    public void transferMoney() {
        System.out.print("\nFrom which account do you wish to transfer funds from?, (1) for Savings or (2) for Checking: ");
        Integer tranAccount = sc.nextInt();
        if (tranAccount == 1) {
            System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");
            System.out.print("How much money do you wish to transfer from Savings to Checking?: ");

            Double tranAmount = sc.nextDouble();
            if (tranAmount > savings.balance) {
                System.out.println("INSUFFICIENT BALANCE! " + "Please enter a different amount.");
            } else {
                savings.withdraw(tranAmount);
                checking.deposit(tranAmount);

                System.out.println("\nYou successfully transferred " + formatter.format(tranAmount) + " from Savings to Checking");
                System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
                System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");
            }
        } else if (tranAccount == 2) {
            System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");
            System.out.print("How much money do you wish to transfer from Checking to Saving?: ");

            Double tranAmount = sc.nextDouble();
            if (tranAmount > checking.balance) {
                System.out.println("INSUFFICIENT BALANCE! " + "Please enter a different amount.");
            } else {
                checking.withdraw(tranAmount);
                savings.deposit(tranAmount);

                System.out.println("\nYou successfully transferred " + formatter.format(tranAmount) + " from Checking to Savings");
                System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
                System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");
            }
        }

    }

    public void checkBalance() {
        System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
        System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");
    }
}


/// //Time display
//    public static void getTime(){
//        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        displayValue = (timeFormat.format(now));
//    }
///add switch case 6 for other options : create new account,  close account, print transaction receipt