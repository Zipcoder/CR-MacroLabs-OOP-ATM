import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogInTest {

   // @Before
  //  public void setUp() throws Exception {
   // }

    //@After
    //public void tearDown() throws Exception {
    //}

     @Test
    public void testCheckUsername() {

        LogIn newLogIn = new LogIn();
        boolean actual = newLogIn.checkUserAndPass("JaneDoe", "p123");

        Assert.assertEquals(true, actual);
    }

    @Test
    public void testCheckUsername2() {

        LogIn newLogIn = new LogIn();
        boolean actual = newLogIn.checkUserAndPass("mi", "09");

        Assert.assertEquals(false, actual);
    }

    @Test
    public void testCheckPassword(){
        LogIn newLogIn = new LogIn();
        boolean actual = newLogIn.checkUserAndPass("JohnS","MK67");

        Assert.assertEquals(true, actual);
    }

    @Test
    public void testCheckPassword2(){
        LogIn newLogIn = new LogIn();
        boolean actual = newLogIn.checkUserAndPass("JaneDoe", "Lo");

        Assert.assertEquals(false, actual);
    }

    @Test
    public void testNewAccount(){
        Account newAcc = new Account();
        System.out.println(newAcc.setNewAccount("Milo", "9012"));
        System.out.println(newAcc.getUsername("Milo"));
    }

}
