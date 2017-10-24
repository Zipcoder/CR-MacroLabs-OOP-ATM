package t.ATMFunctions;

import java.util.Scanner;

public class Console {
    public static String getStringInput(String promptUser) {
        Scanner string = new Scanner(System.in);
        System.out.println(promptUser);
        String userInput = string.nextLine();
        return userInput;}

    public static int getIntInput(String askUser) {
        Scanner integer = new Scanner(System.in);
        System.out.println(askUser);
        int Input = integer.nextInt();
        return Input;
    }
}
