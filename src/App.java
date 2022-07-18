import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;



public class App {
    public static void main(String[] args) throws Exception {
        
        //fazer uma conexão http: request/response

        //uri é o mais genérico
        var url = "https://api.mocki.io/v2/549a5d8b"; //a api do imdb aqui - usando uma alternativa

        var uri = URI.create(url); //URI contem uma url

        //o java.net ja é a lib padrão p/ http

        var client = HttpClient.newHttpClient(); //criar novo cliente
       
        var request = HttpRequest.newBuilder(uri).GET().build(); //criando o request

        var json = client.send(request, HttpResponse.BodyHandlers.ofString()); //response
        
        //extrair só os dados que interessam (parsear) - utilizando expressões regulares -regex - Jackson

        JsonParser parser = new JsonParser();

        List<Map<String, String>> listaDeFilmes = parser.parse(json.body());

        System.out.println(listaDeFilmes.size());
System.out.println(listaDeFilmes.get(0));

for (Map<String,String> filme : listaDeFilmes) {
    System.out.println(filme.get("title"));
    System.out.println(filme.get("image"));
    System.out.println(filme.get("imDbRating"));
    System.out.println();
}
        //exibir e manipular os dados
        
      //  System.out.println(listaDeFilmes); //sout
    }
}
