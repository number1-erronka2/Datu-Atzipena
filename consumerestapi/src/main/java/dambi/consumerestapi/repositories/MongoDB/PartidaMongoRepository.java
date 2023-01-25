package dambi.consumerestapi.repositories.MongoDB;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import dambi.consumerestapi.domainObjects.Partida;
import dambi.consumerestapi.repositories.PartidaRepository;
import jakarta.annotation.PostConstruct;

import java.util.List;

@Repository
public class PartidaMongoRepository implements PartidaRepository {

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
    
    @Override
    public Partida save(Partida partida) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Partida> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Partida partida) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public long delete(int id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Partida findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
