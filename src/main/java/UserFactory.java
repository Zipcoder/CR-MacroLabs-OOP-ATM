
import java.util.Scanner;

public class UserFactory {
    protected UserFactory() {

    }




    public static User createUser() {


        String userName = setUserName();
        String password = setPassword();


        User newUser = new User(userName, password);
        UserWarehouse.addUser(newUser);

        return newUser;
    }

    //FOR TESTS
    public static User createUser(String name, String pass) {
        String userName = name;
        String password = pass;

        User newUser = new User(userName, password);
        UserWarehouse.addUser(newUser);

        return newUser;
    }


    public static String setUserName() {
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Create a Username");
        name = input.next();
        return name;

    }

    public static String setPassword() {
        String password;
        Scanner input = new Scanner(System.in);
        System.out.println("Create a password");
        password = input.nextLine();
        return password;
    }


}
