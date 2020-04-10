package foutain.donald.atmproject.bettercopy.UserFunctions;

import java.util.ArrayList;

public class UserWarehouse {

    private static ArrayList<User> usersList;

    public void addUserToList(User user){
        this.usersList.add(user);
    }

    public UserWarehouse(){
        usersList = new ArrayList<>();
    }

    public static void userLogin() {
    }

    public User getUserFromList(String user) {
        for (User userLookingFor : usersList) {
            if (userLookingFor.getUserName().equals(user))
                return userLookingFor;
            }
        return null;
        }
    }
