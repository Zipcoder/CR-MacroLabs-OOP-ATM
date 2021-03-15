


// Test the expected Account class from ATM.
//public class BankAccountTest {
//
//    @Test
//    public void constructorCActTypeTest1() { // tests creation of checking account - type field
//        // Arrange
//        Account testAccount = new Account();
//        System.out.println(testAccount.checking.type);
//        String givenCAcctType = "Checking";
//        String returnedCAcctType = testAccount.checking.type;
//        Assert.assertEquals(givenCAcctType, returnedCAcctType);
//
//    }
//
//    @Test
//    public void constructorCActBalTest2() { // tests creation of checking account - balance equals zero @ creation
//        // Arrange
//        Account testAccount = new Account();
//        System.out.println(testAccount.checking.balance);
//        double givenCAcctBal = 0.00;
//        double returnedCAcctBal = testAccount.checking.balance;
//        Assert.assertEquals(givenCAcctBal, returnedCAcctBal);
//    }
//
//    @Test
//    public void constructorTestSActType3() { // tests creation of savings account - type field
//        // Arrange
//        Account testAccount = new Account();
//        System.out.println(testAccount.savings.type);
//        String givenSAcctType = "Savings";
//        String returnedSAcctType = testAccount.savings.type;
//        Assert.assertEquals(givenSAcctType, returnedSAcctType);
//
//    }
//
//    @Test
//    public void constructorTestSActBal4() { // tests creation of savings account - balance equals zero @ creation
//        // Arrange
//        Account testAccount = new Account();
//        System.out.println(testAccount.savings.balance);
//        double givenSAcctBal = 0.00;
//        double returnedSAcctBal = testAccount.savings.balance;
//        Assert.assertEquals(givenSAcctBal, returnedSAcctBal);
//
//    }
//
//    @Test
//    public void constructorTestTxHxType5() { // tests creation of transactionHistory - type
//        // Arrange
//        Account testAccount = new Account();
//        System.out.println(testAccount.TxnHistory.type);
//        String givenTxHxType = "Transaction";
//        String returnedTxHxType = testAccount.TxnHistory.type;
//        Assert.assertEquals(givenTxHxType, returnedTxHxType);
//
//    }
//
//    @Test
//    public void depositMoneyTest1() {
//        // Arrange
//        Scanner sc = new Scanner(System.in);
//        Integer depAccount = sc.nextInt(1);
//        Account testAccount = new Account();
//        testAccount.depositMoney();
//
//    }
//
//    @Test
//    public void withdrawMoneyTest1() {
//
//    }
//
//    @Test
//    public void transferMoneyTest1() {
//
//    }
//
//    @Test
//    public void checkBalance1() {
//
//    }




//    @Test
//    public void testA0() {
//        Account a = new Account(0.0);
//        assertEquals(0.0, a.balance(), 0.0001);
//    }
//
//    @Test
//    public void testA00() {
//        Account a = new Account(10.0);
//        assertEquals(10.0, a.balance(), 0.0001);
//    }
//
//    @Test
//    public void testA01() {
//        Account a = new Account(0.0);
//        assertEquals(true, a.closeAccount());
//    }
//
//    @Test
//    public void testA02() {
//        Account a = new Account(10.0);
//        assertEquals(false, a.closeAccount());
//    }
//
//    @Test
//    public void testA1() {
//        Account a = new Account(0.0);
//        a.deposit(100.0);
//        assertEquals(100.0, a.balance(), 0.0001);
//    }
//
//    @Test
//    public void testA2() {
//        Account a = new Account(10.0);
//        a.deposit(100.0);
//        assertEquals(110.0, a.balance(), 0.0001);
//    }
//
//    @Test
//    public void testA3() {
//        Account a = new Account(200.0);
//        Double actual = a.withdraw(100.0);
//        assertEquals(100.0, actual, 0.0001);
//    }
//
//    @Test
//    public void testA4() {
//        Account a = new Account(0.0);
//        Double actual = a.withdraw(1.0);
//        assertEquals(0.0, actual, 0.0001);
//    }
//
//    @Test
//    public void testA5() {
//        Account a = new Account(10.0);
//        Account b = new Account(0.0);
//        a.transfer(b, 10.0);
//        assertEquals(0.0, a.balance(), 0.0001);
//        assertEquals(10.0, b.balance(), 0.0001);
//    }
//
//    @Test
//    public void testA6() {
//        Account a = new Account(10.0);
//        Account b = new Account(0.0);
//        a.transfer(b, 100.0); // nothing should happen
//        assertEquals(10.0, a.balance(), 0.0001);
//        assertEquals(0.0, b.balance(), 0.0001);
//    }


//}
