import java.util.ArrayList;

public class User {

    private static int id;
    private String userName;
    private String password;
    protected static ArrayList<Account> accounts = new ArrayList<>();

    {
        //gives three accounts to user upon creation
        CheckingAccount checking = new CheckingAccount();
        accounts.add(0, checking);
        SavingsAccount saving = new SavingsAccount();
        accounts.add(1, saving);
        InvestmentAccount invest = new InvestmentAccount();
        accounts.add(2, invest);
    }

    public User(String userName, String password, int id) {
        this.userName = userName;
        this.password = password;
        this.id = id;
        id++;

    }


//    public void addCheckingAccount() {
//        CheckingAccount checking = new CheckingAccount();
//        accounts.add(checking);
//    }

    public void addSavingsAccount() {
        SavingsAccount savings = new SavingsAccount();
        accounts.add(1,savings);
    }

    public void addInvestmentAccount() {
        InvestmentAccount invest = new InvestmentAccount();
        accounts.add(2,invest);
    }

    private void removeCheckingAccount() {

        accounts.remove(0);
    }

    private void removeSavingsAccount() {

        accounts.remove(1);
    }

    private void removeInvestmentAccount() {

        accounts.remove(2);
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(ArrayList<Account> accounts) {
        User.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Username: " + this.getUserName() +
                "\nPassword: " + this.getPassword() +
                "\nId: " + this.getId();
    }


}
