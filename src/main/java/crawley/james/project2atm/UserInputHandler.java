package crawley.james.project2atm;

import java.util.Scanner;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class UserInputHandler {

    private Scanner scanner = new Scanner(System.in);

    public int getUserInt () {

        return scanner.nextInt();

    }

    public double getUserDouble () {

        System.out.println("Enter an amount: ");
        return scanner.nextDouble();

    }

    public String getUserString() {

        return scanner.next();

    }
}


