import java.util.ArrayList;

public class User {

    ATM atm = ATM.getInstance();

    private String userName;
    private String password;

    private ArrayList accountsArray = new ArrayList();




    User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserPassword(String password){
        this.password = password;
    }
    public String getUserPassword(){
        return password;
    }

    public Object addAccount(char accountType){

        AccountFactory newAccount = new AccountFactory(accountType);

        accountsArray.add(newAccount);
        return newAccount;
    }

    public void goToAccount(int accountNum){

    }




}
