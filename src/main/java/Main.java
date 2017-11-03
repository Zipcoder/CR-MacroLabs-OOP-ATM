


public class Main {

    public static void main(String[] args){
        Console console = new Console();
        console.frontPage();
    }

    public static void clearAll(){
        ATM atm = ATM.getInstance();
        for(User user : atm.getAllUsers()){
            user.clearAccounts();
        }
        atm.clearAllUsers();
    }



}
