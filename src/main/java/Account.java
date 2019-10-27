import java.util.ArrayList;
import java.util.Scanner;

public class Account {

    private String firstName;
    private String lastName;
    private Double checkingBalance;
    private Double savingBalance;
    private Double investBalance;
    private String transaction;


    private Scanner scanner = new Scanner(System.in);

    ///CONSTRUCTOR///
    public Account(String firstName, String lastName){

        this.firstName = firstName;
        this.lastName = lastName;
        this.checkingBalance = 0.0;
        this.savingBalance = 0.0;
        this.investBalance = 0.0;
        this.transaction = "";

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getCheckingBalance() {
        return checkingBalance;
    }

    public Double getSavingBalance() {
        return savingBalance;
    }

    public Double getInvestBalance() {
        return investBalance;
    }

    public void depositChecking(double amount){
        this.checkingBalance += amount;
    }
    public void withdrawChecking(double amount){

        this.checkingBalance -= amount;
    }
    public void depositSaving(double amount){
        this.savingBalance += amount;
    }
    public void withdrawInvest(double amount){
        this.savingBalance -= amount;
    }
    public void depositInvest(double amount){
        this.investBalance += amount;
    }
    public void withdrawSaving(double amount){
        this.investBalance -= amount;
    }
    public void setTransaction(String history){
        this.transaction += history;
    }


}
