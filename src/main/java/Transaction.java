import java.util.Date;

public class Transaction implements Storeable {

    public Double amount;
    public Date timeStamp;
    public Integer accountID;
    public String description;
    public Boolean isCredit;

    public Transaction(Double amount, Date timeStamp, Integer accountID, String description, Boolean isCredit) {
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.accountID = accountID;
        this.description = description;
        this.isCredit = isCredit;
    }
}
