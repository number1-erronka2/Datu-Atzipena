package dambi.accessingmongoumeak.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;



@Repository
public class MongoDBPartidaRepository implements PartidaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
                                                                           .readPreference(ReadPreference.primary())
                                                                           .readConcern(ReadConcern.MAJORITY)
                                                                           .writeConcern(WriteConcern.MAJORITY)
                                                                           .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Partida> partidaCollection;

    @PostConstruct
    void init() {
        partidaCollection = client.getDatabase("erronka").getCollection("partida", Partida.class);
    }


    //ikusi partida guztiak
    @Override
    public List<Partida> findAll() {
        return partidaCollection.find().into(new ArrayList<>());
    }
    
    //ikusi X puntu baino gehiago egin dituzten langileen partidak
    //ikusi langile baten partida guztiak
}
