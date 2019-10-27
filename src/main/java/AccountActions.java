import java.util.ArrayList;
import java.util.Scanner;

public class AccountActions {
    private ArrayList<User> database;
    private Scanner scanner = new Scanner(System.in);

    public AccountActions(ArrayList<User> database){
        this.database = database;
    }

    public void withdraw(String current){
        double amount;
        String transaction;
        System.out.println("How much would you like to deposit");
        amount = scanner.nextDouble();

        for(User i : database){
            if(i.getUserID().equals(current)){
                if(amount > i.getCheckingBalance())
                    System.out.println("Sorry now enough funds in your account");
                else {
                    i.withdrawChecking(amount);
                    transaction = i.getFirstName() + " " + i.getLastName() + "Deposited : " + amount +
                            " to Checking. Remaining Balance: " + i.getCheckingBalance();
                    i.setTransaction(transaction);
                }

            }

        }

    }


}

