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

    public void addUser() {
        String userName = "wes";
        String password = "password";
        User newUser = new User(userName, password);
        allUsers.add(newUser);

    }

    public String findUser(String userNmae){
        Account currentUser = allUsers.get(0);


        return "";

    }
/*
    public void findAccountIndex(String userName, String password) {
        //User user = allUsers.get(0);
    }
*/
}
