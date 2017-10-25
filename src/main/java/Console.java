import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    ATM atm = ATM.getInstance();
    Scanner scan = new Scanner(System.in);

    protected void frontPage(){
        System.out.print("\nWelcome\n 1) New User\n 2) Login\n 0) Exit\n");
        switch(scan.nextInt()){
            case 1:
                addUser();
                break;
            case 2:
                loginPage();
                break;
            case 0:
                return;
            default:
                frontPage();
        }
    }

    private void userPage(User user){
        System.out.print(
                "\n 1) Check balance of account\n 2) Withdraw from account\n 3) Deposit to account"+
                "\n 4) Transfer from one account to another\n 5) Print account transaction history"+
                "\n 6) Close account\n 7) Add new account\n 8) User settings\n 0) Logout\n");
        switch(scan.nextInt()){
            case 1:
                balancePrint(user);
                break;
            case 2:
                withdrawPrint(user);
                break;
            case 3:
                depositPrint(user);
                break;
            case 4:
                transferPrint(user);
                break;
            case 5:
                historyPrint(user);
                break;
            case 6:
                closeAccount(user);
                break;
            case 7:
                addAccount(user);
                break;
            case 8:
                userSettingPage(user);
                break;
            case 0:
                frontPage();
                break;
            default:
                userPage(user);
        }
    }

    private void userSettingPage(User user){
        System.out.println("\nUser Setting\n 1) Change user name\n 2) Change password\n 3) Look at all accounts\n 0) Back");
        switch(scan.nextInt()){
            case 1:
                changeUserNamePage(user);
                break;
            case 2:
                changePasswordPage(user);
                break;
            case 3:
                //lookAtAccount(user);
                break;
            case 0:
                userPage(user);
                break;
            default:
                userSettingPage(user);
        }
    }
    private void changePasswordPage(User user){
        System.out.print("Current password >> ");
        String input = scan.next();
        if(input.equalsIgnoreCase(user.getUserPassword())){
            System.out.print("New password >> ");
            input = scan.next();
            user.setUserPassword(input);
            System.out.print("Password changed");
        }else{
            System.out.print("Incorrect password");
        }
        userSettingPage(user);
    }

    private void changeUserNamePage(User user){
        System.out.print("Current user name >> ");
        String input = scan.next();
        if(input.equalsIgnoreCase(user.getUserName())){
            System.out.print("New user name >> ");
            input = scan.next();
            user.setUserName(input);
            System.out.print("User name changed\n");
        }else{
            System.out.print("Incorrect user name");
        }
        userSettingPage(user);
    }

    private void historyPrint(User user){
        Account account = enterAccount(user);
        double transaction;
        double[] history = account.getAccountHistory();
        System.out.println("Most recent at the bottom");
        for(int i = 0;i<history.length;i++){
            transaction = history[i];
            if(transaction<0){
                System.out.println("Withdrew : "+(-1*transaction));
            }else if(transaction>0){
                System.out.println("Deposit  : "+transaction);
            }
        }
        userPage(user);
    }

    private void closeAccount(User user){
        Account account = enterAccount(user);
        if(user.removeAccount(account.getAccountNum())){
            System.out.print("Account removed");
            userPage(user);
        }else{
            System.out.print("Account can not be closed");
            userPage(user);
        }
    }

    private void transferPrint(User user){
        System.out.print("From account\n");
        Account fromAccount = enterAccount(user);
        System.out.print("To account\n");
        Account toAccount = enterAccount(user);
        System.out.print("How much would you like to transfer >> ");
        double amount = scan.nextDouble();
        if(user.transfer(amount,fromAccount,toAccount)){
            System.out.print("Transfer made\n");
            userPage(user);
        }else{
            System.out.print("Transfer not possible\n");
            userPage(user);
        }
        

    }

    private void depositPrint(User user){
        Account account = enterAccount(user);
        System.out.print("Deposit amount  >> ");
        double amount = scan.nextDouble();
        if(user.deposit(amount,account)){
            System.out.print("Deposit made\n");
            userPage(user);
        }else{
            System.out.print("Deposit not possible\n");
            userPage(user);
        }
    }

    private void withdrawPrint(User user){
        Account account = enterAccount(user);
        System.out.print("Withdraw amount >> ");
        double amount = scan.nextDouble();
        if(user.withdraw(amount,account)){
            System.out.print("Withdraw made\n");
            userPage(user);
        }else{
            System.out.print("Withdraw not possible\n");
            userPage(user);
        }
    }

    private void balancePrint(User user){
        Account account = enterAccount(user);
        System.out.print("\nAccount : "+account.getAccountNum()+"\nBalance : "+ account.getBalance()+"\n");
        userPage(user);
    }

    private Account enterAccount(User user){
        System.out.print("Account number  >> ");
        int input = scan.nextInt();
        Account account;
        if(user.AccountExist(input)){
            account = user.EnterAccount(input);
            //accountPage(account);
        }else{
            System.out.print("Account does not exist");
            account = null;
            userPage(user);
        }
        return account;
    }

    private void addAccount(User user){
        System.out.print("What type of account?\n 1) Checking\n 2) Savings\n 3) Investment\n");
        char accountType;
        switch(scan.nextInt()) {
            case 1:
                accountType = 'c';
                break;
            case 2:
                accountType = 's';
                break;
            case 3:
                accountType = 'i';
                break;
            default:
                accountType = 'x';
        }
        if(accountType!= 'x') {
            int accountNum = user.addAccount(accountType);
            System.out.print("Account added\nNew account number : "+accountNum+"\n");
        }
        userPage(user);
    }


    private void addUser(){
        System.out.print("New user Name >> ");
        String userName = scan.next();
        System.out.print("New password  >> ");
        String password = scan.next();
        atm.addUser(userName,password);
        System.out.print("\nNew user added\n");
        frontPage();
    }

    private void loginPage(){
        System.out.print("User Name >> ");
        String userName = scan.next();
        System.out.print("Password  >> ");
        String password = scan.next();
        if(atm.UserExist(userName,password)) {
            User user = atm.EnterUser(userName, password);
            System.out.println("\nWelcome back "+user.getUserName());
            userPage(user);
        }else{
            System.out.print("User does not exist");
            frontPage();
        }
    }




}
