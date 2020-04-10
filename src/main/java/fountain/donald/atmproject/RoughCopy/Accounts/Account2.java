package fountain.donald.atmproject.RoughCopy.Accounts;

import java.util.ArrayList;

public class Account2
{

        private int accountNumber;

        private double accountBalance;

        private String typeOfAccount;

        private ArrayList<String> transactionHistory;

        public Account2(double initialBalance)
        {
            this.accountBalance=initialBalance;
        }

        public double getAccountBalance(){

            return this.accountBalance;
        }

        public double withdrawMoney(double withdrawAmount){

            this.accountBalance -= withdrawAmount;

            return accountBalance;
        }
}
