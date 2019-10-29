public class Account {

    private Double checkingBalance;
    private Double savingBalance;
    private Double investBalance;


    public Account(){


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
    }
}
