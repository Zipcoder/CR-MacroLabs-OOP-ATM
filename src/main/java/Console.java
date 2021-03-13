import java.util.Scanner;

public class Console {

    public void greetingMessage(){
        System.out.println("Welcome!");
    }

    //Just to testing!


    //Simple user Interface
    public void chooseAccount(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Which account would you like to access?");
        System.out.println("1 - Checking, 2 - Savings, 2 - Investing");

        String numIn = "";
        if(userInput.hasNextLine()){
            numIn = userInput.nextLine();
        }
        else {
            System.out.println("Please choose from the menu!");
        }

        switch (numIn){
            case "1":  {
                System.out.println("You have chosen Checking");
                break;
            }
            case "2":  {
                System.out.println("You have chosen Savings");
                break;
            }
            case "3":  {

                System.out.println("You have chosen Investing");
                break;
            }
        }
    }

    public void depositOrWithdraw() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Would you like to deposit of withdraw funds?");
        System.out.println("1 - Deposit, 2 - Withdraw");

        String numIn = userInput.nextLine();
        switch (numIn) {
            case "1": {
                this.deposit();
                break;
            }
            case "2": {
                this.withdraw();
                break;
            }
            default: {
                System.out.println("Please choose from the menu!");
            }
        }
    }
    public void deposit() {
        System.out.println("Amount to be deposited? ");
        //receive input
        //parse to int
        //if not an int return message to try again
    }
    public void withdraw() {
        System.out.println("Amount to be withdrawn? ");
        //if ( input greater than account balance ask for new amount)
    }

}
