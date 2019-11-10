package atmproject;

import java.util.HashMap;
import java.util.Map;

public class Language {

    private Map<LangKey, String> langMap;
    public enum LangKey { EXAMPLE1, EXAMPLE2,MAINMENU }

    public Language() {

        langMap = new HashMap<LangKey, String>();
        langMap.put(LangKey.EXAMPLE1, "This is an example");
        langMap.put(LangKey.EXAMPLE2, "This is another Example");
        langMap.put(LangKey.MAINMENU, "Please select your option:\n" + "(1) - Deposit\n" + "(2) - Withdraw\n" +
                "(3) - Transfer\n" + "(4) - Balance\n" + "(5) - View History\n" + "(6) - Create new Account\n" + "(7) - Return To Login Menu");

    }

    public String getLang(LangKey key) {
        return langMap.get(key);
    }

}
