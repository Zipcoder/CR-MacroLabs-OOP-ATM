package atmproject;

import atmproject.accounts.Account;

import java.util.Map;
import java.util.TreeMap;

public class UserRepository {

    // Singleton Eager Initialization
    protected static final UserRepository userRepository = new UserRepository();

    private int idNums;
    private Map<String, User> repo;

    protected UserRepository(){
        idNums = 1000;
        repo = new TreeMap<String, User>();
    }
    public static UserRepository getUserRepository(){
        return userRepository;
    }

    public Integer createNewUserID(){
        Integer userID = idNums;
        idNums++;
        return userID;
    }
    public void saveUser(User user, Integer userID){
        repo.put(String.format("%04d",userID),user);
    }

    public User getUser(Integer userID){
        return repo.get(String.format("%4d",userID));
    }

    public int getIDNums() {
        return idNums;
    }
}
