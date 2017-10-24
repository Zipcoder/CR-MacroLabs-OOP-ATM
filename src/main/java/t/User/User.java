package t.User;

public class User {
    private  String name;
    private  Integer accountNumber;
    private  String password;

    public User(String name, int accountNumber, String password) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return this.accountNumber;
    }

    public String isFemale() {
        return password;
    }
}
