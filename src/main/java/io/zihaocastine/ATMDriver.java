package io.zihaocastine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zihaocastine on 5/9/16.
 */
public class ATMDriver {
    int userNum;
    int accountNum;

    public static void main(String[] args) {
        ATMDriver atmDriver=new  ATMDriver();
        atmDriver.start();
    }
    public void start(){
        //ArrayList<Account> accountList=new ArrayList<Account>();
        ArrayList<User> users=new ArrayList<User>();
        Scanner input=new Scanner(System.in);
        int choice=-5;
        userNum =0;
        accountNum =0;
        userPrintOption();
        System.out.print("Enter: ");
        choice = input.nextByte();
        while(choice!=0) {
            switch (choice){
                case 1:users.add(createUser());
                    break;
                case 2:choiceUser(users);
                    break;
                default:
                    break;
            }
            while (choice != -1 && !users.isEmpty()) {
                accountPrintOption();
                System.out.print("Enter: ");
                choice = input.nextByte();
                switch (choice) {
                    case 1:
                        users.get(userNum).getAccountList().add(createAccount());
                        break;
                    case 2:
                        choiceAccount(users.get(userNum));
                        break;
                    case 3:
                        if(hasAccount(users.get(userNum))){
                            System.out.println("Account # " + users.get(userNum).getAccountList().get(accountNum).getAccountNumber() + " balance is " + users.get(userNum).getAccountList().get(accountNum).getBalance());
                        }
                        break;
                    case 4:
                        if(hasAccount(users.get(userNum))){
                            withdrawAccount(users.get(userNum).getAccountList().get(accountNum));
                        }
                        break;
                    case 5:
                        if(hasAccount(users.get(userNum))) {
                            depositAccount(users.get(userNum).getAccountList().get(accountNum));
                        }
                        break;
                    case 6:
                        if(hasAccount(users.get(userNum))) {
                            if (users.get(userNum).getAccountList().size() > 1) {
                                transferAccount(users.get(userNum).getAccountList().get(accountNum));
                            } else {
                                System.out.println("You will need more than one account to transfer");
                            }
                        }
                        break;
                    case 7:
                        if(hasAccount(users.get(userNum))) {
                            if (closeAccount(users.get(userNum).getAccountList().get(accountNum))) {
                                System.out.println("Account # " + users.get(userNum).getAccountList().get(accountNum).getAccountNumber() + " is now closed");
                            } else {
                                System.out.println("Account # " + users.get(userNum).getAccountList().get(accountNum).getAccountNumber() + " is unable to close due to remaining balance " + users.get(userNum).getAccountList().get(accountNum).getBalance());
                            }
                        }
                        break;
                    case 8:
                        if(hasAccount(users.get(userNum))) {
                            printAccountHistory(users.get(userNum).getAccountList().get(accountNum));
                        }
                    default:
                        break;

                }
            }
            userNum++;
            userPrintOption();
            System.out.print("Enter: ");
            choice = input.nextByte();
        }

    }
    private void userPrintOption(){
        System.out.println("Enter 0 to exit");
        System.out.println( "1) New user");
        System.out.println( "2) Existing user");
    }

    private void accountPrintOption(){
        System.out.println("Enter -1 to exit");
        System.out.println( "1) Open new account");
        System.out.println( "2) Existing account");
        System.out.println( "3) Check balance");
        System.out.println( "4) Withdraw from account");
        System.out.println( "5) Deposit to account");
        System.out.println( "6) Transfer across accounts (self)");
        System.out.println( "7) Close account (must be empty)");
        System.out.println( "8) Print transaction history");
       
    }

    private Account createAccount(){
        Account account;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the type of account (c for checking, s for saving, i for investment");
        String type=input.next();
        System.out.println("Enter an account number");
        int number=input.nextInt();
        System.out.println("Enter the name of the account");
        String name=input.nextLine();
        input.nextLine();
        System.out.println("Enter the balance of the account");
        int balance=input.nextInt();
        switch (type.toLowerCase()){
            case "c": account =new Account(Account.AccountType.CHECKING, number,name,balance);
                break;
            case "s": account =new Account(Account.AccountType.SAVING, number,name,balance);
                break;
            case "i": account =new Account(Account.AccountType.INVESTMENT, number,name,balance);
                break;
            default: account =new Account(Account.AccountType.CHECKING, number,name,balance);
                break;
        }

        return account;
    }

    private  boolean hasAccount(User user){
        if(user.getAccountList().size()>0){
            return true;
        }else{
            System.out.println("You don't have any account under this user");
            return false;
        }

    }

    private User createUser(){
        User user;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter username: ");
        String username=input.nextLine();
        System.out.println("Enter password: ");
        String password=input.next();
        user=new User(username,password);

        return user;
    }

    private void withdrawAccount(Account account){
        double amount=0;
        Scanner input= new Scanner(System.in);
        System.out.print("Enter the amount you want to withdrawal: ");
        amount=input.nextDouble();
        Transaction transaction=new Transaction(Transaction.TransactionType.WITHDRAWALS,amount,account,null);
        transaction.makeTransaction();
    }

    private void depositAccount(Account account){
        double amount=0;
        Scanner input= new Scanner(System.in);
        System.out.print("Enter the amount you want to deposit: ");
        amount=input.nextDouble();
        Transaction transaction=new Transaction(Transaction.TransactionType.DEPOSITS,amount,account,null);
        transaction.makeTransaction();
    }

    private void transferAccount(Account account){
        double amount=0;
        System.out.println("Enter the account you want to transfer");
        Account accountTo =createTempAccount();
        Scanner input= new Scanner(System.in);
        System.out.print("Enter the amount you want to transfer: ");
        amount=input.nextDouble();
        Transaction transaction=new Transaction(Transaction.TransactionType.TRANSFERS,amount,account,accountTo);
        transaction.makeTransaction();
    }

    private boolean closeAccount(Account account){
        if(account.getBalance()==0){
            account.changeStatus(Account.Status.CLOSED);
            return true;
        }else {
            return false;
        }
    }

    private void printAccountHistory(Account account){
        System.out.println(account.getRecord().toString());

    }

    private void choiceUser(ArrayList<User> users){
       // users.equals(createUser());

        User tempUser=createUser();
        for (User each: users ) {
            if( each.getUsername().equals(tempUser.getUsername())&& each.getPassword().equals(tempUser.getPassword())){
                userNum =users.indexOf(each);
            }
        }
    }

    private void choiceAccount(User user){
        Account tempAccount=createTempAccount();
        for (Account each: user.getAccountList() ) {
            if( each.getAccountType().equals(tempAccount.getAccountType())&& each.getAccountNumber() ==tempAccount.getAccountNumber()){
                accountNum =user.getAccountList().indexOf(each);
            }
        }

    }

    private Account createTempAccount(){
        Account tempAccount;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the type of account (c for checking, s for saving, i for investment");
        String type=input.next();
        System.out.println("Enter an account number");
        int number=input.nextInt();
        System.out.println("Enter the name of the account");
        String name=input.nextLine();
        input.nextLine();
        switch (type.toLowerCase()){
            case "c": tempAccount =new Account(Account.AccountType.CHECKING, number,name);
                break;
            case "s": tempAccount =new Account(Account.AccountType.SAVING, number,name);
                break;
            case "i": tempAccount =new Account(Account.AccountType.INVESTMENT, number,name);
                break;
            default: tempAccount =new Account(Account.AccountType.CHECKING, number,name);
                break;
        }

        return tempAccount;
    }

}
