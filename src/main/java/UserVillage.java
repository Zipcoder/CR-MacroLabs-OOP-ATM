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
        Boolean login = false;
        for (User user : allUsers){
            if(username.equals(user.getUserName()) && password.equals(user.getPassword()))
                login = true;
        }
        return login;
    }
    public Boolean checkUser(String username){
        Boolean exists = false;
        for(User user : allUsers){
            if(username.equals(user.getUserName())) {
                exists = true;
            }
        }
        return exists;
    }
    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(ArrayList<User> allUsers) {
        this.allUsers = allUsers;
    }

    public User getUserByUsername(String username) {
        User foundUser = null;
        for(User user : allUsers){
            if(username.equals(user.getUserName())) {
                foundUser = user;
            }
        }
        return foundUser;
    }

}
