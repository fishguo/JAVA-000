package homeWork2.HttpClient.src.main.java;

public class TestGet {
    public static void main(String[] args) {
        final String url = "http://127.0.0.1:8801";
        FishHttpClient httpClient = new FishHttpClient(5000,5000,100);
        try {
            ResponseType rs = httpClient.get(url,ResponseType.class,MarshalingType.XML);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
