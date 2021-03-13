package AccountsAndTransactions;

public class Transactions {
    /*
      needed:
      1. Deposit to acct
      2. Withdraw from acct
      3. Transfer across accounts (self)
      4. Open new account
      5. Close account (must be empty)
      6. Print transaction history
      7. Check balance
      *. Challenge: Transfer to another user's account (but not from)
     */

    //establish variables:
    private double increment;  //the amount to be changed
    private Account acctName;  //the primary account (used for most transactions
    private Account acctName2; //used when a second account type is required, such as a transfer)
    private String acctType;   //the type of account being changed
    private String acctType2;  //used when a second account type is required, such as a transfer


    public Transactions(Account acctName) {
        this.acctName = acctName;
    }

    public void deposit(double increment, String acctType){
        this.increment = increment;        //pull the amount being changed
        this.acctType = acctType;          //determine which account
        //determine appropriate account, then perform balance += increment;
        if(acctType == "checking"){
            acctName.setChkAcctBal(acctName.getChkAcctBal() + increment);
        }
        else if (acctType == "savings"){
            acctName.setSavAcctBal(acctName.getSavAcctBal() + increment);
        }
        else if (acctType == "investment"){
            acctName.setInvAcctBal(acctName.getInvAcctBal() + increment);
        }
        else {
            System.out.println("not a valid account type");
            //then return them to the transaction screen
        }
        acctName.transactionHistory.add(String.format("Deposited $%.2f to " + acctType + ".", increment)); //append this transaction to the user's transaction history ArrayList
    }

    public void withdraw(double increment, String acctType){
        this.increment = increment;                                                   //pull the amount being changed
        this.acctType = acctType;                                                     //determine which account
        if(acctType == "checking" && acctName.getChkAcctBal() >= increment) {          //if checking && sufficient funds in acct
            acctName.setChkAcctBal(acctName.getChkAcctBal() - increment);             //decrement checking account
        }
        else if (acctType == "savings" && acctName.getSavAcctBal() >= increment){      //if savings && sufficient funds in acct
            acctName.setSavAcctBal(acctName.getSavAcctBal() - increment);             //decrement savings account
        }
        else if (acctType == "investment" && acctName.getInvAcctBal() >= increment){   //if investment && sufficient funds in acct
            acctName.setInvAcctBal(acctName.getInvAcctBal() - increment);             //decrement investment acct
        }
        else {                                                                        //error or insufficient funds
            System.out.println("not a valid account type or insufficient funds in " + acctType + " acct");
        }
        acctName.transactionHistory.add(String.format("Withdrew $%.2f from " + acctType + ".", increment)); //append this transaction to the user's transaction history ArrayList
    }

    public void transfer(double increment, String acctType, Account acctName2, String acctType2){
        this.increment = increment;       //pull the amount being changed
        this.acctType = acctType;         //determine the origin account
        this.acctName2 = acctName2;       //Account being deposited into
        this.acctType2 = acctType2;       //determine the destination account
        withdraw(increment, acctType);    //withdraw from first user
        acctName = acctName2;             //switch the account to the second user
        deposit(increment, acctType2);    //deposit to the second user
    }

    //close account will close an empty account, but will not run if the member has money remaining in any account
    public void closeAccount(){
        if (acctName.getChkAcctBal() == 0 && acctName.getSavAcctBal() == 0 && acctName.getInvAcctBal() == 0){
            acctName.setFirstName(null);            //java cannot delete objects, so instead we will set all bins to null
            acctName.setLastName(null);
            acctName.setPin(1000);
            acctName.transactionHistory.add("Closed all accounts");
        }
    }

    //force close account will close all accounts regardless of balance, and dispenses the sum balance in cash before logging out
    //think of it like force choking your bank
    public void forceCloseAccount(){
        withdraw(acctName.getChkAcctBal(), "checking");
        withdraw(acctName.getSavAcctBal(), "savings");
        withdraw(acctName.getInvAcctBal(), "investment");
        acctName.setFirstName(null);            //java cannot delete objects, so instead we will set all bins to null
        acctName.setLastName(null);
        acctName.setPin(1000);
        acctName.transactionHistory.add("Closed all accounts");
    }

    public String[] transactionHistory(){
        String[] history = new String[acctName.transactionHistory.size()];
        for (int i = 0; i < acctName.transactionHistory.size(); i++){
            history[i] = acctName.transactionHistory.get(i);
        }
        return history;
        //get a copy of the transaction history
        //convert the copy to a string array
        //print it
    }

    /* --------------------CHALLENGE------------------------
    public void transferOtherUser(double increment, String acctType, String acctType2, user2){
    UPDATE - I forgot this was the challenge and I programmed the transfer this way originally because I thought we had to.......
   }
    -----------------------CHALLENGE---------------------*/

}
