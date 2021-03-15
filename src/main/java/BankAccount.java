import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class BankAccount {


    public String accountType;
    private double currentBalance;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();


    public BankAccount(String chosenAccountType) {
        this.accountType = chosenAccountType;
        this.currentBalance = 0;
    }


    void setType(String accType) {
        accountType = accType;
    }

    void setBalance(Double accBal) {
        currentBalance = accBal;
    }

    public String getAccountType() {
        return this.accountType;
    }

    Double getBalance() {
        return currentBalance;
    }

    void deposit(Double dep) {
        currentBalance = currentBalance +  dep;
    }

    void withdraw(Double wit) {
        currentBalance = currentBalance - wit;
    }

    void printTxn(String txnType, Double amt, Double balance){


        System.out.println("|----------------------------------------|");
        System.out.println("| BANK OF ZIP CODE WILMINGTON DE         |");
        System.out.println("|----------------------------------------|");
        System.out.println("|" +    dateTime()  + "                     "+"|");
        System.out.println("|----------------------------------------|");
        System.out.println("|        Transaction Receipt             |");
        System.out.println("|" +            txnType + "                           " +"|");
        System.out.println("|" +  amt + "" + "                                   "+ "|");
        System.out.println("| Remaining Balance: " + balance + "                 "   +   "|");
        System.out.println("|----------------------------------------|");

    }
    String dateTime(){

        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //System.out.println (timeFormat.format(now));

        return timeFormat.format(now);
    }
}