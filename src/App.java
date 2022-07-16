import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws Exception {
        
        var url = "https://imdb-api.com/en/API/Top250Movies/k_jhl7ya19";

        var uri = URI.create(url); //URI contem uma url

        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(uri).build();

        var json = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        
        
        
        System.out.println(json);
    }
}
