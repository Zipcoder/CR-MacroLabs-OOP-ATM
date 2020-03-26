import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void truncateToTwoDecimalPlacesTest() {
        //: Given
        double expected = 100.44;

        //: When
        double actual = Main.truncateToTwoDecimalPlaces(100.44321);

        //: Then
        Assert.assertEquals(expected, actual, 0);
    }
}
