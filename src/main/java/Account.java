public class Account {

    String type;
    double balance;


    void setType(String accType) {
        type = accType;
    }
    void setBalance(Double accBal) {
        balance = accBal;
    }

    void deposit(Double dep) {
        balance = balance +  dep;
    }
    void withdraw(Double wit) {
        balance = balance - wit;
    }
    Double getBalance() {
        return balance;
    }
}