public class Account {
    Double balance;
    String accountType;


    //A new instance of account would need starting funds and account type
    public Account(Double startingBalance, String typeOfAccount){
        balance=startingBalance;
        accountType=typeOfAccount;
    }

    public Double getBalance(){
        return balance;
    }

    public String getAccountType(){
        return accountType;
    }

    public Double withdraw(Double amount){

    }

    public void deposit(Double amount){
        balance+=amount;
        //I considered telling the user the balance in a message here,
        //Decided against it due to method reuse in console class.
    }


}
