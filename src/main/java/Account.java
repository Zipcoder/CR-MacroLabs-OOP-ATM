public class Account {

    String accoutHolder[][] = new String [4][10];
    private Double checkingBalance;
    private Double savingBalance;
    private Double investBalance;


    public Account(){

        //Username and password of client that already exists
        accoutHolder[0][0] = "JaneDoe";
        accoutHolder[1][0] = "p123";

        //Username and password of client that already exists
        accoutHolder[0][1] = "JohnS";
        accoutHolder[1][1] = "MK67";

    }

    public Integer getUsername(String username){

        for (int index = 0; index < 5; index ++){

            if ( username.equals(accoutHolder[0][index])){
                return index;
            }
        }

        return -1;
    }

    public boolean getPassword(String password, Integer index){

            if (password.equals(accoutHolder[1][index])){
                return true;
            }

        return false;
    }


    public String setNewAccount(String username, String password){

        for (int index = 0; index < 5; index++){

            if (accoutHolder[0][index] == null){

                accoutHolder[0][index] = username;
                accoutHolder[1][index] = password;

                return "Username: " + accoutHolder[0][index] + " and password: " + accoutHolder[1][index] +
                        " was created.";
            }

        }

        return "Can't create account";
    }

  /*  public void setFirstName() {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName() {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getCheckingBalance() {
        return checkingBalance;
    }

    public void depositChecking(Double deposit) {
        this.checkingBalance += deposit;
    }

    public void withdrawChecking(Double withdraw) {
        this.checkingBalance -= withdraw;
    }

    public Double getSavingBalance() {
        return savingBalance;
    }

    public void depositSaving(Double deposit) {
        this.savingBalance += deposit;
    }

    public void withdrawSaving(Double withdraw) {
        this.savingBalance -= withdraw;
    }

    public Double getInvestBalance() {
        return investBalance;
    }

    public void depositInvest(Double deposit) {
        this.investBalance += deposit;
    }

    public void withdrawInvest(Double withdraw) {
        this.investBalance -= withdraw;
    }*/
}
