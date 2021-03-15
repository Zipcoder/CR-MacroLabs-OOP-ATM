public class Workflow {

    Display d;
    Console c;
    String lastAction;
    Double lastAmount;

    public Workflow(){
        d = new Display();
        c = new Console();
        lastAction = "";
        lastAmount = 0.0;
    }

    public void errorSP(){
        d.currentDisplaySP("\nImproper input. Please reread instructions.\n");
    }

    public void initialWelcomeSP(){
        d.currentDisplaySP("\nWelcome to the ATM!\nATM maintained by Xiong, Mike, Hazel, and Lena\n\nAre you a new or returning user?\nEnter 1 for new, 2 for returning.");
    }

    public Integer getInput(){
        return c.getIntegerInput("Enter your input:");
    }



    //include input for customername
    public void newCustomerNameSP(){
        d.currentDisplaySP("Enter 0 to return back to home page.");
    }
    public String getCustomerNameSP(){
        return c.getStringInput(("\nEnter your name here"));
    }

    public void usernameTakenSP(){
        d.currentDisplaySP("Username is already taken. Please try again.");
    }
    //initial opening of an account + deposit. double and string

    public void newUserSP(){
        d.currentDisplaySP("Input your username, then password twice.\nEnter 0 to return back to home page");
    }

    public void passwordMismatchSP(){
        d.currentDisplaySP("\nPasswords do not match. Please try again.");
    }

    public void returningUserSP(){
        d.currentDisplaySP("\nInput your username, then password.\nEnter 0 to return back to home page.");
    }

    public String getUserSP(){
        String middleMan = c.getStringInput("\nEnter username:");
        d.setTransactionHistory("History of user " + middleMan + "\n");
        return middleMan;
    }
    public String getUserSP2(){
        return c.getStringInput("\nEnter username:");

    }

    public String getPassSP(){
        return c.getStringInput("Enter password:");
    }

    public String getNameSP(){
        return "";
    }

    public void initialAccountOpen(){
        //user input double and string
    }



    public void mainMenuSP(Customer customer){
        d.currentDisplaySP("Welcome, " + customer.getCustomerName() + "! What do you want to do?\n" +
                "\n" +
                "Enter 0 to check account number\t\t\t\t\tEnter 1 to check balance\n" +
                "Enter 2 to transfer\t\t\t\t\t\t\t\tEnter 3 to withdraw\n" +
                "Enter 4 to deposit\t\t\t\t\t\t\t\tEnter 5 to open a new account\n" +
                "Enter 6 to close an account\t\t\t\t\t\tEnter 7 to print transaction history\n" +
                "Enter 8 to transfer to a different user\t\t\tEnter 9 to log out\n");
    }

    public int enterAccount(){
        return c.getIntegerInput("Enter an account:");
    }

    public String enterAccountType(){
        return c.getStringInputNotCaseSensitive("Enter an account:");
    }

    public void checkPromptSP(){
        d.currentDisplaySP("What account do you want to check?");
    }

    public void checkResultSP(Account account){
        d.currentDisplaySP("Your account's current balance is " + account.getBalance());
    }

    public void withdrawPromptSP(){
        d.currentDisplaySP("What account do you want to withdraw from?");
        lastAction = " withdrawn from ";
    }

    public void depositPromptSP(){
        d.currentDisplaySP("What account do you want to deposit into?");
        lastAction = " deposited into ";
    }

    public void transferPromptSP(){
        d.currentDisplaySP("What accounts do you want to transfer from and to?");
        lastAction = " transferred from ";
    }

    public void transfer2UserPromptSP(){
        d.currentDisplaySP("What account do you want to transfer to?");
        lastAction = " transferred from ";
    }

    public Double amountPromptSP(){
        //try catch
        lastAmount = c.getDoubleInput("Transaction amount:");
        return lastAmount;
    }

    public void completeResultSP(Account account){
        d.currentDisplaySP("Action performed successfully.\n");
        d.addToTransactionHistory(String.format("$ %s %s account #%s\n", lastAmount, lastAction, account.getAccountNumber()));
    }

    public void completeResultSP(Account account1, Account account2){
        d.currentDisplaySP("Action performed successfully.\n");
        d.addToTransactionHistory("$" + lastAmount + lastAction + "account #" + account1.getAccountNumber() + " to account #" + account2.getAccountNumber() + "\n");
    }

    public void completeResultsNoHistorySP(){
        d.currentDisplaySP("Action performed successfully.\n");
    }

    public String openPrompt(){
        return c.getStringInputNotCaseSensitive("What kind of account do you want to open?");
    }

    public void closePrompt(){
        d.currentDisplaySP("What account do you want to close?\nNOTE: The account must be empty.");
    }

    public void printHistory(){
        d.printTransactionHistory();
    }

    public void logOutSP(){
        d.currentDisplaySP("Thank you for your business.");
        d.setTransactionHistory("");
    }

}

