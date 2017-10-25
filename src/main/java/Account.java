

abstract class Account {

    public double balance = 0;


    public double checkBalance() {
        return this.balance;
    }

    public double addFunds(double n) {
        this.balance += n;
        return this.balance;
    }

    public double withDraw(double n) {

        if (balance - n >= 0) {
            System.out.println("Successful");
            balance -= n;
        } else {
            System.out.println("Insufficient funds");
        }
        return this.balance;
    }
}