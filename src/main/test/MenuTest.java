import org.testng.annotations.Test;

public class MenuTest {

    @Test
    public void testGetInitialInput(){
        Menu menuTest = new Menu();
        menuTest.printWelcomeMenu();
    }
}
