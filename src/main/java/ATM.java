import java.util.ArrayList;

public class ATM {

    private static ATM theInstance = new ATM();

    private ATM() {
    }

    public static ATM getInstance() {
        return theInstance;
    }

    private ArrayList allUsers = new ArrayList();
    private int numOfAccounts = 0;

    public int returnAllUsersSize() {
        return allUsers.size();
    }

    public int returnNewAccountNum() {
        numOfAccounts++;
        return numOfAccounts;
    }

    public void addUser(String userName,String password) {
        User newUser = new User(userName, password);
        allUsers.add(newUser);

    }

    public User EnterUser(String userName,String password){
        int index = -1;
        User currentUser;
        for(int i = 0;i<allUsers.size();i++) {
            currentUser = (User) allUsers.get(i);
            if(userName.equalsIgnoreCase(currentUser.getUserName()) &&
                    password.equalsIgnoreCase(currentUser.getUserPassword())){
                index = i;
            }
        }
        if(index>= 0) {
            currentUser = (User) allUsers.get(index);
        }else{
            currentUser = null;
        }
        return currentUser;

    }

    public boolean UserExist(String userName,String password) {
        int index = -1;
        User currentUser;
        boolean userExist = false;
        for (int i = 0; i < allUsers.size(); i++) {
            currentUser = (User) allUsers.get(i);
            if (userName.equalsIgnoreCase(currentUser.getUserName()) &&
                    password.equalsIgnoreCase(currentUser.getUserPassword())) {
                index = i;
            }
        }
        if (index >= 0) {
            userExist = true;
        }
        return userExist;
    }
}
