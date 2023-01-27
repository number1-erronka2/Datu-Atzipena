package dambi.consumerestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.reactive.function.client.WebClient;
import dambi.consumerestapi.repositories.MongoLangileakRepo;

@SpringBootApplication
@ComponentScan(basePackages = "dambi.consumerestapi.*")
@EntityScan("dambi.consumerestapi.*")
@EnableMongoRepositories(basePackages = "dambi.consumerestapi.repositories")
public class ConsumerestapiApplication {

	@Bean
	public WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}

	@Bean
    public MongoLangileakRepo mongoLangileakRepo(){
        return new MongoLangileakRepo();
    }

	public static void main(String[] args) {
		SpringApplication.run(ConsumerestapiApplication.class, args);
	}

}
