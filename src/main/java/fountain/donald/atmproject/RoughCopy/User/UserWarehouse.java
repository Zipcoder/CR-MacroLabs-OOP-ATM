package fountain.donald.atmproject.RoughCopy.User;

import java.util.ArrayList;

public class UserWarehouse extends User {

    public UserWarehouse(String name, int accountNumber, String password) {
        super(name, accountNumber, password);
    }

    private static ArrayList users = new ArrayList();

    public ArrayList setUser(User newUser) {

        users.add(newUser);
        return users;

    }

    public static ArrayList getUsers() {
        return users;
    }
}

