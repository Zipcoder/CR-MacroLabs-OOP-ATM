import java.util.ArrayList;

public class User implements Storeable {

    private String firstName;
    private String lastName;
    private String password;
    private Integer userID;
    private Integer cardNumber;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> pendingTransactions;

    public User(String firstName, String lastName, String password, Integer userID, Integer cardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userID = userID;
        this.cardNumber = cardNumber;

        this.accounts = null;
    }

    public User(Integer userId, String password, DB data) {

    }

    public static Integer genCardNum() {
        String numString = "";
        for (int i = 0; i < 8; i++) {
            Integer num;
            if(i == 0 || i == 7) {
                num = (int)(Math.random() * 9 + 1);
            } else {
                num = (int)(Math.random() * 10);
            }

            numString += num.toString();
            System .out.print(num + ", ");
        }
        return Integer.parseInt(numString);
    }

    public ArrayList<Transaction> getUserHistory() {

        return pendingTransactions;
    }

    public String getPassword() {
        return password;
    }

    public Integer getUserID() {
        return userID;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<Transaction> getPendingTransactions() {
        return pendingTransactions;
    }

    @Override
    public String[] toStringArray() {
        String[] result = new String[] {
                this.userID.toString(),
                this.lastName,
                this.firstName,
                this.cardNumber.toString(),
                this.password
        };
        return result;
    }

}
