import java.util.ArrayList;
import java.util.HashMap;

public class UserVillage {
    ArrayList<User> allUsers = new ArrayList<User>();

    public UserVillage(){}

    public UserVillage(User user){
        this.allUsers.add(user);
    }

    public void createUser(String name, String password){
        User user = new User(allUsers.size(), name, password);
        this.allUsers.add(user);
    }
    ///GETTERS SETTERS////
    public Boolean checkLogIn(String username, String password){
        for (User user : allUsers){
            if(username.equals(user.getUserName()) && password.equals(user.getPassword()))
                return true;
        }
        return false;
    }
    public Boolean checkUser(String username){
        for(User user : allUsers){
            if(!username.equals(user.getUserName()));
                return true;
        }
        return false;
    }
    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(ArrayList<User> allUsers) {
        this.allUsers = allUsers;
    }
}
