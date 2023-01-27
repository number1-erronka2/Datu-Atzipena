package dambi.consumerestapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
@EnableMongoRepositories(basePackages = "dambi.consumerestapi.repositories")
public class SpringMongoConfiguration {

    MongoDatabaseFactory mongoDbFactory =
        new SimpleMongoClientDatabaseFactory(com.mongodb.client.MongoClients.create(), "erronka");

    @Bean
    MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
        return mongoTemplate;
    }
}
