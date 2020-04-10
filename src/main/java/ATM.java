import java.util.ArrayList;

public class ATM {
    private ArrayList<User> allUsers = new ArrayList<User>();

    private int numOfAccounts = 0;

    private static ATM theInstance = new ATM();

    private ATM() {
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public void clearAllUsers(){
        allUsers.clear();

    }

    public static ATM getInstance() {
        return theInstance;
    }

    public void addUser(String userName, String password) {
        User newUser = new User(userName, password);
        allUsers.add(newUser);
    }

    int returnAllUsersSize() {
        return allUsers.size();
    }

    int returnNewAccountNum() {
        numOfAccounts++;
        return numOfAccounts;
    }

    boolean UserExist(String userName) {
        boolean userExist = false;

        for (User currentUser : allUsers) {

            if (userName.equalsIgnoreCase(currentUser.getUserName())) {
                return true;
            }
        }
        return userExist;
    }

    int UserIndex(String userName){
        int index = 0;
        User currentUser;
        for (int i = 0; i < allUsers.size(); i++) {
            currentUser = (User) allUsers.get(i);
            if (userName.equalsIgnoreCase(currentUser.getUserName())) {
                return i;
            }
        }
        return index;
    }

    boolean UserNameAndPasswordCorrect(String userName, String password) {
        User currentUser;
        String userPassword;
        boolean userCorrect = false;
        if(UserExist(userName)){
            currentUser = EnterUser(userName);
            userPassword= currentUser.getUserPassword();
            userCorrect = (password.equals(userPassword));
        }
        return userCorrect;
    }

    User EnterUser(String userName) {
        int index = UserIndex(userName);
        User currentUser = (User) allUsers.get(index);
        return currentUser;
    }

}
