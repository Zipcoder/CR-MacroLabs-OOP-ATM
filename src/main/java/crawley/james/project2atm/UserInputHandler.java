package crawley.james.project2atm;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class UserInputHandler {

    private Scanner scanner = new Scanner(System.in);

    public int getUserInt () {

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Please input a number");
            scanner.nextLine();
            return 0;
        }
    }

    public double getUserDouble () {

        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Error: Please input a number");
            scanner.nextLine();
            return 0;
        }

    }

    public String getUserString() {

        return scanner.next();

    }
}


