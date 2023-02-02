package dambi.accessingmongoumeak.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;



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
    
    //ikusi partida guztiak Id-a bilatzen 
    @Override
    public Partida findById(int id) {
        return partidaCollection.find(Filters.eq("_id", id)).first();      
    }

    //ikusi X puntu baino gehiago egin dituzten langileen partidak
    //$gt de MongoDB para encontrar documentos cuyo campo puntuazioa sea mayor que el campo metido
    @Override
    public List<Partida> findByPuntuazioa(int puntuazioa) {
        return partidaCollection.find(new Document("puntuazioa", new Document("$gt", puntuazioa)))
                            .into(new ArrayList<>());
    }
    
    //ikusi langile baten partida guztiak
    @Override
    public List<Partida> findByIzena(String erabiltzailea) {
        return partidaCollection.find(Filters.eq("langilea.erabiltzailea", erabiltzailea)).into(new ArrayList<>());
    }

    //ikusi talde baten partidak
    @Override 
    public List<Partida> findByTaldea(int taldea){
        return partidaCollection.find(Filters.eq("langilea.taldea", taldea)).into(new ArrayList<>());
    }

    //ikusi langile baten partidak email batengatik
    @Override
    public List<Partida> findByEmail(String email) {
        return partidaCollection.find(Filters.eq("langilea.email", email)).into(new ArrayList<>());
    }

    //ikusi langile baten partidak date ikusita

}
