package fountain.donald.atmproject.RoughCopy.ATMFunctions;

import fountain.donald.atmproject.RoughCopy.Accounts.Account2;

/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {

    public static void main(String[] args){

        //  ATM atmTransaction = new ATM();
       // atmTransaction.start();
       Console console=new Console();
       Account2 donaldsAccount = new Account2(100.00);
       donaldsAccount.withdrawMoney((double)(console.getIntInput("Enter withdrawal amount")));
        System.out.println("The new balance is: " + donaldsAccount.getAccountBalance());
       

    }
}
