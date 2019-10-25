/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {

    public static void main(String[] args){
        ATM atm = new ATM();

        atm.serviceLoop();
    }

    // convenience methods for dev environment to clear the DBs - only called from the IDE manually
    public static void clearUserDB(DB userDB) {
        userDB.clear();
    }

    public static void clearAccountDB(DB accountDB) {
        accountDB.clear();
    }

    public static void clearTransactionDB(DB transactionDB) {
        transactionDB.clear();
    }
}
