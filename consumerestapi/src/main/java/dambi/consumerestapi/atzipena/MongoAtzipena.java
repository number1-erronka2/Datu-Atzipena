package dambi.consumerestapi.atzipena;

import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;



import dambi.consumerestapi.domainObjects.*;

public class MongoAtzipena {
    private String strUri = "mongodb://192.168.65.123:27017/?maxPoolSize=20";
    private String strDb = "erronka";

    /**
     * Connect to MongoDB and return a collection of Langilea
     * @return
     */
    public MongoCollection<Langilea> connectLangilea() {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
    

        try(MongoClient mongoClient = new MongoClient(new MongoClientURI(strUri))) {
            MongoDatabase db = mongoClient.getDatabase(strDb).withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Langilea> col = db.getCollection("langileak", Langilea.class);
            return col;
        }
        
    }

    /**
     * Connect to MongoDB and return a collection of Partida
     * @return
     */
    public MongoCollection<Partida> connectPartida() {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
    

        try(MongoClient mongoClient = new MongoClient(new MongoClientURI(strUri))) {
            MongoDatabase db = mongoClient.getDatabase(strDb).withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Partida> col = db.getCollection("partida", Partida.class);
            return col;
        }
        
    }


    public List<Langilea> getLangileak() {
        try {
            MongoCollection<Langilea> col = connectLangilea();
            return col.find().into(new ArrayList<Langilea>());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Partida> getPartidak() {
        try {
            MongoCollection<Partida> col = connectPartida();
            return col.find().into(new ArrayList<Partida>());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertLangilea(Langilea langilea) {
        try {
            MongoCollection<Langilea> col = connectLangilea();
            col.insertOne(langilea);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertPartida(Partida partida) {
        try {
            MongoCollection<Partida> col = connectPartida();
            col.insertOne(partida);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertLangileak(List<Langilea> langileak){
        try{
            MongoCollection col = connectLangilea();
            col.insertMany(langileak);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertPartidak(List<Partida> partidak){
        try{
            MongoCollection col = connectPartida();
            col.insertMany(partidak);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
