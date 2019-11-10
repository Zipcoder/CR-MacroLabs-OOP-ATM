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

    public void callDeposit() {
        Account chosenAccount = accountMenu.selectAccount(currentUser);
        Double userInput;
        console.println("How much would you like to deposit?");
        userInput = console.getDoubleInput(":");
        chosenAccount.deposit(userInput);

    }

    public void callWithdraw() {
        Account chosenAccount = accountMenu.selectAccount(currentUser);
        Double userInput;
        console.println("How much would you like to withdraw?");
        userInput = console.getDoubleInput(":");
        chosenAccount.withdraw(userInput);

    }

    public void callTransfer() {
        Account chosenAccount;
        chosenAccount = accountMenu.selectAccount(currentUser);
        console.println("The balance in %s is $%f.0", chosenAccount.getAccountName(), chosenAccount.getBalance());
    }

    public void checkBalance() {
        
    }

    public void displayHistory() {
        console.println(currentUser.displayHistory());

    }

    public void returnTOLoginMenu() {
        running = false;

    }



    public void mainMenuLogic(Integer userInput){

        switch (userInput) {
            case 1:
                callDeposit();
                break;
            case 2:
                callWithdraw();
                break;
            case 3:
                callTransfer();
                break;
            case 4:
                checkBalance();
                break;
            case 5:
                displayHistory();
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



































