

public class LogIn {

    Integer indexOfUsername;

    public boolean checkUserAndPass(String username, String password){
        Account newAcc = new Account();
        this.indexOfUsername = newAcc.getUsername(username);

            if (indexOfUsername != -1){
                return newAcc.getPassword(password, indexOfUsername);
            }

        return false;
    }


}

