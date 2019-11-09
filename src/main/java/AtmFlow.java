public class AtmFlow {
    UserVillage userVillage = new UserVillage();
    AccountVillage accountVillage = new AccountVillage();

    public  void start(){
        mainMenu(Console.getIntegerInput("Welcome to ATM FLOWTISTIC!\n" +
                "1 - Log In\n" +
                "2 - Create Account\n" +
                "3 - Quit"));
    }

    public void mainMenu(Integer choice){
        switch(choice){
            case 1 :
                logIn();
                break;
            case 2 :
                createAccount();
                break;
            case 3 :

                break;
            default :
                Console.println("Not an Option, choose again");
                break;
        }
    }
    //////LOGIN METHODS/////
    public void logIn(){
        String userName = Console.getStringInput("Enter a Username?");
        String password = Console.getStringInput("Enter a password?");

        if(userVillage.checkLogIn(userName, password)){
            accountStart();
        }
        else
            logIn();
    }

    public void accountStart(){
        accountMenu(Console.getIntegerInput("What would you like to do:\n" +
                "1 - create account\n" +
                "2 - Withdraw\n" +
                "3 - Deposit\n" +
                "4 - Transfer\n" +
                "5 - Close Account\n" +
                "6 - Log Out\n" +
                "7 - Exit"));
    }

    public void accountMenu(Integer choice){
        switch(choice){
            case 1 :
                //create account
                break;
            case 2 :
                //withdraw
                break;
            case 3 :
                //deposit
                break;
            case 4 :
                //transfer
                break;
            case 5 :
                //close account
                break;
            case 6 :
                start();
                break;
            case 7 :
                System.exit(0);
                break;
            default :
                Console.println("not an Option");
                break;
        }
    }

    public void createAccount(){
        String userName = Console.getStringInput("Enter a Username?");
        String password = Console.getStringInput("Enter a password?");
        if(userVillage.checkUser(userName))
            userVillage.createUser(userName, password);
        else{
            createAccount();
        }
        start();
    }



}
