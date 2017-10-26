//package com.company;
//
//import java.util.Scanner;
//
//public class Console {
//
//    public static void main(String[] args) {
//
//        Scanner userInput = new Scanner(System.in);
//
//
//        //User log-in interface:
//        System.out.println("Existing user? Select '1' to log-in;\n" +
//                " New user? Select '2' to create a new account");
//
//        int loginReply = userInput.nextInt();
//        if (loginReply == 1) {
//            System.out.println("Please enter your username");
//        } else {
//            /*need to setup Account Factory*/
//        }
//
//        String username = userInput.nextLine();
//        if (username.equalsIgnoreCase(/*need to setup username system*/)) {
//            System.out.println("Please enter your password");
//        } else {
//            System.out.println("Incorrect username, please try again");
//        }
//
//        String password = userInput.nextLine();
//        if (password.equalsIgnoreCase(/*need to setup password system*/)) {
//            //if password accepted need to take user to user account selection stage
//        } else {
//            System.out.println("Incorrect password, please try again");
//        }
//
//
//        //User account interactions/transactions:
//        while ( boolean exit !=false){
//            System.out.println("Choose an account:\n " +
//                    "Select '1' for Checking\n " +
//                    "Select '2' for Savings\n " +
//                    "Select '3' for Investment\n" +
//                    "Select '4' to log-out and exit this session");
//            int chooseAccountReply = userInput.nextInt();
//            if (chooseAccountReply == 1) {
//                //call checking
//                int chooseTransactionReply = userInput.nextInt();
//                System.out.println("Choose a transaction type or option: " +
//                        "Select '1' to withdraw from your account\n " +
//                        "Select '2' to deposit into your account\n" +
//                        "Select '3' to transfer funds to another account\n" +
//                        "Select '4' to view your transaction history\n" +
//                        "Select '5' to show your account balance\n" +
//                        "Select '6' to log-out and exit this session");
//                if (chooseTransactionReply == 1) {
//                    //call to withdraw from checking
//                }
//                if (chooseTransactionReply == 2) {
//                    //call to deposit to checking
//                }
//                if (chooseTransactionReply == 3) {
//                    //call to transfer from checking to subsequent chosen account
//                }
//                if (chooseTransactionReply == 4) {
//                    //call to view transaction history
//                }
//                if (chooseTransactionReply == 5) {
//                    //call to show checking account balance
//                }
//                if (chooseTransactionReply == 6) {
//                    exit = false;
//                    //log-out user and clear console
//                }
//            }
//            if (chooseAccountReply == 2) {
//                //call savings
//                int chooseTransactionReply2 = userInput.nextInt();
//                System.out.println("Choose a transaction type or option: " +
//                        "Select '1' to withdraw from your account\n " +
//                        "Select '2' to deposit into your account\n" +
//                        "Select '3' to transfer funds to another account\n" +
//                        "Select '4' to view your transaction history\n" +
//                        "Select '5' to show your account balance\n" +
//                        "Select '6' to log-out and exit this session");
//                if (chooseTransactionReply2 == 1) {
//                    //call to withdraw from savings
//                }
//                if (chooseTransactionReply2 == 2) {
//                    //call to deposit to savings
//                }
//                if (chooseTransactionReply2 == 3) {
//                    //call to transfer from savings to subsequent chosen account
//                }
//                if (chooseTransactionReply2 == 4) {
//                    //call to view transaction history
//                }
//                if (chooseTransactionReply2 == 5) {
//                    //call to show savings balance
//                }
//                if (chooseTransactionReply2 == 6) {
//                    exit = false;
//                    //log-out user and clear console
//                }
//
//            }
//            if (chooseAccountReply == 3) {
//                //call investment
//                int chooseTransactionReply3 = userInput.nextInt();
//                System.out.println("Choose a transaction type or option: " +
//                        "Select '1' to withdraw from your account\n " +
//                        "Select '2' to deposit into your account\n" +
//                        "Select '3' to transfer funds to another account\n" +
//                        "Select '4' to view your transaction history\n" +
//                        "Select '5' to show your account balance\n" +
//                        "Select '6' to log-out and exit this session");
//                if (chooseTransactionReply3 == 1) {
//                    //call to withdraw from investment
//                }
//                if (chooseTransactionReply3 == 2) {
//                    //call to deposit to investment
//                }
//                if (chooseTransactionReply3 == 3) {
//                    //call to transfer from investment to subsequent chosen account
//                }
//                if (chooseTransactionReply3 == 4) {
//                    //call to view transaction history
//                }
//                if (chooseTransactionReply3 == 5) {
//                    //call to show investment account balance
//                }
//                if (chooseTransactionReply3 == 6) {
//                    exit = false;
//                    //log-out user and clear console
//                }
//            }
//            if (chooseAccountReply == 4) {
//                exit = false;
//                //log-out user and clear console
//
//            }
//
//
//        }
//
//    }
//
//}
