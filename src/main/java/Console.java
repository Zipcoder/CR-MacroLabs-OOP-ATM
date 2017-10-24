import java.util.Scanner;

public class Console {
    ATM atm = ATM.getInstance();
    Scanner scan = new Scanner(System.in);

    public void frontPage(){
        System.out.println("Welcome\n 1) New User\n 2) Login\n-1) Exit");
        switch(scan.nextInt()){
            case 1:
                addUser();
                break;
            case 2:
                loginPage();
                break;
            default:
                return;
        }
    }

    public void userPage(User user){
        System.out.println("Welcome back"+user.getUserName()+
                "\n 1) Check balance of account\n 2) Withdraw from account\n 3) Deposit to account"+
                "\n 4) Transfer from one account to another\n 5) Print account transaction history"+
                "\n 6) Close account\n 7) Add new account\n-1) Back");
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

                break;
            case 6:
                closeAccount(user);
                break;
            case 7:
                addAccount(user);
                break;
            default:
                frontPage();
        }
    }

    public void closeAccount(User user){
        Account account = enterAccount(user);
        if(user.removeAccount(account.getAccountNum())){
            System.out.println("Account removed");
            userPage(user);
        }else{
            System.out.println("Account can not be closed");
            userPage(user);
        }
    }

    public void transferPrint(User user){
        System.out.println("From account");
        Account fromAccount = enterAccount(user);
        System.out.println("to account");
        Account toAccount = enterAccount(user);
        double amount = scan.nextDouble();
        if(user.transfer(amount,fromAccount,toAccount)){
            System.out.println("Transfer made");
            userPage(user);
        }else{
            System.out.println("Transfer not possible");
            userPage(user);
        }


    }

    public void depositPrint(User user){
        Account account = enterAccount(user);
        System.out.println("Deposit amount >>");
        double amount = scan.nextDouble();
        if(user.deposit(amount,account)){
            System.out.println("Deposit made");
            userPage(user);
        }else{
            System.out.println("Deposit not possible");
            userPage(user);
        }
    }

    public void withdrawPrint(User user){
        Account account = enterAccount(user);
        System.out.println("Withdraw amount >>");
        double amount = scan.nextDouble();
        if(user.withdraw(amount,account)){
            System.out.println("Withdraw made");
            userPage(user);
        }else{
            System.out.println("Withdraw not possible");
            userPage(user);
        }
    }

    public void balancePrint(User user){
        Account account = enterAccount(user);
        System.out.println("Account : "+account.getAccountNum()+"\nBalance : "+ account.getBalance());
    }

    public Account enterAccount(User user){
        System.out.println("Account number >> ");
        int input = scan.nextInt();
        Account account;
        if(user.AccountExist(input)){
            account = user.EnterAccount(input);
            //accountPage(account);
        }else{
            System.out.println("Account does not exist");
            account = null;
            userPage(user);
        }
        return account;
    }

    public void addUser(){
        System.out.println("New user Name >>");
        String userName = scan.next();
        System.out.println("New password >>");
        String password = scan.next();
        atm.addUser(userName,password);
    }

    public void loginPage(){
        System.out.println("User Name >>");
        String userName = scan.next();
        System.out.println("Password >>");
        String password = scan.next();
        if(atm.UserExist(userName,password)) {
            User user = atm.EnterUser(userName, password);
            userPage(user);
        }else{
            System.out.println("User does not exist");
            frontPage();
        }
    }

    public void addAccount(User user){
        System.out.println("What type of account?\n 1) Checkings\n 2)Savings\n 3) Investment");
        char accountType;
        switch(scan.nextInt()){
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
                if(accountType!= 'x') {
                    user.addAccount(accountType);
                    System.out.println("Account added");
                }
                userPage(user);

        }
    }


}
