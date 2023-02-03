package dambi.atzipena;

import java.util.List;
import org.apache.log4j.*;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import dambi.domainObjects.*;

public class MongoAtzipena {
    private static String strUri = "mongodb://192.168.65.123:27017/";
    private static String strDb = "erronka";
    private static Logger logger = Logger.getLogger(MongoAtzipena.class.getName());

    /**
     * Connect to MongoDB server
     * @return
     */
    public static MongoClient connect() {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient mongo = MongoClients.create(MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(strUri))
                .codecRegistry(pojoCodecRegistry)
                .build());
        return mongo;
    }

    public static void insertPartidak(List<Partida> partidak, String jokoIzena) {
        try {
            MongoClient mongo = connect();
            MongoDatabase db = mongo.getDatabase(strDb);

            for (Partida partida : partidak) {

                Langilea langilea = new Langilea(); //Egin beharrekoa Langilea Objetua MongoDb ondo insertatzeko
                langilea.setEmail(partida.getLangilea().getEmail());
                langilea.setErabiltzailea(partida.getLangilea().getErabiltzailea());
                langilea.setIzena(partida.getLangilea().getIzena());
                langilea.setJaiotzedata(partida.getLangilea().getJaiotzedata());
                langilea.setTaldea(partida.getLangilea().getTaldea());

                Document doc = new Document("_id", partida.getId())
                        .append("data", partida.getData())
                        .append("langilea", langilea)
                        .append("puntuazioa", partida.getPuntuazioa())
                        .append("jokoIzena", jokoIzena);

                db.getCollection("partida").insertOne(doc);
            }
            logger.info("Partidak ondo gorde dira MongoDBra.");
            mongo.close();
        } catch (MongoWriteException e) {
            if (e.getError().getCode() == 11000) {
                logger.warn("An error while inserting data to MongoDB: " + e.getMessage());
            } else {
                logger.warn("An error occurred with the MongoDB server: " + e.getMessage());
            }
        } catch (Exception e) {
            logger.error("Unexpected error: " + e.getMessage());
        }
    }

    public static void insertLangileak(List<Langilea> langileak) {
        try {
            MongoClient mongo = connect();
            MongoDatabase db = mongo.getDatabase(strDb);

            for (Langilea langilea : langileak) {

                Document doc = new Document("email", langilea.getEmail())
                        .append("erabiltzailea", langilea.getErabiltzailea())
                        .append("izena", langilea.getIzena())
                        .append("jaiotzedata", langilea.getJaiotzedata())
                        .append("taldea", langilea.getTaldea());

                db.getCollection("langilea").insertOne(doc);

            }
            logger.info("Langileak ondo gorde dira MongoDBra.");
            mongo.close();
        } catch (MongoWriteException e) {
            if (e.getError().getCode() == 11000) {
                logger.warn("An error while inserting data to MongoDB: " + e.getMessage());
            } else {
                logger.warn("An error occurred with the MongoDB server: " + e.getMessage());
            }
        } catch (Exception e) {
            logger.error("Unexpected error: " + e.getMessage());
        }
    }
}
