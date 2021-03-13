
/**
 * Created by iyasuwatts on 10/17/17.
 */

public class Main {

    public static void main(String[] args) {

        boolean turnOn = true;
        {


            Console.println("Welcome to the ATM ! \n                                        \n" +
                    "***     ***              ***              \n" +
                    "***     ***              ***              \n" +
                    "***     ***              ***              \n" +
                    "***     ***     *****    ***   *** ***    \n" +
                    "***     ***    *******   ***   ********   \n" +
                    "***********   ****  ***  ***   **** ****  \n" +
                    "***********   ***   ***  ***   ***   ***  \n" +
                    "***     ***   *********  ***   ***   ***  \n" +
                    "***     ***   *********  ***   ***   ***  \n" +
                    "***     ***   ***        ***   ***   ***  \n" +
                    "***     ***   ****       ***   ****  ***  \n" +
                    "***     ***    ********  ***   ********   \n" +
                    "***     ***     *******  ***   *** ***    \n" +
                    "                               ***        \n" +
                    "                               ***        \n" +
                    "                               ***  \n==========++=========" +
                    " \nWould you like to make a new account or do you have an existing account?");
            Integer inputValue = Console.getIntegerInput("Choose an option: \n 1. I have an existing account \n 2. I want to make a new Account\n 3. Exit ATM "
            );

            switch (inputValue) {
                case 1:
                    String usernameValue = Console.getStringInput("Welcome back! \n Please input your username: ");
                    Integer pinNum = Console.getIntegerInput(" Please input your four digit pin number: ");
                    Menu.pinMenu(pinNum);


                    break;


                case 2:
                    Console.println("Thank you for choosing our bank! Please input your first name:");
                    String firstName = Console.getStringInput("First name:");
                    String lastName = Console.getStringInput("Last name:");
                    System.out.println("Welcome " + firstName + " \n Your new username is :" + firstName + lastName);
                    Integer newPinNum = Console.getIntegerInput(" Please create your four digit pin number: ");
                    Menu.pinMenu(newPinNum);
                    TransactionMenu.accountsMenu();

                    break;
                case 3:
                    turnOn = false;
                    break;

                default:
                    Console.println("Error: invalid option");
                    break;
            }
        } System.out.print("Thank you for using our services! Have a nice Day!");

    }
}

