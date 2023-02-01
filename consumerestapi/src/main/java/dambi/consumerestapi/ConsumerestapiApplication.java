package dambi.consumerestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;

import dambi.consumerestapi.atzipena.ApiRest;

@SpringBootApplication
public class ConsumerestapiApplication {

	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerestapiApplication.class, args);

		ApiRest apiRest = new ApiRest();
		JsonNode jsona = apiRest.irakurri("http://localhost:8080/Partidak/getPartidak");

		System.out.println(jsona);
	
	}

}
