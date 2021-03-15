import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void addCustomerTest() {
        // : Given
        Checking bruceChecking = Creator.createChecking(100);
        Savings bruceSaving = Creator.createSavings(500);
        Customer bruce = Creator.createCustomer("Bruce", "Bat", "Gotham", bruceChecking, bruceSaving);

        // : When
        Database.removeAllCustomers();
        Database.addCustomer(bruce);
        int expected = 1;
        int actual = Database.getNumberOfCustomers();

        System.out.println(Database.getNumberOfCustomers());

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCustomerByNameTest() {
        Checking bruceChecking = Creator.createChecking(100);
        Savings bruceSaving = Creator.createSavings(500);
        Checking batmanChecking = Creator.createChecking(500);
        Savings batmanSavings = Creator.createSavings(1000);
        Customer bruce = Creator.createCustomer("Bruce", "Bat", "Gotham", bruceChecking, bruceSaving);
        Customer batman = Creator.createCustomer("Batman", "h", "y", batmanChecking, batmanSavings);

        // : When
        Database.removeAllCustomers();
        Database.addCustomer(bruce);
        Database.addCustomer(batman);
        Customer expected = batman;
        Customer actual = Database.getCustomerByName("Batman");

        System.out.println(Database.getNumberOfCustomers());

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCustomerByUsernameTest() {
        Checking bruceChecking = Creator.createChecking(100);
        Savings bruceSaving = Creator.createSavings(500);
        Checking batmanChecking = Creator.createChecking(500);
        Savings batmanSavings = Creator.createSavings(1000);
        Customer bruce = Creator.createCustomer("Bruce", "Bat", "Gotham", bruceChecking, bruceSaving);
        Customer batman = Creator.createCustomer("Batman", "h", "y", batmanChecking, batmanSavings);

        // : When
        Database.removeAllCustomers();
        Database.addCustomer(bruce);
        Database.addCustomer(batman);
        Customer expected = batman;
        Customer actual = Database.getCustomerByUsername("h");

        System.out.println(Database.getNumberOfCustomers());

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeCustomerTest() {
        Checking bruceChecking = Creator.createChecking(100);
        Savings bruceSaving = Creator.createSavings(500);
        Checking batmanChecking = Creator.createChecking(500);
        Savings batmanSavings = Creator.createSavings(1000);
        Customer bruce = Creator.createCustomer("Bruce", "Bat", "Gotham", bruceChecking, bruceSaving);
        Customer batman = Creator.createCustomer("Batman", "h", "y", batmanChecking, batmanSavings);

        // : When
        Database.removeAllCustomers();
        Database.addCustomer(bruce);
        Database.addCustomer(batman);
        Database.removeCustomer(bruce);
        int expected = 1;
        int actual = Database.getNumberOfCustomers();

        System.out.println(Database.getNumberOfCustomers());

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeAllCustomersTest() {
        Checking bruceChecking = Creator.createChecking(100);
        Savings bruceSaving = Creator.createSavings(500);
        Checking batmanChecking = Creator.createChecking(500);
        Savings batmanSavings = Creator.createSavings(1000);
        Customer bruce = Creator.createCustomer("Bruce", "Bat", "Gotham", bruceChecking, bruceSaving);
        Customer batman = Creator.createCustomer("Batman", "h", "y", batmanChecking, batmanSavings);

        // : When
        Database.addCustomer(bruce);
        Database.addCustomer(batman);
        Database.removeAllCustomers();
        int expected = 0;
        int actual = Database.getNumberOfCustomers();

        System.out.println(Database.getNumberOfCustomers());

        // : Then
        Assert.assertEquals(expected, actual);
    }
}