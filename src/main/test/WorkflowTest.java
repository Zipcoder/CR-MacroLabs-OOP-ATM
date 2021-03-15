import org.junit.Test;

public class WorkflowTest {

    @Test
    public void Test1() {

        Workflow w = new Workflow();

        Account acct = new Savings(12, 34.0);
        Account[] accts = new Account[1];
        accts[0] = acct;
        Customer customer = new Customer("Hazel", "HD", "45", accts);

        String user = w.getUserSP();
        w.mainMenuSP(customer);
        w.withdrawPromptSP();
        Double dub1 = w.amountPromptSP();
        w.completeResultSP(accts[0]);
        w.printHistory();
    }
}
