package translate;

public class Translation {
    private static final String APP_ID = "20180226000127571";
    private static final String SECURITY_KEY = "cyL3JEoymqDWvs7rVpSV";

    //message为要翻译的句子，from为源语言，to为目的语言
    public String get_translation(String message, String from , String to){
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String result = api.getTransResult(message,from,to);
        String[] translations = result.split("\"");
        return translations[5];
    }
}
