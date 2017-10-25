/**
 * Created by iyasuwatts on 10/17/17.
 */
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {





        // Create and instantiate two Account objects
        Account one = new Account(new BigDecimal(50));
        Account two = new Account(new BigDecimal(50));
        //all the things/methods you can do to account one
        one.deposit(new BigDecimal(50));
        two.withdrawal(new BigDecimal(20));


        System.out.println(one.getBalance());
        System.out.println(two.getBalance());
    }


}