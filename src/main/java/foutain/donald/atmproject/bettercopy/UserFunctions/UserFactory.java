package foutain.donald.atmproject.bettercopy.UserFunctions;

import java.util.ArrayList;


public class UserFactory {



    public static User createNewUser(String userName, String userPassword){
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setUserPassword(userPassword);
        return newUser;
    }

    private static ArrayList<User> users;

    public void addUserToList(User user){
        this.users.add(user);
    }

    public UserFactory(){
        users = new ArrayList<>();
        }
    }
