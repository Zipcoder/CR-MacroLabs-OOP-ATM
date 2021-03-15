import java.util.Scanner;

public class Console {

    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public String getStringInputNotCaseSensitive(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        String userInput = scanner.nextLine();
        return userInput.toLowerCase();
    }

    public Integer getIntegerInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Input is not a number.");
            scanner.nextLine();
        }
        int userInput = scanner.nextInt();
        return userInput;

    }

    public Double getDoubleInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Input is not a number.");
            scanner.nextLine();
        }
        Double userInput = scanner.nextDouble();
        return userInput;

    }

}
