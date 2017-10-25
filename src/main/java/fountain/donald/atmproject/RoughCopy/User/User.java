package fountain.donald.atmproject.RoughCopy.User;

public class User {
    public static    String name;
    public static    Integer accountNumber;
    public static    String password;

    public User(String name, int accountNumber, String password) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }
}
