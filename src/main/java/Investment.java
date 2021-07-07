public class Investment extends Account {
    public Investment(Double balance, Integer id) {
        super(balance, id);
    }
    public String getName() {
        return "Investment";
    }
}
