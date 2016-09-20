import org.junit.Assert;
import org.junit.Test;

/**
 * Created by emilybutte on 9/16/16.
 */
public class UserManagerTest {

    @Test
    public void createPassword() {
         expected = createPassword();
        Assert.assertEquals("should create a user password", expected);
    }
}
