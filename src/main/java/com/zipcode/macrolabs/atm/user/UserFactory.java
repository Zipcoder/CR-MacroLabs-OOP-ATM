package com.zipcode.macrolabs.atm.user;

import com.zipcode.macrolabs.atm.exceptions.NoMoreAccountsException;
import com.zipcode.macrolabs.atm.exceptions.NoMoreUsersException;

public class UserFactory {

    static int iteratedUserID = 0;
    public static final int USER_ID_LENGTH = 9;

    public static int nextUserID() throws NoMoreUsersException {
        if((""+iteratedUserID).length() <= USER_ID_LENGTH) {
            return iteratedUserID++;
        } else { throw new NoMoreUsersException(); }
    }

    public static User createNewUser(String name, String password) {
        User newUser = new User(name, password);
        try {
            newUser.setUserID(nextUserID());
        } catch (NoMoreUsersException e) {
            e.printStackTrace();
        }
        UserWarehouse.addPerson(newUser);
        return newUser;

    }

//    public static User createRandomUser() {
//        String name = RandomUtils.createString('a', 'z', 5);
//        int age = RandomUtils.createInteger(0, 100);
//        boolean isMale = RandomUtils.createBoolean(50);
//
//        Person randomPerson = new Person(name, age, isMale);
//        return randomPerson;
//    }

}
