package atmproject;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class ATMTest {

    @Test
    public void runMainMenu() {

    }

    @Test
    public void callDeposit() {
        ATM atm = new ATM();
        User user = new User("Chris","santana",1111);







    }

    @Test
    public void callWithdraw() {
    }

    @Test
    public void callTransfer() {
    }

    @Test
    public void checkBalance() {
        ATM atm = new ATM();
        User currentUser = new User( null, null,null);



    }

    @Test
    public void displayHistoryTest1() {
        ATM atm = new ATM();
        User currentUser = new User(null,null,null);
        String expected = "You currently have no history.";
        Assert.assertEquals(expected,atm.displayHistory(currentUser));
    }

    @Test
    public void displayHistoryTest2() {
        ATM atm = new ATM();
        User currentUser = new User(null,null,null);
        String expected = "This is only a test.";
        currentUser.addToHistory("This is only a test.");

        Assert.assertEquals("**" + expected,atm.displayHistory(currentUser));
    }

    @Test
    public void returnTOLoginMenu() {
      ATM ATM = new ATM();

      ATM.returnToLoginMenu();

      assertFalse(ATM.isRunning());


    }

    @Test
    public void mainMenuLogic() {


    }


}