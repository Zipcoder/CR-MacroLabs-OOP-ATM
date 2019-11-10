package atmproject;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainMenuTest {

    @Test
    public void runMainMenu() {
    }

    @Test
    public void callDeposit() {
    }

    @Test
    public void callWithdraw() {
    }

    @Test
    public void callTransfer() {
    }

    @Test
    public void checkBalance() {
    }

    @Test
    public void displayHistory() {
    }

    @Test
    public void returnTOLoginMenu() {
      MainMenu mainMenu = new MainMenu();

      mainMenu.returnToLoginMenu();

      assertFalse(mainMenu.isRunning());


    }

    @Test
    public void mainMenuLogic() {
    }

    @Test
    public void getCurrentUser() {
    }

    @Test
    public void setCurrentUser() {
    }
}