import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class ConsoleTest{

    @Test
    public void getStringInputTest(){
        // Given, simulated user input
        Console console = new Console();
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("Hello!".getBytes());
        System.setIn(in);
        // Expected
        String expected = "Hello!";
        // Actual
        String actual = console.getStringInput(expected);
        // Assert
        System.out.println(actual);
        System.setIn(sysInBackup);
        Assert.assertEquals(expected,actual);
    }


}