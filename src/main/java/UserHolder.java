import java.util.ArrayList;

public class UserHolder {

    static final ArrayList<User> users = new ArrayList();

    public static void addUser(User newUser) {
        System.out.println("Your username and password is created\n");
        users.add(newUser);

    }


    public static ArrayList<User> getList() {
        return users;
    }
}
