package atmproject;


import atmproject.accounts.Account;


public class MainMenu {
    private Console console = new Console(System.in, System.out);
    private User currentUser;
    private boolean running = true;
    private AccountMenu accountMenu = new AccountMenu();
    private Language language = new Language();


    public void runMainMenu(User currentUser) {
        setCurrentUser(currentUser);
        while (running) {
            console.println(language.getLang(Language.LangKey.MAINMENU));
            Integer userInput = console.getIntegerInput(":");
            mainMenuLogic(userInput);
        }
    }

    public String callDeposit() {
        Account chosenAccount = accountMenu.selectAccount(currentUser);
        console.println("How much would you like to deposit?");
        Double userInput = console.getDoubleInput(":");
        chosenAccount.deposit(userInput);
        return String.format("You deposited $%f.0 to %s.", userInput, chosenAccount.getAccountName());
    }

    public String callWithdraw() {
        Account chosenAccount = accountMenu.selectAccount(currentUser);
        console.println("How much would you like to withdraw?");
        Double userInput = console.getDoubleInput(":");
        chosenAccount.withdraw(userInput);
        if(userInput <= chosenAccount.getBalance()){
            return String.format("You withdrew $%f.0 from %s.\n", userInput, chosenAccount.getAccountName());
        }
        return "ERROR: insufficient funds for withdraw.\n";
    }

    public String callTransfer(){
        Account chosenAccount = accountMenu.selectAccount(currentUser);
        Account destinationAccount = accountMenu.selectAccount(currentUser);
        if(chosenAccount.equals(destinationAccount)){
            return "ERROR: Incorrect account entry\n";
        } else {
            console.println("How much would you like to transfer?");
            Double userInput = console.getDoubleInput(":");
            chosenAccount.transfer(destinationAccount, userInput);
            if(userInput <= chosenAccount.getBalance()){
                return String.format("You transferred $%f.0 from %s t0 %s.\n",userInput, chosenAccount.getAccountName(), destinationAccount.getAccountName());
            }
            return "ERROR: insufficient funds for transfer.\n";
        }
    }

    public String checkBalance() {
        Account chosenAccount = accountMenu.selectAccount(currentUser);
        return String.format("The balance in %s is $%f.0\n", chosenAccount.getAccountName(), chosenAccount.getBalance());
    }

    public String displayHistory() {
        if(currentUser.getTransactionHistory().isEmpty()){
            return "You currently have no history, please";
        }
        return currentUser.displayHistory();
    }

    public void returnTOLoginMenu() {
        running = false;
    }



    public void mainMenuLogic(Integer userInput){
        switch (userInput) {
            case 1:
                String transaction = callDeposit();
                console.println(transaction);
                currentUser.addToHistory(transaction);
                break;
            case 2:
                transaction = callWithdraw();
                console.println(transaction);
                currentUser.addToHistory(transaction);
                break;
            case 3:
                transaction = callTransfer();
                console.println(transaction);
                currentUser.addToHistory(transaction);
                break;
            case 4:
                console.println(checkBalance());
                break;
            case 5:
                console.println(displayHistory());
                break;
            case 6:
                returnTOLoginMenu();
                break;
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}