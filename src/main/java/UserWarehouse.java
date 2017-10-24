import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserWarehouse {
    private static ArrayList<User> allUsers = new ArrayList<User>(128);


    public static void addUser(User newUser) {
        allUsers.add(newUser);
    }

    public static User returnUserFromID(int userID) {
        for (User user : allUsers) {
            if (user.getUserID() == userID) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public static void generateMyUsers() {
        String passwords = "abc\n"    // userID 1
                + "dog\n"             // userID 2
                + "cat\n"             // userID 3
                + "password\n";       // userID 4

        Scanner scan = new Scanner(passwords);
        Random rand = new Random();

        while (scan.hasNextLine()) {
            String tempPassword = scan.nextLine();
            User tempUser = new User(tempPassword);
            int numAccounts = rand.nextInt(3) + 1;
            for(int i = 1; i <= numAccounts; i++) {
                int accountTypeGenerator = rand.nextInt(3);
                AccountType generatedType;
                switch (accountTypeGenerator) {
                    case 0:
                        generatedType = AccountType.CHECKING;
                        break;
                    case 1:
                        generatedType = AccountType.SAVINGS;
                        break;
                    case 2:
                        generatedType = AccountType.INVESTMENT;
                        break;
                    default:
                        generatedType = AccountType.CHECKING;
                }
                double tempBalance = Main.truncateToTwoDecimalPlaces(rand.nextDouble() * 1000);
                tempUser.addAccount(new Account(generatedType, tempBalance));
            }
            addUser(tempUser);
        }
    }
}
