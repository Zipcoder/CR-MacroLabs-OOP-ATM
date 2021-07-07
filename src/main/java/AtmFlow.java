public class AtmFlow {
    UserVillage userVillage = new UserVillage();
    AccountVillage accountVillage = new AccountVillage();
    private String currentUsername = "";

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
            this.currentUsername = userName;
            accountStart();
        }
        else
            Console.println("No account found for " + userName +"\n Please create account : ");
            start();
    }

    public void accountStart(){
        accountMenu(Console.getIntegerInput("What would you like to do:\n" +
                "1 - create account\n" +
                "2 - Withdraw\n" +
                "3 - Deposit\n" +
                "4 - Transfer\n" +
                "5 - Close Account\n" +
                "6 - Log Out\n" +
                "7 - Exit\n" +
                "8 - See transaction history\n"));
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
                transfer();
                break;
            case 5 :
                //close account
                closeAccount();
                break;
            case 6 :
                this.currentUsername = "";
                start();
                break;
            case 7 :
                System.exit(0);
                break;
            case 8:
                showTransactions();
                break;
            default :
                Console.println("not an Option");
                break;
        }
    }

    public void showTransactions() {
        Integer accountId = accountPrompt();
        String history = accountVillage.getAccountById(accountId).getPrintableHistory();
        Console.println(history);
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
        Account account = accountVillage.createAccount(amount, accountType);
        Integer id = account.getAccountID();
        userVillage.getUserByUsername(currentUsername).addingAccount(id);
        Console.println("%s Account was created for %s", account.getName(), currentUsername);
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
        Double depositAmount = Console.getDoubleInput("How much would you like to deposit?");
        Integer account = accountPrompt();
        accountVillage.getAccountById(account).deposit(depositAmount);
        Console.println("Depositing : " + depositAmount);
        promptNewBalance(account);
        accountStart();

    }
    public void transfer(){
        Double transferAmount = Console.getDoubleInput("How much would you like to transfer? ");
        Integer sourceAccountId = accountPrompt();
        Integer targetAccountId = Console.getIntegerInput("Select target account id: ");
        accountVillage.getAccountById(sourceAccountId).transfer(accountVillage.getAccountById(targetAccountId),transferAmount);
    }
    /////////PROMPT//////
//    public Integer accountPrompt(){
//        Integer accountType = Console.getIntegerInput("Which Account \n" +
//                "1 - Checking\n" +
//                "2 - Savings \n" +
//                "3 - Investment\n\n");
//        return accountType;
//    }
    public void promptNewBalance(Integer account){
        Console.println( "New Balance : " + accountVillage.getAccountById(account).getBalance() + "\n\n");
    }

    public Integer accountPrompt() {
        Integer accountId;
        StringBuilder message = new StringBuilder();
        User user = userVillage.getUserByUsername(currentUsername);
        for (Integer id : user.getAccountsIds()) {
            Account account = accountVillage.getAccountById(id);
            message.append(String.format("%s : %s\n", id, account.getName()));
        }
        message.append("Choose an account to access: ");
        do {
            accountId = Console.getIntegerInput(message.toString());
        } while (!user.getAccountsIds().contains(accountId));
        return accountId;
    }

    public void closeAccount() {
        Integer accountId = accountPrompt();
        if (accountVillage.getAccountById(accountId).closeAccount()) {
            userVillage.getUserByUsername(currentUsername).removeAccount(accountId);
        }
    }

}
