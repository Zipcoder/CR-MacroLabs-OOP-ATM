import java.util.Scanner;

public class UserCreator {

    public UserCreator(){

    }

    public static User createUser() {

        String username = setUsername();
        String password = setPassword();


        User newUser = new User(username, password);
        UserHolder.addUser(newUser);

        return newUser;
    }

    public static String setUsername() {
        String username;
        Scanner input = new Scanner(System.in);
        System.out.println("Create a Username: ");
        username = input.next();
        return username;

    }

    public static String setPassword() {
        String password;
        Scanner input = new Scanner(System.in);
        System.out.println("Create a password: ");
        password = input.nextLine();
        return password;
    }

}
