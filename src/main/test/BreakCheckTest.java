import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;

//@RunWith(Parameterized.class)
public class BreakCheckTest {

    @Test
    public void pinGeneratorTest1(){
        //Given
        BreakCheck newCheck = new BreakCheck();
        //Action
        String newPin = newCheck.pinGenerator();
        //Expected
        int expected = 8;
        //Actual
        int actual = newPin.length();
        System.out.println(newPin);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void pinGeneratorTest2(){
        //Given
        BreakCheck newCheck = new BreakCheck();
        //Action
        String newPin = newCheck.pinGenerator();
        //Expected
        int expected = 8;
        //Actual
        int actual = newPin.length();
        System.out.println(newPin);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void pinGeneratorTest3(){
        //Given
        BreakCheck newCheck = new BreakCheck();
        //Action
        String newPin = newCheck.pinGenerator();
        //Expected
        int expected = 8;
        //Actual
        int actual = newPin.length();
        System.out.println(newPin);
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void isDouble(){
        // Given, simulated user input
        BreakCheck newCheck = new BreakCheck();
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("100".getBytes());
        System.setIn(in);
        // Expected
        Double expected = 100.0;
        // Actual
        Double actual = newCheck.isDouble();
        // Assert
        System.out.println(actual);
        System.setIn(sysInBackup);
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void confirmIsNumberOneTest(){
        // Given, simulated user input
        BreakCheck newCheck = new BreakCheck();
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        // Expected
        String expected = "Checking";
        // Actual
        String actual = newCheck.confirmIsNumber();
        // Assert
        System.out.println(actual);
        System.setIn(sysInBackup);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void confirmIsNumberTwoTest(){
        // Given, simulated user input
        BreakCheck newCheck = new BreakCheck();
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        // Expected
        String expected = "Savings";
        // Actual
        String actual = newCheck.confirmIsNumber();
        // Assert
        System.out.println(actual);
        System.setIn(sysInBackup);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void confirmIsNumberThreeTest(){
        // Given, simulated user input
        BreakCheck newCheck = new BreakCheck();
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        // Expected
        String expected = "Investing";
        // Actual
        String actual = newCheck.confirmIsNumber();
        // Assert
        System.out.println(actual);
        System.setIn(sysInBackup);
        Assert.assertEquals(expected,actual);
    }



}
