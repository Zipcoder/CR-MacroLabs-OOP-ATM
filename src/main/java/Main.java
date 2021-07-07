/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {

    public static void main(String[] args){
        System.out.println("                                                                                                    \n" +
                ",-------.,--.            ,-----.          ,--.           \n" +
                "`--.   / `--' ,---.     '  .--./ ,---.  ,-|  | ,---.     \n" +
                "  /   /  ,--.| .-. |    |  |    | .-. |' .-. || .-. :    \n" +
                " /   `--.|  || '-' '    '  '--'\\' '-' '\\ `-' |\\   --. \n" +
                "`-------'`--'|  |-'      `-----' `---'  `---'  `----'    \n" +
                "             `--'                                                                                   ");

        String userYesOrNo;

        do {
            System.out.println("Welcome to Zip Code ATM.");
            userYesOrNo = Console.getUserInputString("Would you like to make a transaction on your account?" +
                    "\nPlease enter yes or no below:");

            if (userYesOrNo.equalsIgnoreCase("yes")) {

                Console.getUserInputInteger("Would you like to: "+ "\n1. Check your balance" + "\n2. Make a withdrawal" + "\n3. Make a deposit");

//                Enter options for atm:
//                1. check balance
//                2. withdraw
            } else if (userYesOrNo.equalsIgnoreCase("no")) {
                System.out.println("Would you like to make an account?");
//                option to create account or leave
            }

            userYesOrNo = Console.getUserInputString("Would you like to leave Zip Code ATM");
        } while (!(userYesOrNo.equalsIgnoreCase("yes")));

        System.out.println("                                                                                                             \n" +
                "                ,--------.,--.                     ,--.        ,--.   ,--.                                   \n" +
                "                '--.  .--'|  ,---.  ,--,--.,--,--, |  |,-.      \\  `.'  /,---. ,--.,--.                      \n" +
                "                   |  |   |  .-.  |' ,-.  ||      \\|     /       '.    /| .-. ||  ||  |                      \n" +
                "                   |  |   |  | |  |\\ '-'  ||  ||  ||  \\  \\         |  | ' '-' ''  ''  '                      \n" +
                "                   `--'   `--' `--' `--`--'`--''--'`--'`--'        `--'  `---'  `----'                       \n" +
                ",--.  ,--.                                        ,--.  ,--.,--.                 ,------.                    \n" +
                "|  '--'  | ,--,--.,--.  ,--.,---.      ,--,--.    |  ,'.|  |`--' ,---. ,---.     |  .-.  \\  ,--,--.,--. ,--. \n" +
                "|  .--.  |' ,-.  | \\  `'  /| .-. :    ' ,-.  |    |  |' '  |,--.| .--'| .-. :    |  |  \\  :' ,-.  | \\  '  /  \n" +
                "|  |  |  |\\ '-'  |  \\    / \\   --.    \\ '-'  |    |  | `   ||  |\\ `--.\\   --.    |  '--'  /\\ '-'  |  \\   '   \n" +
                "`--'  `--' `--`--'   `--'   `----'     `--`--'    `--'  `--'`--' `---' `----'    `-------'  `--`--'.-'  /    \n" +
                "                                                                                                   `---'     ");
    }
        

}
