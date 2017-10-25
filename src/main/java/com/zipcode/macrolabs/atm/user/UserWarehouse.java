package com.zipcode.macrolabs.atm.user;

import java.util.ArrayList;
import java.util.List;

public class UserWarehouse {

        private static final List<User> users = new ArrayList<User>();

        public static void addPerson(User user) {
            users.add(user);
        }

        public static List<User> getUsers() {
            return users;
        }

        public static User findUserByID(String userID){
            User userOut = null;
            for (User user: users){
                if(userID.equals(user.getUserID())){
                    userOut = user;
                    break;
                }
            }
            return userOut;
        }

}
