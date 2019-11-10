package atmproject;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryTest {

    @Test
    public void Test01CreateNewAccountNum() {
        UserRepository userRepository = UserRepository.getUserRepository();

        Integer expectedAccountNum = 1000;
        Integer actualAccountNum = userRepository.createNewUserID();

        Integer expectedIncrement = expectedAccountNum + 1;
        Integer actualIncrement = userRepository.getIDNums();

        assertEquals(expectedAccountNum, actualAccountNum);
        assertEquals(expectedIncrement, actualIncrement);
    }
    @Test
    public void Test02CreateNewAccountNum(){
        UserRepository userRepository = UserRepository.getUserRepository();

        Integer expectedAccountNum = 1001;
        Integer actualAccountNum = userRepository.createNewUserID();

        Integer expectedIncrement = expectedAccountNum + 1;
        Integer actualIncrement = userRepository.getIDNums();

        assertEquals(expectedAccountNum, actualAccountNum);
        assertEquals(expectedIncrement, actualIncrement);
    }
    @Test
    public void Test03saveUser() {
        UserRepository userRepository = UserRepository.getUserRepository();
        Integer accountNum = userRepository.createNewUserID();
        User expected = new User("Jaime","Diamond", accountNum);

        userRepository.saveUser(expected, accountNum);
        User actual = userRepository.getUser(accountNum);

        assertEquals(expected, actual);
    }

}
