package io.zipcoder.macrolabs.atm; /**
 * Created by Timothy Rager on 10/24/17.
 */
import org.junit.Assert;
import org.junit.Test;
import java.util.Random;

public class mainTest {


    @Test
    public void testSecurityGetName(){
        String expected="XKCD";
        Security security = new Security(expected, 10.02, 25.12);
        String actual = security.getName();

        Assert.assertEquals("The strings do not match", expected, actual);
    }
    @Test
    public void testSecurityGetNumberOwned(){
        double expected=10.030;
        Security security = new Security("XKCD", expected, 25.12);
        double actual = security.getNumberOwned();

        Assert.assertEquals(expected, actual, 0.0001);//Seeking reasonable precision within
                                                    // three decimal places
    }


}
