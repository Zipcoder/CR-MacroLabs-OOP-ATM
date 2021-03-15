/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {
    private boolean engineOn = true;

    public static void main(String[] args) {
        Main main = new Main();
        Motherboard ATM = new Motherboard();
        Workflow screen = new Workflow();
        Customer xiong = Creator.createCustomer("xiong", "xyuan", "zipcode", new Checking(100, 1500), new Savings(1000, 2500), new Investment(10000, 6000));
        Customer mike = Creator.createCustomer("mike", "ninh", "zipcode", new Checking(101, 1500), new Savings(1001, 2500), new Investment(10001, 6000));
        Customer hazel = Creator.createCustomer("hazel", "hbecker", "zipcode", new Checking(102, 1500), new Savings(1002, 2500), new Investment(10002, 6000));
        Customer lena = Creator.createCustomer("lena", "llitouka", "zipcode", new Checking(103, 1500), new Savings(1003, 2500), new Investment(10003, 6000));
        Database.addMultipleCustomers(xiong, mike, hazel, lena);

        while (main.engineOn) {
            ATM.runEngine(screen);
        }
    }
}
