import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionHist {

    String type;
    double balance;

    public TransactionHist() {

    }


    void setType(String accType) {

        type = accType;
    }
    void setBalance(Double accBal) {

        balance = accBal;
    }

    void deposit(Double dep) {
        balance = balance +  dep;
    }
    void withdraw(Double wit) {

        balance = balance - wit;
    }
    Double getBalance() {

        return balance;
    }
    void printTxn(String txnType, Double amt, Double balance){

        System.out.println("");
        System.out.println("|----------------------------------------|");
        System.out.println("| BANK OF ZIP CODE WILMINGTON DE         |");
        System.out.println("|----------------------------------------|");
        System.out.println("|" +    dateTime()  + "                     "+"|");
        System.out.println("|----------------------------------------|");
        System.out.println("|        Transaction Receipt            |");
        System.out.println("|" +            txnType + "                         " +"|");
        System.out.println("|" +  amt + "" + "                                    "+ "|");
        System.out.println("| Remaining Balance: " + balance + "                "   +   "|");
        System.out.println("|----------------------------------------|");

    }
    String dateTime(){

        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //System.out.println (timeFormat.format(now));

        return timeFormat.format(now);
    }
}