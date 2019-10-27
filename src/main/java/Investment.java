import java.util.Random;

public class Investment extends Account implements Storeable {



    Double risk;

    public Investment(Double balance, Integer ownerID, Integer acctNum, Double risk) {
        super(balance, ownerID, acctNum);
        this.risk = risk;

    }
    public Double getRisk() {
        return risk;
    }

    public void setRisk(Double risk) {
        this.risk = risk;
    }

    public Double calcReturn(){


        Double multiplier = risk * (Math.random()/.99999);

        balance += Math.round((multiplier * balance)*100d)/100d;
        return getBalance();
    }


}
