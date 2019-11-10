import java.util.ArrayList;

public class Account {
    private Integer accountID;
    private Double balance;
    private ArrayList<String> transactionHistory;

    public Account(Double balance, Integer id) {
        this.balance = balance;
        this.accountID = id;
        this.transactionHistory = new ArrayList<String>();
    }

    public Account(Double balance) {
        this.accountID = 0;
        this.balance = balance;
        this.transactionHistory = new ArrayList<String>();

    }

    public void deposit(Double amount) {
        if (amount > 0.0) {
            this.setBalance(this.getBalance() + amount, String.format("Deposit to %s", this.getAccountID()));
        }
    }

    public Double withdraw(Double amount) {
        if (amount > 0 && amount <= this.getBalance()) {
            this.setBalance(this.getBalance() - amount, String.format("Withdraw from %s", this.getAccountID()));
        }
        return this.getBalance();
    }

    public void transfer(Account too, Double amount) {
        if (this.balance >= amount && amount > 0) {
            this.setBalance(this.getBalance() - amount, String.format("Transfer to %s", too.getAccountID()));
            too.setBalance(too.getBalance() + amount, String.format("Transfer from %s", this.getAccountID()));
        } else Console.println("Sorry, not enough currency to transfer.");
    }

    public boolean closeAccount() {
        return (getBalance() == 0.0);
    }

    //////GETTERS AND SETTERS//////
    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public Double getBalance() {
        return balance;
    }

    public Double balance() {
        return balance;
    }


    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public void setBalance(Double balance, String transactionType) {
        Double oldBal = this.getBalance();
        this.setBalance(balance);
        Double amount = this.getBalance() - oldBal;
        String report = buildTransactionReport(oldBal, this.getBalance(), amount, transactionType);
        addTransactionReportToTransactionHistory(report);
    }

    public String buildTransactionReport(Double oldBalance, Double newBalance, Double amountTransferred, String transactionType) {
        return String.format("Transaction: %s $%.2f\n\tOld Balance:\t$%.2f\n\tNew Balance:\t$%.2f",
                transactionType, amountTransferred, oldBalance, newBalance);
    }

    public void addTransactionReportToTransactionHistory(String transactionReport) {
        transactionHistory.add(transactionReport);
        Console.println("\n\n"+transactionReport+"\n\n");
    }

    public ArrayList<String> getTransactionHistory() {
        return this.transactionHistory;
    }

    public String getPrintableHistory() {
        StringBuilder history = new StringBuilder();
        history.append("Transaction History:");
        for (String report : this.getTransactionHistory()) {
            history.append("\n"+report);
        }
        return history.toString();
    }

    public String getName(){
        return "Account";
    }
}
