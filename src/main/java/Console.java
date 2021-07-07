import java.util.Scanner;

public class Console extends Interface {

    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static Integer getIntegerInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        Integer userInput = Integer.valueOf(scanner.nextLine());
        return userInput;
    }


    public static Double getDoubleInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        Double userInput = Double.valueOf(scanner.nextLine());
        return userInput;
    }

}
