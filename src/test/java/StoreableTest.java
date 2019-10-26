import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoreableTest {

    @Test
    public void toStringArrayUser() {
        User user = new User("Jim","Brown","goolybib", 12, 12343);

        String[] actual = user.toStringArray();
        String[] expected = new String[] {
                "12",
                "Brown",
                "Jim",
                "12343",
                "goolybib"
        };

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void toStringArrayAccountChecking() {
        Account account = new Checking("");

        String[] actual = user.toStringArray();
        String[] expected = new String[] {
                "12",
                "Brown",
                "Jim",
                "12343",
                "goolybib"
        };

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void saveToDB() {
    }
}