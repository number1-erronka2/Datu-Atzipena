package dambi.atzipena;

import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiRestAtzipena {
    
    public static JsonNode irakurri(String urlSartutakoa){
        JsonNode jsonNode = null;
        try {
            URL url = new URL(urlSartutakoa);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
        
            InputStream inputStream = connection.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            jsonNode = objectMapper.readValue(inputStream, JsonNode.class);
            
            if (!jsonNode.isArray()) {
                throw new IllegalStateException("Expected array, but got: " + jsonNode.getNodeType());
            }
        } catch (ConnectException exception) {
            System.out.println("Errorea ApiRest-era konektatzean:" + exception.getMessage() + " URL:" + urlSartutakoa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonNode;
    }
}
