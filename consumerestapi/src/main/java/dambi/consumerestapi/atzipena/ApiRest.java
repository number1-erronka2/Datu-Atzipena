package dambi.consumerestapi.atzipena;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiRest {
    
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
            System.out.println(jsonNode);
            
            if (!jsonNode.isArray()) {
                throw new IllegalStateException("Expected array, but got: " + jsonNode.getNodeType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonNode;
    }
}
