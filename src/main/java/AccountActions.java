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
                                " from Checking. Remaining Balance: " + i.getCheckingBalance() + "\n\n";
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
                        transaction = i.getFirstName() + " " + i.getLastName() + "Withdrew : " + amount +
                                " to Savings. Remaining Balance: " + i.getSavingBalance() + "\n\n";
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
                        transaction = i.getFirstName() + " " + i.getLastName() + "Withdrew : " + amount +
                                " to Savings. Remaining Balance: " + i.getSavingBalance() + "\n\n";
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
                            " to Checking. Remaining Balance: " + i.getCheckingBalance() + "\n\n";
                    System.out.println("Deposit of " + amount + "completed succesfully!");
                    i.setTransaction(transaction);
                }
                if (accountChoice == 2) {
                    i.depositSaving(amount);
                    transaction = i.getFirstName() + " " + i.getLastName() + "Deposited : " + amount +
                            " to Saving. Remaining Balance: " + i.getSavingBalance() + "\n\n";
                    System.out.println("Deposit of " + amount + "completed succesfully!");
                    i.setTransaction(transaction);
                }
                if (accountChoice == 3) {
                    i.depositInvest(amount);
                    transaction = i.getFirstName() + " " + i.getLastName() + "Deposited : " + amount +
                            " to Invest. Remaining Balance: " + i.getInvestBalance() + "\n\n";
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
                            ": " + i.getSavingBalance() + "\n\n");
                }
                if (accountChoice == 3) {
                    System.out.println("Current investment account balance for user " + i.getFirstName() + " " + i.getLastName() +
                            ": " + i.getInvestBalance() + "\n\n");
                }
            }
        }
    }



    public void transfer(String current){
        String transferAccount;
        int userOption;
        Console console = new Console();
        int accountChoice;
        double amount;
        String validate = "";
        String transaction;

        System.out.println("Choose type of transfer:\n" +
                "1 - Accounts\n" +
                "2 - To another account\n\n");

        userOption = scanner.nextInt();
        switch(userOption){

            case 1:
                for(User i : database){
                    if(i.getUserID().equals(current)){
                        System.out.println("Which account would you like to transfer to today?\n"+
                                "1 - Savings Account\n"+
                                "2 - Investment Account\n");
                        accountChoice = scanner.nextInt();
                        do{
                            System.out.println("How much would you like to transfer?\n");
                            amount = scanner.nextDouble();
                            if(amount > i.getCheckingBalance())
                                System.out.println("sorry not enough funds, choose a different amount");
                        }while(amount > i.getCheckingBalance());

                        if( accountChoice == 1){
                            i.withdrawChecking(amount);
                            i.depositSaving(amount);
                            transaction = i.getFirstName() + " " + i.getLastName() + "transferred : " + amount +
                                    " to savings. Remaining Balance: " + i.getInvestBalance() + "\n\n";
                            i.setTransaction(transaction);
                        }
                        else if(accountChoice == 2){
                            i.withdrawChecking(amount);
                            i.depositInvest(amount);
                            transaction = i.getFirstName() + " " + i.getLastName() + "transferred : " + amount +
                                    " to Invest. Remaining Balance: " + i.getInvestBalance() + "\n\n";
                            i.setTransaction(transaction);
                        }
                    }
                }
                break;
            case 2:
                for(User i : database){
                    if(i.getUserID().equals(current)){
                        do{
                            System.out.println("How much would you like to transfer?\n");
                            amount = scanner.nextDouble();
                            if(amount > i.getCheckingBalance())
                                System.out.println("sorry not enough funds, choose a different amount");
                        }while(amount > i.getCheckingBalance());
                        do{
                            System.out.println("Name on the account you would like to transfer to?\n\n");
                            transferAccount = scanner.next();
                            for(User user : database){
                                if(user.getUserID().equals(transferAccount)){
                                    validate = transferAccount;
                                    i.withdrawChecking(amount);
                                    user.depositChecking(amount);
                                    System.out.println(i.getFirstName() + "transferred " + amount + " to " + user.getFirstName());

                                    transaction = i.getFirstName() + " " + i.getLastName() + "transferred : " + amount +
                                            " to " + user.getFirstName()+ " " + user.getLastName() + " Balance: "  + i.getInvestBalance() + "\n\n";
                                    i.setTransaction(transaction);

                                    transaction = user.getFirstName() + " " + user.getLastName() +  " received: " + amount + " from " + i.getFirstName() + " " + i.getLastName() +
                                        " Balance: " + user.getCheckingBalance() + "\n\n";
                                    user.setTransaction(transaction);

                                }
                            }
                        }while(!transferAccount.equals(validate));
                    }
                }
                break;
            default:
                System.out.println("Sorry not an option");
        }
    }
}



