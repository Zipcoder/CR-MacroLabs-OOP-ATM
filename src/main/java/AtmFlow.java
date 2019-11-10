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
                createBankAccount();
                break;
            case 2 :
                withdraw();
                break;
            case 3 :
                //deposit
                deposit();
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
        if(!userVillage.checkUser(userName)) {
            userVillage.createUser(userName, password);
            start();
        }
        else{
            createAccount();
        }
    }

    public void createBankAccount(){
        Double amount = Console.getDoubleInput("How much would you like to deposit");
        Integer accountType = Console.getIntegerInput("Which type of Account\n" +
                "1 - Checking\n" +
                "2 - Savings \n" +
                "3 - Investment\n");
        accountVillage.createAccount(amount, accountType);
        Console.println("Account was created");
        accountStart();
    }


    public void withdraw(){
        Double withdrawAmount = Console.getDoubleInput("How much would you like to withdraw?");
        Integer account = accountPrompt();
        accountVillage.getAccountById(account).withdraw(withdrawAmount);
        Console.println("Withdrawing : " + withdrawAmount );
        promptNewBalance(account);
        accountStart();
    }
    public void deposit(){
        Double depositAmount = Console.getDoubleInput("How much would like to deposit?");
        Integer account = accountPrompt();
        accountVillage.getAccountById(account).deposit(depositAmount);
        Console.println("Depositing : " + depositAmount);
        promptNewBalance(account);
        accountStart();

    }
    /////////PROMPT//////
    public Integer accountPrompt(){
        Integer accountType = Console.getIntegerInput("Which Account \n" +
                "1 - Checking\n" +
                "2 - Savings \n" +
                "3 - Investment\n\n");
        return accountType;
    }
    public void promptNewBalance(Integer account){
        Console.println( "New Balance : " + accountVillage.getAccountById(account).getBalance() + "\n\n");
    }


}
