import java.util.HashMap;
import java.util.Map;

public class Language {

    private Map<LangKey, String> langMap;
    public enum LangKey { EXAMPLE1, EXAMPLE2 }

    public Language() {

        langMap = new HashMap<LangKey, String>();
        langMap.put(LangKey.EXAMPLE1, "This is an example");
        langMap.put(LangKey.EXAMPLE2, "This is another Example");

    }

    public String getLang(LangKey key) {
        return langMap.get(key);
    }

}
