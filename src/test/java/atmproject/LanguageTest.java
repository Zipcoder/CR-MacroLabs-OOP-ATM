package atmproject;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LanguageTest {

    @Test
    public void getLangTest() {
        Language language = new Language();
        String expected = "This is an example";
        String actual = language.getLang(Language.LangKey.EXAMPLE1);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getLangTest2() {
        Language language = new Language();
        String expected = "Please select your option:\n" + "(1) - Deposit\n" + "(2) - Withdraw\n" +
                "(3) - Transfer\n" + "(4) - Balance\n" + "(5) - View History\n" + "(6) - Create new Account\n" + "(7) - Exit ATM";
        String actual = language.getLang(Language.LangKey.MAINMENU);
        Assert.assertEquals(expected,actual);
    }
}