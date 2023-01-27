package dambi.consumerestapi.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;

import dambi.consumerestapi.domainObjects.Langilea;
import jakarta.annotation.PostConstruct;

@Repository
public class MongoLangileakRepo implements LangileaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();


    @Autowired
    private MongoClient client;
    private MongoCollection<Langilea> langileaCollection;

    @PostConstruct
    void init() {
        langileaCollection = client.getDatabase("erronka").getCollection("langileak", Langilea.class);
    }

    @Override
    public Langilea save(Langilea langilea) {
        langileaCollection.insertOne(langilea);
        return langilea;
    }

    @Override
    public List<Langilea> findAll() {
        return langileaCollection.find().into(new ArrayList<>());
    }

}
