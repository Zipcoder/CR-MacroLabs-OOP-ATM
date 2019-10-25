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
