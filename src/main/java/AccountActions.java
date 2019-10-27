import java.util.ArrayList;
import java.util.Scanner;

public class AccountActions {
    private ArrayList<User> database;
    private Scanner scanner = new Scanner(System.in);

    public AccountActions(ArrayList<User> database) {
        this.database = database;
    }

    public void withdraw(String current, int accountChoice) {
        double amount;
        String transaction;
        System.out.println("How much would you like to withdraw?");
        amount = scanner.nextDouble();

        for (User i : database) {
            if (i.getUserID().equals(current)) {
                //Scanner Here
                if (accountChoice == 1) {
                    if (amount > i.getCheckingBalance()) {
                        System.out.println("Sorry. Not enough funds in your account");
                    } else {
                        i.withdrawChecking(amount);
                        transaction = i.getFirstName() + " " + i.getLastName() + "Withdrew : " + amount +
                                " from Checking. Remaining Balance: " + i.getCheckingBalance();
                        System.out.println("Withdraw of " + amount + "completed succesfully!");
                        i.setTransaction(transaction);
                    }
                }
                if (accountChoice == 2) {
                    //Scanner Here
                    if (amount > i.getSavingBalance()) {
                        System.out.println("Sorry. Not enough funds in your account");
                    } else {
                        i.withdrawSaving(amount);
                        transaction = i.getFirstName() + " " + i.getLastName() + "Withdraw : " + amount +
                                " to Savings. Remaining Balance: " + i.getSavingBalance();
                        System.out.println("Withdraw of " + amount + "completed succesfully!");
                        i.setTransaction(transaction);
                    }
                }
                if (accountChoice == 3) {
                    //Scanner Here
                    if (amount > i.getInvestBalance()) {
                        System.out.println("Sorry. Not enough funds in your account");
                    } else {
                        i.withdrawInvest(amount);
                        transaction = i.getFirstName() + " " + i.getLastName() + "Withdraw : " + amount +
                                " to Savings. Remaining Balance: " + i.getSavingBalance();
                        System.out.println("Withdraw of " + amount + "completed succesfully!");
                        i.setTransaction(transaction);
                    }
                }
            }
        }
    }

    public void deposit(String current, int accountChoice) {
        double amount;
        String transaction;
        System.out.println("How much would you like to deposit?");
        amount = scanner.nextDouble();

        for (User i : database) {
            if (i.getUserID().equals(current)) {
                //Scanner Here
                if (accountChoice == 1) {
                    i.depositChecking(amount);
                    transaction = i.getFirstName() + " " + i.getLastName() + "Deposited : " + amount +
                            " to Checking. Remaining Balance: " + i.getCheckingBalance();
                    System.out.println("Deposit of " + amount + "completed succesfully!");
                    i.setTransaction(transaction);
                }
                if (accountChoice == 2) {
                    i.depositSaving(amount);
                    transaction = i.getFirstName() + " " + i.getLastName() + "Deposited : " + amount +
                            " to Saving. Remaining Balance: " + i.getSavingBalance();
                    System.out.println("Deposit of " + amount + "completed succesfully!");
                    i.setTransaction(transaction);
                }
                if (accountChoice == 3) {
                    i.depositInvest(amount);
                    transaction = i.getFirstName() + " " + i.getLastName() + "Deposited : " + amount +
                            " to Invest. Remaining Balance: " + i.getInvestBalance();
                    System.out.println("Deposit of " + amount + "completed succesfully!");
                    i.setTransaction(transaction);
                }
            }
        }
    }

    public void balance(String current, int accountChoice) {
        for (User i : database) {
            if (i.getUserID().equals(current)) {
                if (accountChoice == 1) {
                    System.out.println("Current checking account balance for user " + i.getFirstName() + " " + i.getLastName() +
                            ": " + i.getCheckingBalance() + "\n\n");

                }
                if (accountChoice == 2) {
                    System.out.println("Current savings account balance for user " + i.getFirstName() + " " + i.getLastName() +
                            ": " + i.getCheckingBalance() + "\n\n");
                }
                if (accountChoice == 3) {
                    System.out.println("Current investment account balance for user " + i.getFirstName() + " " + i.getLastName() +
                            ": " + i.getCheckingBalance() + "\n\n");
                }
            }
        }
    }
}



