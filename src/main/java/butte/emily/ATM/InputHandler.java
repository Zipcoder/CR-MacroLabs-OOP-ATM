package butte.emily.ATM;

import java.util.Scanner;

/**
 * Created by emilybutte on 9/16/16.
 */
public class InputHandler {

    private Scanner input;

    public InputHandler(){
        input = new Scanner(System.in);
    }

    public String inputFromUser() {
        System.out.println("Choose from the following: CREDIT, DEBIT, TRANSFER, CHANGENAME, CHANGEACCOUNTSTATUS");
        return input.next();
    }

    public int enterPIN() {
        System.out.println("Enter your PIN number.");
        return input.nextInt();
    }
}
