import AccountsAndTransactions.Account;

public class TransactionMenu {


    public static void accountsMenu() {


        Integer inputValue = Console.getIntegerInput("Please choose which account you want to access" +
                " \n 1. Checkings \n 2. Savings \n 3. Investement \n 4. Quit ");


        switch (inputValue) {
            case 1:

                System.out.println(String.format(" Your Checkings balance is $%.2f",Account.getChkAcctBal()));
                System.out.println ("What would you like to do?");
                // transactions();

                break;

            case 2:
                //System.out.println(" Your Savings balance is $" + Account.getSavAcctBal());
                //System.out.println ("What would you like to do?")
                // transactions();


                break;

            case 3:
                //System.out.println(" Your Investment balance is $" + Account.getInvAcctBal());
                //System.out.println ("What would you like to do?")
                // transactions();


                break;


        }
    }


    public static void transactions(Integer userInput) {
        Integer inputValue = Console.getIntegerInput("Choose an option: \n 1. Deposit \n 2. Withdrawl \n 3. Transfer \n 4. Check Balance"
        );

        switch (inputValue) {
            case 1:
                // input deposit method here
                break;

            case 2:
                //input Withdrawl method here
                break;

            case 3:
                // input Transfer method here
                break;

            case 4:

                break;
        }

    }
}