import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

public class Convertor {
    private final String apiKey = "d82cee867383c79a936d6dee";


    public double convertirMonedas(String actual, String objetivo, double cantidad){
        try{
            String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + actual;
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            double conversionRate = root.getAsJsonObject().getAsJsonObject("conversion_rates").get(objetivo).getAsDouble();
            return conversionRate * cantidad;
        }catch(IOException e){
            e.printStackTrace();
            return 0;
        }
    }
}
