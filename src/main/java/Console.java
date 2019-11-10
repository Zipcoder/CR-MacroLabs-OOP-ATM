
import java.util.Scanner;

public class Console {
    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        print(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static Integer getIntegerInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        Boolean check = false;
        do {
            print(prompt);
            userInput = scanner.nextLine();
            check = userInput.matches("^\\d{0,9}$");
        } while (!check);

        return Integer.valueOf(userInput);
    }

    public static Double getDoubleInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        Boolean check = false;
        do {
            print(prompt);
            userInput = scanner.nextLine();
            check = userInput.matches("^\\d{0,8}(\\.\\d{1,2})?$");

        } while (!check);

        return Double.valueOf(userInput);
    }

    public static void clear() {
        print("\n\n\n\n\n\n\n\n\n\n\n");
    }

}


