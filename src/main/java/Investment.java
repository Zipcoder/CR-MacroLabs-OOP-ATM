public class Investment extends Account {

    public Investment() {
        this(0);
    }

    public Investment(double initialBalance) {
        super(AccountType.INVESTMENT, initialBalance);
    }
}
