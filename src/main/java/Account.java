import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Account {

    Double balance;
    String accountType= "Checking";
    //Might use this for something later.
    //Maybe an added modifier in case of multiple accounts of same type
    String IDnum;
    List<Double> transHistory=new ArrayList<>();


    //A new instance of account would need starting funds and account type
    public Account(Double startingBalance, String typeOfAccount){
        if(startingBalance>=0) balance=startingBalance;
        else {balance=0.0; System.out.println("Can't open with a negative balance.");}
        accountType=typeOfAccount;
    }

    //the version of the constructor the tests use.
    //The console should probably use the other one.
    //If this constructor IS used, account defaults to a checking account.
    public Account(Double startingBalance){
        if(startingBalance>=0) balance=startingBalance;
        else {balance=0.0; System.out.println("Can't open with a negative balance.");}
    }

    public Double getBalance(){
        BigDecimal bd = new BigDecimal(balance).setScale(2, RoundingMode.HALF_UP);
        balance = bd.doubleValue();
        return balance;
    }

    public String getAccountType(){
        return accountType;
    }



    //Possible area to expand on: perhaps withdrawing works differently pending account type?
    //prevents overdrawing. uses return statement for either
    //A balance or to be used in the transfer method.
    public Double withdraw(Double amount){
        if(amount>balance){
            System.out.println("Insufficient funds for withdrawal.");
            return 0.0;
        }else if(amount<0.0){
            System.out.println("Cannot withdraw negative amount.");
            return 0.0;
        }else{balance-=amount;
            transHistory.add(-amount);
            return amount;}
    }

    //cannot deposit a negative amount
    public void deposit(Double amount){
        if (amount>=0.0) {balance+=amount;
        transHistory.add(amount);}
        if (amount<0.0) System.out.println("You can't deposit what you don't have.");
    }



    public void transfer(Account gettingMoney, Double amount){

        gettingMoney.deposit(this.withdraw(amount));
    }

    public void showTransactionHistory(){
        for(Double i:transHistory){
            if(i>0.0){
                System.out.println("Deposit :  "+i);
            }else if(i<0.0){
                System.out.println("Withdraw:  "+i);}
        }
    }


    //Returns true if the account can be closed. False if not.
    public Boolean closeAccount(){
        if (balance==0.0){return true;}
        else return false;
    }



}
