import java.util.InputMismatchException;

public class Menu {

    public static void pinMenu(Integer pinNum) {


//                if (pinNumValue== usernamePinNum ){
//                    call the transaction methods here
//                }
        for (int i = 1; i <= 1000; i++) {
            try {

                if (pinNum <= 9999 && pinNum >= 1000) {
                    //takes you to Transactions from here
                    break;
                } else {
                    System.out.println("Pin must be four digit");

                }

            } catch (InputMismatchException e) {

                System.out.println("Error use numbers not alphabets or characters");
            }
        }
    }
}
