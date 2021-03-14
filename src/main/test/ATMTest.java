import org.testng.annotations.Test;

public class ATMTest {

    @Test
    public void testGetInitialInput(){
        ATM atmTest = new ATM();
        atmTest.printWelcomeMenu();
    }
}
