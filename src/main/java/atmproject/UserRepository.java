package atmproject;

import atmproject.User;

import java.util.HashMap;

public class UserRepository {

    HashMap<String, User> userDatabase;

    public UserRepository() {
        userDatabase = new HashMap<String, User>();
    }

    User findUser(String UserName) {
        return userDatabase.get(UserName);
    }

    boolean addUser(User User) {
        if(userDatabase.containsKey(User.getFirstName())) {
            return false;
        } else {
            userDatabase.put(User.getFirstName(), User);
            return true;
        }
    }

}