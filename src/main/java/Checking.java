public class Checking extends Account {

    public Checking() {
        this(0);
    }

    public Checking(double initialBalance) {
        super(AccountType.CHECKING, initialBalance);
    }
}
