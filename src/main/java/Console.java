import java.util.Scanner;

public class Console {

    public String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (userInput.isEmpty()) {
            System.out.println("Invalid Input!");
            userInput = scanner.nextLine();
        }
        return userInput;
    }

    public Integer getIntegerInput() {
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextInt()) {
            System.out.println("Invalid Input!");
            scanner.next();
        }
        int userInput = scanner.nextInt();
        return userInput;
    }

    public Double getDoubleInput() {
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextDouble()) {
            System.out.println("Invalid Input!");
            scanner.next();
        }
        double userInput = scanner.nextDouble();
        return userInput;
    }

}
