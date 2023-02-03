package dambi;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.log4j.*;

import dambi.atzipena.*;
import dambi.domainObjects.*;

public class ConsumerestapiApplication {
	private static Logger logger = Logger.getLogger(ConsumerestapiApplication.class.getName());

	private static String partidakTaldea1 = "http://192.168.65.11:8080/api/allPartidak";
	private static String partidakTaldea2 = "http://192.168.65.6:8080/demo/all_Partida";
	private static String partidakTaldea3 = "http://192.168.65.12:8080/demo/get";
	private static String partidakTaldea4 = "http://localhost:8080/Partidak/getPartidak";

	public static void main(String[] args) {
		insertLangileak();
		insertPartidak(partidakTaldea1, "Taldea1");
		insertPartidak(partidakTaldea2, "Taldea2");
		insertPartidak(partidakTaldea3, "Taldea3");
		insertPartidak(partidakTaldea4, "Jonnhy");
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
				} catch (JsonProcessingException e) {
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
		JsonNode jsona = ApiRestAtzipena.irakurri("http://localhost:8080/Langileak/getLangileak");

		List<Langilea> langileakList = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		Langilea langilea = null;
		for (JsonNode element : jsona) {
			try {
				langilea = mapper.treeToValue(element, Langilea.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
			langileakList.add(langilea);
		}
		MongoAtzipena.insertLangileak(langileakList);
	}

}