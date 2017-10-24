public class Savings extends Account {

    public Savings() {
        this(0);
    }

    public Savings(double initialBalance) {
        super(AccountType.SAVINGS, initialBalance);
    }
}
