public class Account {

    Double balance;
    String accountType= "Checking";
    //Might use this for something later.
    //Maybe an added modifier in case of multiple accounts of same type
    String IDnum;


    //A new instance of account would need starting funds and account type
    public Account(Double startingBalance, String typeOfAccount){
        balance=startingBalance;
        accountType=typeOfAccount;
    }

    //the version of the constructor the tests use.
    //The console should probably use the other one.
    //If this constructor IS used, account defaults to a checking account.
    public Account(Double startingBalance){
        balance=startingBalance;
    }

    public Double getBalance(){
        return balance;
    }

    public String getAccountType(){
        return accountType;
    }



    //Possible area to expand on: perhaps withdrawing works differently pending account type.
    //prevents overdrawing
    public Double withdraw(Double amount){
        if(amount>balance){
            System.out.println("Insufficient funds for withdrawal.");
            return 0.0;
        }else{balance-=amount;
            return amount;}
    }

    public void deposit(Double amount){
        balance+=amount;
    }



    public void transfer(Account gettingMoney, Double amount){
        gettingMoney.deposit(this.withdraw(amount));
    }


    //Uncertain if this is needed, but it was in the tests.
    //Returns true if the account can be closed. False if not.
    public Boolean closeAccount(){
        if (balance==0.0){return true;}
        else return false;
    }

}
