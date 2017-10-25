
import java.util.Scanner;

public class UserFactory {
    protected UserFactory() {

    }

    private static int nextId;


    public static User createUser() {


        String userName = setUserName();
        String password = setPassword();
        int id = nextId;

        User newUser = new User(userName, password, id);
        UserWarehouse.addUser(newUser);
        nextId++;
        return newUser;
    }

    //FOR TESTS
    public static User createUser(String name, String pass, int nextId) {
        String userName = name;
        String password = pass;
        int id = nextId;
        User newUser = new User(userName, password, id);
        UserWarehouse.addUser(newUser);
        nextId++;
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
