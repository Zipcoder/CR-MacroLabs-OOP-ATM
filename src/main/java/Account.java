import java.math.BigDecimal;

public class Account {

   private BigDecimal balance;
   private String accountType;

   //set the account name and holder
    Account(){

    }
    //constructor to set value for my variable type BigDecimal and variable balance
    Account(BigDecimal balance)
    {
        this.balance = balance;
    }


    //return the value METHOD
    public BigDecimal getBalance()
    {
        return balance;
    }

    //gives the value of the balance after it is returned
    public void setBalance(BigDecimal balance)
    {
        this.balance = balance;
    }


    //DEPOSIT METHOD
    public void deposit(BigDecimal depositAmount)
    {
        //get 200
        BigDecimal balance = getBalance();

        //300 = 200 +100
        balance = balance.add(depositAmount);

        //print 300
        this.setBalance(balance);
    }

    // WITHDRAWAL METHOD
    public void withdrawal(BigDecimal withdrawalAmount)
    {
        // get 200
        BigDecimal balance = getBalance();

        // 150  = 200 - 50
        balance = balance.subtract(withdrawalAmount);

        //print 150
        this.setBalance(balance);
    }

    //Transfer METHOD
    public void transfer( Account accountTwo, BigDecimal transferAmount)
    {
        //establish balance = 100
        // transfer amount 50
        //set balance = 50 in account one

       // 50 = 100 - 50
        this.setBalance(getBalance().subtract(transferAmount));

        //150 = 100 +50
        //print balance in accountTwo
        accountTwo.setBalance(accountTwo.getBalance().add(transferAmount));
    }


}
