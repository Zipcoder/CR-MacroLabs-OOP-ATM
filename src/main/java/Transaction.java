import java.util.Date;

public class Transaction implements Storeable {

    public Double amount;
    public Date timeStamp;
    public Integer accountID;
    public String description;
    public Boolean isCredit;

}
