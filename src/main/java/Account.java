import java.util.ArrayList;

abstract class Account {
    private double balance = 0;

    private ArrayList<String> history = new ArrayList();

    public double checkBalance() {
        return this.balance;
    }

    public double addFunds(double n) {
        this.balance += n;
        history.add("Deposited: $" + n);
        return this.balance;
    }

    public double withDraw(double n) {

        if (balance - n >= 0) {
            System.out.println("Successful");
            history.add("Withdrawn: $" + n);
            balance -= n;
        } else {
            System.out.println("Insufficient funds");
        }
        return this.balance;
    }

    public String printHistory() {
        String a = "";
        for (String x : history) {
            System.out.println(x);

            a += x;
        }
        return a;
    }
}