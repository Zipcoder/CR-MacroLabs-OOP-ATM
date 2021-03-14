import java.text.NumberFormat;
import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
// Create and instantiate checking  Account objects
        Account checking = new Account();
        checking.setType("Checking");
        checking.setBalance(0.00);

// Create and instantiate checking  Account objects
        Account savings = new Account();
        savings.setType("Savings");
        savings.setBalance(0.00);


        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Scanner sc = new Scanner(System.in);
        boolean session = true;
        while (session) {
// Menu options for the user
            System.out.print("\nATM Menu: \n \n"
                    + "1. Deposit Money \n"
                    + "2. Withdraw Money \n"
                    + "3. Transfer Funds \n"
                    + "4. Check Account Balance\n"
                    + "5. End Session\n \n"
                    + "Enter selection: ");
            Integer selection = sc.nextInt();

            if (selection <1 || selection >5){
                System.out.println("Error - Please enter correct option");
            }

            switch (selection) {
// case 1 handles the depositing of money
                case 1:
                    System.out.print("Enter (1) for Savings or (2) for Checking: ");
                    Integer depAccount = sc.nextInt();

// Keeps track of which account to deposit money to - checking or saving
                    if (depAccount == 1) {
                        System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");
                        System.out.println("How much money would you like to deposit?");

                        Double deposit = sc.nextDouble();
                        if (deposit < 0){
                            System.out.println("Please enter amount greater than ZERO");
                        }else {
                            savings.deposit(deposit);
                            System.out.println("\nYour Savings balance is now: " + formatter.format(savings.getBalance()) + "\n");
                        }
                    } else if (depAccount == 2) {
                        System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");
                        System.out.println("How much money would you like to deposit?");

                        Double deposit = sc.nextDouble();
                        if (deposit < 0){
                            System.out.println("Please enter amount greater than ZERO");
                        }else {
                            checking.deposit(deposit);
                            System.out.println("\nChecking balance is now: " + formatter.format(checking.getBalance()) + "\n");
                        }
                    }
                    else{
                        System.out.println("Please enter valid input (1 for Savings and 2 for Checking)");
                    }

                    break;
// case 2 handles the withdrawal of money
                case 2:
                    System.out.print("\nEnter (1) for Savings or (2) for Checking: ");
                    Integer witAccount = sc.nextInt(); // Keeps track of which account to withdraw from
                    if (witAccount == 1) {
                        System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");
                        System.out.println("How much money would you like to withdraw?");

                        Double withdraw = sc.nextDouble();
                        if (withdraw > savings.balance){
                            System.out.println("INSUFFICIENT BALANCE! " + "Please enter a different amount");
                        }
                        else {
                            savings.withdraw(withdraw);
                            System.out.println("\nYour Savings balance is now: " + formatter.format(savings.getBalance()) + "\n");
                        }
                    }
                    else if (witAccount == 2) {
                        System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");
                        System.out.println("How much money would you like to withdraw?");

                        Double withdraw = sc.nextDouble();
                        if(withdraw > checking.balance){
                            System.out.println("INSUFFICIENT BALANCE! " + "Please enter a different amount");
                        }
                        else {
                            checking.withdraw(withdraw);
                            System.out.println("\nYour Checking balance is now: " + formatter.format(checking.getBalance()) + "\n");
                        }
                    }
                    break;
// case 3 handles the transfer of funds
                case 3:
                    System.out.print("\nFrom which account do you wish to transfer funds from?, (1) for Savings or (2) for Checking: ");
                    Integer tranAccount = sc.nextInt();
                    if (tranAccount == 1) {
                        System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");
                        System.out.print("How much money do you wish to transfer from Savings to Checking?: ");

                        Double tranAmount = sc.nextDouble();
                        if (tranAmount > savings.balance){
                            System.out.println("INSUFFICIENT BALANCE! " + "Please enter a different amount.");
                        }
                        else {
                            savings.withdraw(tranAmount);
                            checking.deposit(tranAmount);

                            System.out.println("\nYou successfully transferred " + formatter.format(tranAmount) + " from Savings to Checking");
                            System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
                            System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");
                        }
                    }
                    else if (tranAccount == 2) {
                        System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");
                        System.out.print("How much money do you wish to transfer from Checking to Saving?: ");

                        Double tranAmount = sc.nextDouble();
                        if(tranAmount > checking.balance){
                            System.out.println("INSUFFICIENT BALANCE! " + "Please enter a different amount.");
                        }
                        else {
                            checking.withdraw(tranAmount);
                            savings.deposit(tranAmount);

                            System.out.println("\nYou successfully transferred " + formatter.format(tranAmount) + " from Checking to Savings");
                            System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
                            System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");
                        }
                    }
                    break;
// case 4 simply outputs the balances of both Checking and Savings accounts
                case 4:
                    System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
                    System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");
                    break;
// case 5 breaks out of the (while) loop when the user is finished using the ATM
                case 5:
                    session = false;
                    break;
            }
        }
        System.out.println("\nThank you for banking with us! Have a nice time.\n");
    }
}
