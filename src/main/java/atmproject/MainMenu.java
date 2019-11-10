package atmproject;


import atmproject.accounts.Account;

public class MainMenu {
    private Console console = new Console(System.in, System.out);
    private User currentUser;



    private boolean running = true;
    private AccountMenu accountMenu = new AccountMenu();


    public void runMainMenu(User currentUser) {
       setCurrentUser(currentUser);
        while (running) {
            console.println("please select your option");
            console.println("(1) - Deposit");
            console.println("(2) - Withdraw");
            console.println("(3) - Transfer");
            console.println("(4) - Balance");
            console.println("(5) - View History");
            console.println("(6) - Return To Login Menu");
            Integer userInput = getUserInput();
            mainMenuLogic(userInput);
        }


    }
    private Double getUserDoubleInput(){
        return console.getDoubleInput(":");
    }
    private Integer getUserInput(){
        return console.getIntegerInput(":");
    }

    public void callDeposit() {
        Account chosenAccount;
        Double userInput;
        chosenAccount = accountMenu.selectAccount(currentUser);
        console.println("How much would you like to deposit?");
        userInput = getUserDoubleInput();
        chosenAccount.deposit(userInput);

    }

    public void callWithdraw() {
        Account chosenAccount;
        Double userInput;
        chosenAccount = accountMenu.selectAccount(currentUser);
        console.println("How much would you like to withdraw?");
        userInput = getUserDoubleInput();
        chosenAccount.withdraw(userInput);

    }

    public void callTransfer() {

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



































