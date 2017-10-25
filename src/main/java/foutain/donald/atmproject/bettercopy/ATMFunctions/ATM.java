package foutain.donald.atmproject.bettercopy.ATMFunctions;

public class ATM {

    public int startATM(){
        int userInput = PromptUser.userStartATM();
        return userInput;
    }

    public static void userOption(){
        System.out.println("User Options are: ");
    }
}
