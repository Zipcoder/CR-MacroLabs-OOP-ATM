package foutain.donald.atmproject.bettercopy.ATMFunctions;

import java.util.Scanner;

public class Console {

    public static String getStringInput(String askForString){
        Scanner string = new Scanner(System.in);
        System.out.println(askForString);
        String userInput = string.nextLine();
        return userInput;
    }

    public static int getIntInput(String askForInt){
        Scanner integer = new Scanner(System.in);
        System.out.println(askForInt);
        int userInput = integer.nextInt();
        return userInput;
    }

    public static double getDoubleInput(String askForDouble){
        Scanner dub = new Scanner(System.in);
        System.out.println(askForDouble);
        double userInput = dub.nextDouble();
        return userInput;
    }
}
