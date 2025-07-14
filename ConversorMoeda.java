import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConversorMoeda {

    private final String apiKey = "295c3b1dc897f7c9965ef928";

    public void consultar(String moedaBase, String moedaAlvo, double valor) {
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moedaBase;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject json = gson.fromJson(response.body(), JsonObject.class);

            if (json.get("result").getAsString().equals("success")) {
                JsonObject rates = json.getAsJsonObject("conversion_rates");
                double taxa = rates.get(moedaAlvo).getAsDouble();

                double valorConvertido = valor * taxa;
                System.out.printf("A taxa de conversão é: 1 %s = %.4f %s%n", moedaBase, taxa, moedaAlvo);
                
                System.out.printf("O valor de %.2f %s corresponde a %.2f %s%n", valor, moedaBase, valorConvertido, moedaAlvo);
    
            } else {
                System.out.println("Erro da API: " + json.get("error-type").getAsString());
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao consultar API: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
