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

    public static String getInput2() {
        Console.print("> ");
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
            rows[i] = Integer.toString(2*i+1) + " " + options[2*i] + "       ";
            if (2*i + 1 < numRows) {
                rows[i] += (options[2*i + 1] + " " + Integer.toString(2*(i+1)));
            }
            rows[i] += "\n";
        }

        for (int i = numRows - 1; i >= 0; i--) {
            output += rows[i];
        }

        println(output);

        return Console.getInput();

    }

    static Boolean integerCheck(String input) {
        return input.matches("^\\d+$");
    }

    static Boolean currencyCheck(String input) {
        return input.matches("^[0-9]{1,3}(?:,?[0-9]{3})*(?:\\.[0-9]{2})?$");
    }

    public static Double getCurrency() {
        String input = getInput();
        while (true) {
            if (currencyCheck(input)) break;
            else {
                println("Enter a number");
                input = getInput();
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

}
