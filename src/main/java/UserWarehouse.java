import java.util.ArrayList;

public class UserWarehouse {


    static final ArrayList<User> users = new ArrayList();

    public static void addUser(User newUser) {
        System.out.println("Registering New User...\n");
        users.add(newUser);

    }


    public static ArrayList<User> getList() {
        return users;
    }


}
