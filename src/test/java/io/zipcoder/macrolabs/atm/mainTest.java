package io.zipcoder.macrolabs.atm; /**
 * Created by Timothy Rager on 10/24/17.
 */
import org.junit.Assert;
import org.junit.Test;
//import java.util.Random;

public class mainTest {

    public final double allowedDeltaShares = 0.0001;
    public final double allowedDeltaDollars = 0.001;

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

        Assert.assertEquals(expected, actual, allowedDeltaShares);//Seeking reasonable precision within
                                                    // three decimal places
    }

    @Test
    public void testChangeNumberOwned(){
        //double expected=20.034;
        //double changedBy=0.004;
        double expected=20.026;
        double changedBy=-0.004;
        Security security=new Security("XKCD", 20.03,10);
        security.changeNumberOwned(changedBy);
        double actual=security.getNumberOwned();
        Assert.assertEquals(expected, actual, allowedDeltaShares);
    }


}
