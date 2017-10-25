import java.util.Scanner;

public class Console {

    Scanner sc = new Scanner(System.in);

    public void welcomeMessage() {
        System.out.println("Welcome to the Zip Code Bank!\n"
                + "\nIf you currently have an account with us, please input 1!\n"
                + "\nIf you would like to create and account with us, please input 5!\n"
                + "\n***If your name is Tariq, please leave!***");

        String option = sc.nextLine();

        if (option.equals("1")) {
            System.out.println("Please enter your username below:");
        } else if (option.equals("5")) {
            System.out.println("What type of account would you like to create with us?\n"
                    + "1). Checking Account\n2). Savings Account\n3). Investment Account");
        } else {
                System.out.println("Please leave this bank Tariq, you don't qualify for an account here!");
        }

    }


}
