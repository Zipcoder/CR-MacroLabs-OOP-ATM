package fountain.donald.atmproject.RoughCopy.User;

import fountain.donald.atmproject.RoughCopy.ATMFunctions.Console;

import java.util.Random;

public class UserFactory extends User {

    public UserFactory(String name, int accountNumber, String password) {
        super(name, accountNumber, password);
    }

    public static User createUser(String bullShit){
        String name = Console.getStringInput("Please enter your first and last name: ");
        String password = Console.getStringInput("Please create a password using no more then 10 digits: ");
        Random rnd = new Random();
        int accountNumber = 100000 + rnd.nextInt(900000);;
        System.out.println("Your account number is: " + accountNumber);

        User newUser = new User(name, accountNumber, password);


        return newUser;
    }
}
