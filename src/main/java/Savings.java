public class Savings extends Account {

    public Savings(Double balance, Integer id) {
        super(balance, id);
    }

    public String getName() {
        return "Savings";
    }
}
