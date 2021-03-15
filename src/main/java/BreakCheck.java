import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class BreakCheck {

    //Ensures user chooses from options provided
    public String confirmIsNumber(){
        String newString = "";
        boolean redo = true;
        while(redo) {
            newString = Console.getStringInput("1 - Checking, 2 - Savings, 3 - Investing, 4 - Exit");
            switch(newString){
                case "1":
                    redo = false;
                    return "Checking";
                case "2":
                    redo = false;
                    return "Savings";
                case "3":
                    redo = false;
                    return "Investing";
                case "4":
                    System.out.println("Thank you for choosing a real financial institution");
                    System.exit(0);
                default: System.out.println("Please choose from the menu!");
            }
        }
        return null;
    }

    //Checks that amount entered is a double
    public Double isDouble(){

        Double result = 0.0;
        boolean check = true;
        do {
            String newString = Console.getStringInput("\r");
            try {
                result = Double.parseDouble(newString);
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid amount!");
            }
        } while(check);
        return result;
    }

    public Integer isInteger(){
        Integer result = 0;
        boolean check = true;
        do {
            String newString = Console.getStringInput("\r");
            try {
                result = Integer.parseInt(newString);
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid amount!");
            }
        } while(check);
        return result;
    }

    //Generates pin for user
    public String pinGenerator(){
        String newPin = "";
        Random randomInt = new Random();
        for(int i =8; i > 0; i--) {
            newPin += String.valueOf(randomInt.nextInt(10));
        }

        return newPin;
    }

    public Integer isPIN(){

        Integer result = 0;
        boolean check = true;
        do {
            String newString = Console.getStringInput("\r");
            try {
                result = Integer.parseInt(newString);
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid PIN");
            }
        } while(check);
        return result;
    }


}
