package foutain.donald.atmproject.bettercopy.ATMFunctions;

public class PromptUser {

    public static int userStartATM(){
        int userInput = Console.getIntInput("Hello, welcome to Zip Code Federal credit Union.\n" +
                            "If you are a new user please input '1'.\n" +
                            "If you would like to login to an existing account please enter '2'.");
        return userInput;
    }

    public static String getUserName(){
        String userInfo = Console.getStringInput("Please enter your first and last name.");
        return userInfo;
    }

    public static String getUserPassWord(){
        String userInfo = Console.getStringInput("Please enter your password.");
        return userInfo;
    }

    public static int getUserAccountType(){
        int userInfo = Console.getIntInput("Account type options\n"+
                        "1: Checking\n2: Savings\n 3: Investments");
        return userInfo;
    }

    public static int correctResponse(){
        int userInfo = Console.getIntInput("Please reread the above directions and answer appropriately.");
        return userInfo;
    }
}
