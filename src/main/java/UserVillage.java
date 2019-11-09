import java.util.ArrayList;
import java.util.HashMap;

public class UserVillage {
    ArrayList<User> allUsers = new ArrayList<User>();

    public UserVillage(){}
    public UserVillage(User user){
        this.allUsers.add(user);
    }

    public void addUser(User newUser){
        this.allUsers.add(newUser);
    }
    ///GETTERS SETTERS////
    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(ArrayList<User> allUsers) {
        this.allUsers = allUsers;
    }
}
