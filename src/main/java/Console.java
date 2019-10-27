

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    ///VARIABLES///
    private Scanner input = new Scanner(System.in);

    private ArrayList<User> userDataBase = new ArrayList<User>();
    private AccountActions account = new AccountActions(userDataBase);

    private Boolean power = true;
    private Boolean loginScreen = true;
    private Boolean mainMenu = true;

    public String currentUser;

    public void atmStarter (){

        /////////////////////////tester ID///////////////////////
        userDataBase.add(new User("Chung", "Arguello", "1","1"));

        ////ATM WELCOME MESSAGE////
        System.out.println("\n\n\n" +
                "RRRRRR  HH   HH  OOOOO   SSSSS                               dd \n" +
                "RR   RR HH   HH OO   OO SS        qqqqq uu   uu   aa aa      dd \n" +
                "RRRRRR  HHHHHHH OO   OO  SSSSS  qq   qq uu   uu  aa aaa  dddddd \n" +
                "RR  RR  HH   HH OO   OO      SS  qqqqqq uu   uu aa  aaa dd   dd \n" +
                "RR   RR HH   HH  OOOO0   SSSSS       qq  uuuu u  aaa aa  dddddd \n" +
                "                                     qq                         \n" +
                "                                                                \n" +
                "                   Welcome to Rho Squad Bank!                     ");
        Integer userOption;
        Integer mainOption;



        while(power){
            userOption = loginPrompt();
            switch(userOption){
                case 1:
                    ///////////////
                    while(loginScreen){
                        mainMenu = true;
                        if(login()) {
                            System.out.println("login successful\n\n");


                            while(mainMenu){
                                mainOption = mainMenu();

                                switch(mainOption){
                                    case 1 :
                                        account.deposit(currentUser, accountChoice("deposit to"));
                                        break;
                                    case 2 :
                                        account.withdraw(currentUser, accountChoice("withdraw from"));
                                        break;
                                    case 3 :
                                    //    account.transfer(currentUser, accountChoice("transfer from"), accountChoice("transfer to"));
                                        break;
                                    case 4 :
                                       // account.checkHistory(currentUser, accountChoice("review"));
                                        break;
                                    case 5 :
                                       // account.check(currentUser, accountChoice("check"));
                                        break;
                                    case 6 :
                                       // account.close(currentUser, accountChoice("close"));
                                        break;
                                    case 7 :
                                        mainMenu = false;
                                        break;
                                    case 8 :
                                        mainMenu = false;
                                        loginScreen= false;
                                        power = false;
                                        break;
                                    default:
                                        System.out.println("\nNot an option, try again\n");
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    userDataBase.add(accountCreation());
                    break;
                case 3:
                    power = false;
                    break;
                default:
                    System.out.println("\nNot an option, try again\n");
            }
        }
    }
    //////////////////////STARTER SCREEN ////////////
    ///////////////////////////////////////////////

    private int loginPrompt(){
        int result = 0;
        String choice = "";


        System.out.println("Choose your option\n" +
                "1 - Log in\n" +
                "2 - Create Account\n" +
                "3 - Exit");

        result = input.nextInt();
//        do{
//
//            try{
//                result = Integer.parseInt(choice);
//
//            }catch(NumberFormatException e){
//                System.out.println("Not a valid option\n");
//
//            }
//
//        }while(!input.hasNextInt());

        return result;
    }
    //////////////////////LOGIN MENU  options 1 ////////////
    ///////////////////////////////////////////////
    private boolean login(){
        String userID;
        String userPassword;
        do {

            System.out.println("Username: ");
            userID = input.next();
            currentUser = userID;
            System.out.println("Password: ");
            userPassword = input.next();

        }while(!loginCheck(userID, userPassword));

        if(loginCheck(userID, userPassword))
            return true;

        return false;

    }

    private boolean loginCheck(String userID, String password){

        for(User i : userDataBase){
            if(i.getUserID().equals(userID) && i.getUserPassword().equals(password))
                return true;
        }
        System.out.println("Username or Password does not match our records");

        return false;
    }

    ////////////////////////MAIN MENU///////////////////
    /////////////////////////////////////////////////////
    private int mainMenu(){
        int result;
        System.out.println("What would you like to do today?\n" +
                "1 - Deposit\n" +
                "2 - Withdraw\n" +
                "3 - Transfer\n" +
                "4 - Transaction History\n" +
                "5 - Check Balance\n" +
                "6 - Close Account\n" +
                "7 - Log Out\n" +
                "8 - Exit\n");

        result = input.nextInt();

        return result;
    }
    /////////////////CREATE ACCOUNT options 2//////////
    //////////////////////////////////////////

     private User accountCreation(){
        String first_name;
        String last_name;
        String user_ID;
        String user_password;
        String user_passwordConfirmation;

        System.out.println("Lets create your account, please provide the following information");
        System.out.println("First name: ");
        first_name = input.next();
        System.out.println("Last name: ");
        last_name = input.next();
        System.out.println("Username: ");
        user_ID = input.next();
        do{
            System.out.println("Password: ");
            user_password = input.next();
            System.out.println("Confirm Password: ");
            user_passwordConfirmation = input.next();

            if(!user_password.equals(user_passwordConfirmation))
                System.out.println("\npassword did not match, please try again");


        }while(!user_password.equals(user_passwordConfirmation));

        System.out.println("Thank You, your account has been created, Keep your username and password safe\n\n");

        return new User(first_name, last_name, user_ID, user_password);
    }

    /////////////////CREATE ACCOUNT options 2//////////
    //////////////////////////////////////////

    public int accountChoice(String action){
        System.out.println("Which account would you like to " + action + " today?\n"+
                            "1 - Checking Account\n"+
                            "2 - Savings Account\n"+
                            "3 - Investment Account\n");
        return input.nextInt();
    }

}

