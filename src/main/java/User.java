import java.util.ArrayList;

public class User {
    private Integer userID;
    private String userName;
    private String password;
    private ArrayList<Integer> accountsIds = new ArrayList<Integer>();

    public User(Integer userID, String userName, String password){
        this.userID = userID;
        this.userName = userName;
        this.password = password;
    }
    public Boolean addingAccount(Integer accountId){
        return this.accountsIds.add(accountId);
    }

    public void removeAccount(Integer accountId) {
        if (checkIfUserHasAccount(accountId)) {
            this.accountsIds.remove(accountId);
        }
    }

    public ArrayList<Integer> getAccountsIds() {
        return this.accountsIds;
    }

    public Boolean checkIfUserHasAccount(Integer accountIdToCheck) {
        Boolean exists = false;
        for (Integer accountId: this.accountsIds) {
            if (accountIdToCheck == accountId) {
                exists = true;
            }
        }
        return exists;
    }

    ///////GETTERS AND SETTERS
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
