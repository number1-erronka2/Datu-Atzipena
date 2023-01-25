package dambi.consumerestapi.repositories.MongoDB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dambi.consumerestapi.domainObjects.Langilea;
import dambi.consumerestapi.repositories.LangileaRepository;
import jakarta.annotation.PostConstruct;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.*;
import com.mongodb.client.model.*;

@Repository
public class LangileaMongoRepository implements LangileaRepository {

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

    @Override
    public void update(Langilea langilea) {
        String erabiltzailea = langilea.getErabiltzailea();
        String izena = langilea.getIzena();
        Date jaiotzeData = langilea.getJaiotzeData();
        int taldea = langilea.getTaldea();
        Bson document = new Document("erabiltzailea", erabiltzailea).append("jaiotzedata", jaiotzeData)
                .append("izena", izena).append("taldea", taldea);
        langileaCollection.updateOne(Filters.eq("erabiltzailea", erabiltzailea), document);

    }

    @Override
    public long delete(String erabiltzailea) {
        return langileaCollection.deleteOne(Filters.eq("erabiltzailea", erabiltzailea)).getDeletedCount();
    }

    @Override
    public Langilea findById(String id) {
        // return langileaCollection.find(eq("_id", new ObjectId(id))).first();
        return null;
    }

}
