package fountain.donald.atmproject.RoughCopy.Accounts;

import fountain.donald.atmproject.RoughCopy.ATMFunctions.Console;
import fountain.donald.atmproject.RoughCopy.User.UserWarehouse;


public abstract class Accounts {



    private String createAccount(int userInput) {

        //userInput = Console.getIntInput("Please input what type of account you'd like to create.\n" +
                //"Please enter '1' for checking account, enter '2' for savings account and enter'3' for an investment account.");

        boolean terminator = false;

        while (terminator = true) {
            switch (userInput) {
                case 1:
                    //create a checking account
                    break;
                case 2:
                    //create a savings account
                    break;
                case 3:
                    //create an investment account
                default:
                    System.out.println("Please enter a correct response.\n");
                    userInput = Console.getIntInput("Please enter '1' for checking account, enter '2' for savings account and enter'3' for an investment account.");
                    continue;
            }
            terminator = false;
        }
        return ""; //what type of account they created
    }

    private String deleteAccount() {
        int userInput = Console.getIntInput("Please input what type of account you'd like to delete.\n" +
                "Please enter '1' for checking account, enter '2' for savings account and enter'3' for an investment account.");

        boolean terminator = false;

        while (terminator = true) {
            switch (userInput) {
                case 1:
                    //delete a checking account
                    break;
                case 2:
                    //delete a savings account
                    break;
                case 3:
                    //delete an investment account
                default:
                    System.out.println("Please enter a correct response.\n");
                    userInput = Console.getIntInput("Please enter '1' for checking account, enter '2' for savings account and enter'3' for an investment account.");
                    continue;
            }
            terminator = false;
        }
        return "";//what account they just delete
    }

    private String viewAccount() {
        int userInput = Console.getIntInput("Please input what type of account you'd like to view.\n" +
                "Please enter '1' for checking account, enter '2' for savings account and enter'3' for an investment account.");

        boolean terminator = false;

        while (terminator = true) {
            switch (userInput) {
                case 1:
                    //view a checking account
                    break;
                case 2:
                    //view a savings account
                    break;
                case 3:
                    //view an investment account
                default:
                    System.out.println("Please enter a correct response.\n");
                    userInput = Console.getIntInput("Please enter '1' for checking account, enter '2' for savings account and enter'3' for an investment account.");
                    continue;
            }
            terminator = false;
        }
        return "";//the info for the account they chose to view
    }

    private void transferBetweenAccounts() {
        int userInput = Console.getIntInput("Please input which accounts that you'd like to transfer money between.\n" +
                "Please indicate what account you'd like to transfer FROM by\n" +
                " entering '1' for checking account, entering '2' for savings account and entering'3' for an investment account.");

        boolean terminator = false;

        while (terminator = true) {
            switch (userInput) {
                case 1:
                    //view checking account balance
                    break;
                case 2:
                    //view savings account balance
                    break;
                case 3:
                    //view investment account balance
                default:
                    System.out.println("Please enter a correct response.\n");
                    userInput = Console.getIntInput("Please enter '1' for checking account, enter '2' for savings account and enter'3' for an investment account.");
                    continue;
            }
            terminator = false;
        }

            userInput += Console.getIntInput("Please indicate what account you'd like to transfer TO by\n" +
                    " entering '1' for checking account, entering '2' for savings account and entering'3' for an investment account.");

            while (terminator = true) {
                switch (userInput) {
                    case 1:
                        //view checking account balance
                        break;
                    case 2:
                        //view savings account balance
                        break;
                    case 3:
                        //view investment account balance
                    default:
                        System.out.println("Please enter a correct response.\n");
                        userInput = Console.getIntInput("Please enter '1' for checking account, enter '2' for savings account and enter'3' for an investment account.");
                        continue;
                }
                terminator = false;

                //call view method to show user account information for both accounts

                int amountToTransfer = Console.getIntInput("How much money would you like to transfer between accounts?");

                //transfer the desired amount between specified accounts

            }
    }
    private String depositMoney(){

        int userInput = Console.getIntInput("Please indicate which account you'd like to deposit money into.\n" +
                "Please enter '1' for checking account, enter '2' for savings account and enter'3' for an investment account.");

        boolean terminator = false;

        while (terminator = true) {
            switch (userInput) {
                case 1:
                    //view checking account balance
                    break;
                case 2:
                    //view savings account nalance
                    break;
                case 3:
                    //view investment account balance
                default:
                    System.out.println("Please enter a correct response.\n");
                    userInput = Console.getIntInput("Please enter '1' for checking account, enter '2' for savings account and enter'3' for an investment account.");
                    continue;
            }
            terminator = false;

            int amountToDeposit = Console.getIntInput("How much money would you like to deposit?");

            //call method to deposit indicated amount into indicated account
        }
        return "";//new account balance
    }

    private String withDrawMoney(){

    int userInput = Console.getIntInput("Please indicate which account you'd like to withdraw money from.\n" +
            "Please enter '1' for checking account, enter '2' for savings account and enter'3' for an investment account.");

    boolean terminator = false;

    while (terminator = true) {
        switch (userInput) {
            case 1:
                //view checking account balance
                break;
            case 2:
                //view savings account nalance
                break;
            case 3:
                //view investment account balance
            default:
                System.out.println("Please enter a correct response.\n");
                userInput = Console.getIntInput("Please enter '1' for checking account, enter '2' for savings account and enter'3' for an investment account.");
                continue;
        }
        terminator = false;

        int amountToDeposit = Console.getIntInput("How much money would you like to withdraw?\n" +
                "All withdraw requests must be in $20 and no more than $600.");

        //call method to withdraw indicated amount from indicated account
    }
    return "";//new account balance
    }

    private void interestedAccrued() {

        int userInput = Console.getIntInput("Please indicate which account you'd like to view accrued interest.\n" +
                "Please enter '1' for checking account, enter '2' for savings account and enter'3' for an investment account.");

        boolean terminator = false;

        while (terminator = true) {
            switch (userInput) {
                case 1:
                    //view checking account interest
                    break;
                case 2:
                    //view savings account interest
                    break;
                case 3:
                    //view investment account insterest
                default:
                    System.out.println("Please enter a correct response.\n");
                    userInput = Console.getIntInput("Please enter '1' for checking account, enter '2' for savings account and enter'3' for an investment account.");
                    continue;
            }
            terminator = false;

        }
    }
    public static void userLogin(){

        String userInput = Console.getStringInput("Please enter your first and last name, account number, and password");

        if(UserWarehouse.getUsers().equals(userInput)){
            //get user accounts
        }

    }
}