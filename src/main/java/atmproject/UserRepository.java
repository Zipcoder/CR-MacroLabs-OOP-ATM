package atmproject;

import java.util.Map;
import java.util.TreeMap;

public class UserRepository {

    // Singleton Eager Initialization
    private static final UserRepository userRepository = new UserRepository();

    private int idNums;
    private Map<String, User> repo;

    private UserRepository(){
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
    public User getUser(String userID){
        return repo.get(userID);
    }

    public User getUser(Integer userID){
        return repo.get(String.format("%4d",userID));
    }
    public int getIDNums() {
        return idNums;
    }
}
