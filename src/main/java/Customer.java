import java.util.ArrayList;

public class Customer {

    private String username;
    private String password;
    private ArrayList<Account> customerAccounts;


    public Customer(){
        this.username = "UNASSIGNED";
        this.password = "PASSWORD";
        this.customerAccounts = new ArrayList<Account>();
        this.customerAccounts.add(new Checking());
    }


    public Customer(String username){
        this();
        this.username = username;

    }

    public Customer(String username, String password){
        this(username);
        this.password = password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Account> getCustomerAccounts() {
        return customerAccounts;
    }

    public void openAccount(){
        Account checking = new Checking();
        customerAccounts.add(checking);
        AccountWarehouse.addAccount(checking);


    }

    public Account lookupAcctByNumber(int accountnumber){
        for(int i = 0; i <customerAccounts.size(); i++){
            if(customerAccounts.get(i).getAcctNumber() == accountnumber){}
                return customerAccounts.get(i);
        }
        return null;
    }




    //    public String getAccountByIndex(int index){
//        return AccountList.get(index).toString();
//
//    }
//
//    public int getNumberOfAccounts(){
//        return AccountList.size();
//    }
//
//    public Account getAccountObjectByIndex(int index){
//        return AccountList.get(index);
//    }
//
//    public void addOneAccount(){
//        this.AccountList.add(new Checking());
//        return;
//
//    }
//

//    public String getAccountList() {
//        for (:
//             ) {
//
//        }
//    }

//    public ArrayList<Account> getAccount(int index){
//
//        return AccountList;
//
//    };
//

//
//    public void closeAllAccounts(){
//
//    }






//    public ArrayList[] getAccountList() {
//        return AccountList;
//    }




}
