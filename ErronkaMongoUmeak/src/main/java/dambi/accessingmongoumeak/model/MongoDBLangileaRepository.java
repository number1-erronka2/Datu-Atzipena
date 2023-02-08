package dambi.accessingmongoumeak.model;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

@Repository
public class MongoDBLangileaRepository implements LangileaRepository {
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
        langileaCollection = client.getDatabase("erronka").getCollection("langilea",
                Langilea.class);
    }

    @Override
    public Langilea findByIzena(String izena) {
            return langileaCollection.find(Filters.eq("izena", izena)).first();
    }

}
