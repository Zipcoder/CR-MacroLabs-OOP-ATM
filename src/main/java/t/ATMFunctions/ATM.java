package t.ATMFunctions;

import t.Accounts.Console;

public class ATM {

    public void start() {

        System.out.println("Welcome to Zip Code Wilmington Federal Credit Union.\n");
        int userInput = Console.getIntInput("If you have an account please input '1' if you do not have an account please input '2'.");
        boolean terminator = false;

        while(terminator!=false) {
            switch (userInput) {
                case 1:
                    //call login method
                    break;
                case 2:
                    //call create new user method from user factory
                    break;
                default:
                    System.out.println("Please enter a correct response.\n");
                    userInput = Console.getIntInput("If you have an account please input '1' if you do not have an account please input '2'.");
                    continue;
            }
            terminator = false;
        }










        /*System.out.println("Welcome to the ATM Machine.\n");
        System.out.println("From here you have several options.");
        printOptions();
        String userInput = Terminal.getStringInput("Enter the command that you would like to execute.");
        switch (userInput) {
            case "WITHDRAW":
                Withdraw withdraw = new Withdraw();
                break;

            case "DEPOSIT":
                break;

            case "TRANSFER":
                break;

            case "OPEN NEW ACCOUNT":
                break;

            case "CLOSER ACCOUNT":
                break;

            case "PRINT TRANSACTION HISTORY":
                break;

            case "CHECK BALANCE":
                break;

            default:
                System.out.println("Please enter an appropriate command.");
                break;
        }
    }

    private void printOptions() {
        System.out.println("WITHDRAW\nDEPOSIT\nTRANSFER\nOPEN NEW ACCOUNT\nCLOSE ACCOUNT\nPRINT TRANSACTION HISTORY\nCHECK BALANCE\n");*/


    }
}
