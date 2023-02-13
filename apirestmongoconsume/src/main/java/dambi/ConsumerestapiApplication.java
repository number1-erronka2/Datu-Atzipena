package dambi;

import java.util.ArrayList;
import java.util.List;

import javax.json.JsonException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.log4j.*;

import dambi.atzipena.*;
import dambi.domainObjects.*;

public class ConsumerestapiApplication {
	private static Logger logger = Logger.getLogger(ConsumerestapiApplication.class.getName());

	private static String partidakTaldea1 = "http://192.168.65.11:8080/api/allPartidak"; //ondo
	private static String partidakTaldea2 = "http://192.168.65.22:8080/demo/all_Partida"; //ondo
	private static String partidakTaldea3 = "http://192.168.65.12:8080/proba/getCollectionsT3"; //ez daka ezebe 
	private static String partidakTaldea4 = "http://192.168.65.123:8080/Partidak/getPartidak"; //ondo

	public static void main(String[] args) {
		//insertLangileak();
		//insertPartidak(partidakTaldea1, "MahiKingdom");
		//insertPartidak(partidakTaldea2, "Taldea2");
		//insertPartidak(partidakTaldea3, "Pouni");
		insertPartidak(partidakTaldea4, "Johnny");
	}

	public static void insertPartidak(String url, String jokoIzena) {

		try {
			JsonNode jsona = ApiRestAtzipena.irakurri(url);

			List<Partida> partidaList = new ArrayList<>();
			ObjectMapper mapper = new ObjectMapper();
			Partida partida = null;
			for (JsonNode element : jsona) {
				try {
					partida = mapper.treeToValue(element, Partida.class);
				} catch (JsonException e) {
					logger.error("Errorea jsona irakurtzean: " + e.getMessage());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
				partidaList.add(partida);
			}
			MongoAtzipena.insertPartidak(partidaList, jokoIzena);
		} catch (Exception e) {
			logger.warn("Errorea json partida irakurtzean: " + e.getMessage());
		}
	}

	public static void insertLangileak() {
		try {
			JsonNode jsona = ApiRestAtzipena.irakurri("http://192.168.65.123:8080/Langileak/getLangileak");

			List<Langilea> langileakList = new ArrayList<>();
			ObjectMapper mapper = new ObjectMapper();
			Langilea langilea = null;
			for (JsonNode element : jsona) {
				try {
					langilea = mapper.treeToValue(element, Langilea.class);
				} catch (JsonException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
				langileakList.add(langilea);
			}
			MongoAtzipena.insertLangileak(langileakList);
		} catch (Exception e) {
			logger.warn("Errorea json partida irakurtzean: " + e.getMessage());
		}
	}

}