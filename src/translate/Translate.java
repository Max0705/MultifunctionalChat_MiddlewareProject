package translate;

public class Translate {
    private static final String APP_ID = "20180226000127571";
    private static final String SECURITY_KEY = "cyL3JEoymqDWvs7rVpSV";
    TransApi api = new TransApi(APP_ID, SECURITY_KEY);
    public String get_translation(String message,String from, String to)
    {
        String transResult = api.getTransResult(message,from,to);
        String[] client1= transResult.split("\"");
        return client1[5];
    }
}
