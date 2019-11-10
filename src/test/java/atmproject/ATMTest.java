package atmproject;

import org.junit.Test;

import static org.junit.Assert.*;

public class ATMTest {

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
      ATM ATM = new ATM();

      ATM.returnToLoginMenu();

      assertFalse(ATM.isRunning());


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