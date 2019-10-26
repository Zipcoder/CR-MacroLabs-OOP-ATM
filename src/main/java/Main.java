import java.io.IOException;

public class Main {

    public static void main(String[] args){
        ATM atm = new ATM("users.csv", "accounts.csv", "transactions.csv");

        atm.serviceLoop();
    }

    // convenience methods for dev environment to clear the DBs - only called from the IDE manually
    public static void clearUserDB() {
        DB userDB = null;
        try {
            userDB = new DB("users.csv", 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        userDB.clear();
    }

    public static void clearAccountDB() {
        DB accountDB = null;
        try {
            accountDB = new DB("accounts.csv", 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        accountDB.clear();
    }

    public static void clearTransactionDB() {
        DB transactionDB = null;
        try {
            transactionDB = new DB("transactions.csv", 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        transactionDB.clear();
    }

    //find (past) transactions by user
}
