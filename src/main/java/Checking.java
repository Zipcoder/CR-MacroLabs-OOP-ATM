public class Checking extends Account {
    public Checking(Double balance, Integer id) {
        super(balance, id);
    }

    public String getName() {
        return "Checking";
    }
}
