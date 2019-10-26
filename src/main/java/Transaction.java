import java.util.Date;

public class Transaction implements Storeable {

    private Double amount;
    private Date timeStamp;
    private Integer accountID;
    private String description;
    private Boolean isCredit;

    public Transaction(Double amount, Date timeStamp, Integer accountID, String description, Boolean isCredit) {
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.accountID = accountID;
        this.description = description;
        this.isCredit = isCredit;
    }
}
