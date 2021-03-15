import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AtmEngine {

    Map<String, List<Account>> bank=new HashMap<String, List<Account>>();

    //No need for parameters right now, as far as I can tell.
    public AtmEngine(){}


    public void addNewAccount(String passcode, Account newAccount){
        List<Account> tempList = bank.get(passcode);
        if(tempList == null) {
            tempList = new ArrayList<>();
            bank.put(passcode, tempList);
        }
        tempList.add(newAccount);
    }

    //Method to close an account
    public void closeAccount(String password, int whichOne){
        List<Account>currentUserAccounts= bank.get(password);
        if(currentUserAccounts.get(whichOne).closeAccount()){
            currentUserAccounts.remove(whichOne);
        }
    }


    //Method to show list of available accounts under a passcode
    public void printAllAccounts(String password){
        List<Account>currentUserAccounts= bank.get(password);
        for(int i=0; i<currentUserAccounts.size();i++){
            System.out.println("Account #:"+(i+1)+" Type:"+currentUserAccounts.get(i).getAccountType());
            System.out.println("Balance-------->"+currentUserAccounts.get(i).getBalance());
        }
    }


    //Method to transfer funds between existing accounts
    public void transfer(String password, Integer accountGiving, Integer accountReceiving, Double cash){
        List<Account>currentUserAccounts= bank.get(password);
        currentUserAccounts.get(accountGiving).transfer(currentUserAccounts.get(accountReceiving),cash);
    }


    //Method to withdraw from a chosen account
    public void withdrawCash(String password, Integer accountUsed, Double cash){
        List<Account>currentUserAccounts= bank.get(password);
        currentUserAccounts.get(accountUsed).withdraw(cash);
    }

    //Method to withdraw money from a chosen account.
    public void depositCash(String password, Integer accountUsed, Double cash){
        List<Account>currentUserAccounts= bank.get(password);
        currentUserAccounts.get(accountUsed).deposit(cash);
    }

    public void showAccountTransactions(String password, Integer accountUsed){
        List<Account>currentUserAccounts=bank.get(password);
        System.out.println("Transaction history for account #: "+(accountUsed+1));
        currentUserAccounts.get(accountUsed).showTransactionHistory();
    }

    //Method to ensure given password exists in database.
    public Boolean userExists(String password){
        for (String i : bank.keySet()) {
            if(i.equals(password)){return true;}
        }
        return false;
    }

    public Integer sizeOfAccountList(String password){
        List<Account>currentUserAccounts= bank.get(password);
        return currentUserAccounts.size();
    }


}
