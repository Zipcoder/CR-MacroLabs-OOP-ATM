package atmproject;

import java.util.Map;
import java.util.TreeMap;

public class UserRepository {

    // Singleton Eager Initialization
    private static final UserRepository userRepository = new UserRepository();

    private int accountNums;
    private Map<String, User> repo;

    private UserRepository(){
        accountNums = 1000;
        repo = new TreeMap<String, User>();
    }
    public static UserRepository getUserRepository(){
        return userRepository;
    }

    public Integer createNewAccountNum(){
        Integer accountNum = accountNums;
        accountNums++;
        return accountNum;
    }
    public void saveUser(User user, Integer accountNum){
        repo.put(String.format("%04d",accountNum),user);
    }
    public User getUser(String accountNum){
        return repo.get(accountNum);
    }

    public User getUser(Integer accountNum){
        return repo.get(String.format("%4d",accountNum));
    }
    public int getAccountNums() {
        return accountNums;
    }
}
