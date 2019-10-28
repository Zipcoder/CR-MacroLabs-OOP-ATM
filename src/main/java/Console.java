import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by leon on 2/9/18.
 */
public class Console {

    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public static String getInput() {
        Console.print("> ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase(); //get input from user

        return input;
    }

    public static String getInput(String prompt) {
        Console.print(prompt);
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase(); //get input from user

        return input;
    }

    public static String getInput(String[] options) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        int numOptions = options.length;
        int numRows = (numOptions+1) >> 1; // this is how the cool kids divide by two
        String output = "";

        String[] rows = new String[numRows];

        for (int i = 0; i < numRows; i++){
            rows[i] = String.format("%d | %-30s", 2*i+1, options[2*i]);
            if (2*i + 1 < numRows) {
                rows[i] += String.format("%30s | %d", options[2*i + 1], 2*(i+1));
            }
            rows[i] += "\n";
        }

        for (int i = 0; i < numRows; i++) {
            output += rows[i];
        }

        println(output);

        return Integer.toString(Console.getInteger(numOptions));

    }

    public static String getInput(String header, String[] options) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        int numOptions = options.length;
        int numRows = (numOptions+1) >> 1; // this is how the cool kids divide by two
        String output = StringUtils.center(header,66) + "\n\n";

        String[] rows = new String[numRows];

        for (int i = 0; i < numRows; i++){
            rows[i] = String.format("%d | %-30s", 2*i+1, options[2*i]);
            if (2*i + 1 < numOptions) {
                rows[i] += String.format("%30s | %d", options[2*i + 1], 2*(i+1));
            }
            rows[i] += "\n";
        }

        for (int i = 0; i < numRows; i++) {
            output += rows[i];
        }

        println(output);

        return Integer.toString(Console.getInteger(numOptions));

    }

    static Boolean integerCheck(String input) {
        return input.matches("^\\d+$");
    }

    static Boolean currencyCheck(String input) {
        return input.matches("^[0-9]{1,3}(?:,?[0-9]{3})*(?:\\.[0-9]{2})?$");
    }

    public static Double getCurrency() {
        String input = getInput("$");
        while (true) {
            if (currencyCheck(input)) break;
            else {
                println("Enter a number");
                input = getInput("$");
            }
        }
        return Double.valueOf(input);
    }

    public static Double getCurrency(String prompt) {
        Console.print(prompt);
        String input = getInput("$");
        while (true) {
            if (currencyCheck(input)) break;
            else {
                println("Enter a valid number");
                Console.print(prompt);
                input = getInput("$");
            }
        }
        return Double.valueOf(input);
    }

    public static Integer getInteger() {
        String input = getInput();
        while (true) {
            if (integerCheck(input)) break;
            else {
                println("Enter a number");
                input = getInput();
            }
        }
        return Integer.valueOf(input);
    }

    public static Integer getInteger(int max) {
        String input = getInput();
        while (true) {
            if (integerCheck(input)) {
                if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= max) {
                    break;
                } else {
                    println("Enter a number between 1 and " + Integer.toString(max));
                    input = getInput();
                }
            }
            else {
                println("Enter a number");
                input = getInput();
            }
        }
        return Integer.valueOf(input);
    }

}
