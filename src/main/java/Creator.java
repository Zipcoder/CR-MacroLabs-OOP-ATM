public class Creator {

    public static Customer createCustomer(String name, String userName, String password, Account... accounts) {
        return new Customer(name, userName, password, accounts);
    }

    public static Checking createChecking(double initialDeposit) {
        Integer newAccountNumber = (int)(Math.random() * ((999-100) + 1) + 100);
        return new Checking(newAccountNumber, initialDeposit);
    }

    public static Savings createSavings(double initialDeposit) {
        Integer newAccountNumber = (int)(Math.random() * ((9999-1000) + 1) + 1000);
        return new Savings(newAccountNumber, initialDeposit);
    }

    public static Investment createInvestment(double initialDeposit) {
        Integer newAccountNumber = (int)(Math.random() * ((99999-10000) + 1) + 10000);
        return new Investment(newAccountNumber, initialDeposit);
    }

}
