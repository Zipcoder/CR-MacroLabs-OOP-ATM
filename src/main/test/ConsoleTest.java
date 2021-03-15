
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ConsoleTest {

    @Test
    public void testStringInput() {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);

        Console c = new Console();
        String actual = c.getStringInput();

        Assert.assertEquals(actual, "1");

        System.setIn(sysInBackup);
    }

}

