package dambi.accessingmongoumeak.model;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.ArrayList;

@Repository
public class MongoDBBalorazioaRepository implements BalorazioaRepository {
    public static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();

    @Autowired
    private MongoClient client;
    private MongoCollection<Balorazioa> balorazioak;

    @PostConstruct
    void init() {
        balorazioak = client.getDatabase("erronka").getCollection("balorazioak", Balorazioa.class);
    }

    @Override
    public List<Balorazioa> findAll() {
        List<Balorazioa> blist = new ArrayList<>();
        MongoCollection<Document> collection = client.getDatabase("erronka").getCollection("balorazioak");
        for(Document d : collection.find()) {
            Balorazioa b = new Balorazioa();
            Document id = (Document) d.get("_id");
            b.setJokoa(id.getString("jokoa"));
            b.setErabiltzailea(id.getString("erabiltzailea"));
            b.setPuntuazioa(d.getInteger("puntuazioa"));
            b.setKomentarioa(d.getString("komentarioa"));
            blist.add(b);
        }
        return blist;
    }
}
