import org.junit.Assert;
import org.junit.Test;

public class User_Test {

    @Test
    public void User_Test () {
        //: Given
        User getUserNameCheckPwordTest = new User ("abc", "123");
        String expected = "abc";
        String expected2 = "123";
        //: When
        String actual = getUserNameCheckPwordTest.getUserName();
        String actual2 = getUserNameCheckPwordTest.checkPassword();
        //: Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);





    }

}
