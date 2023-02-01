package dambi.consumerestapi.atzipena;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import dambi.consumerestapi.domainObjects.Langilea;
import dambi.consumerestapi.domainObjects.Partida;

@RestController
@RequestMapping(path = "/postgresConsumer") 
public class ApiRestAtzipena {
    
    @Autowired
    private WebClient.Builder webClientBuilder;

    

    @GetMapping("/langileak")
    public List<Langilea> getLangileak() {
        List<Langilea> langileak = webClientBuilder.build()
                        .get()
                        .uri("http://localhost:8080/Langileak/getLangileak")
                        .retrieve()
                        .bodyToFlux(Langilea.class)
                        .collectList()
                        .block();
        return langileak;
    }

    /**
     * 1.Taldearen get Partidak metodoa
     */
    @GetMapping("/partidak1")
    public List<Partida> getPartidakMarkel() {
        List<Partida> partidak = webClientBuilder.build()
                        .get()
                        .uri("http://192.168.65.11:8080/api/allPartidak")
                        .retrieve()
                        .bodyToFlux(Partida.class)
                        .collectList()
                        .block();
        return partidak;
    }
    
    /**
     * 2.Taldearen get Partidak metodoa
     */
    @GetMapping("/partidak2")
    public List<Partida> getPartidakAlain() {
        List<Partida> partidak = webClientBuilder.build()
                        .get()
                        .uri("http://192.168.65.6:8080/demo/all_Partida")
                        .retrieve()
                        .bodyToFlux(Partida.class)
                        .collectList()
                        .block();
        return partidak;
    }
    
    /**
     * 3.Taldearen get Partidak metodoa
     */
    @GetMapping("/partidak3")
    public List<Partida> getPartidakPeru() {
        List<Partida> partidak = webClientBuilder.build()
                        .get()
                        .uri("http://192.168.65.12:8080/demo/get")
                        .retrieve()
                        .bodyToFlux(Partida.class)
                        .collectList()
                        .block();
        return partidak;
    }

    /**
     * 4.Taldearen get Partidak metodoa
     */
    @GetMapping("/partidak")
    public List<Partida> getPartidak() {
        List<Partida> partidak = webClientBuilder.build()
                        .get()
                        .uri("http://localhost:8080/Partidak/getPartidak")
                        .retrieve()
                        .bodyToFlux(Partida.class)
                        .collectList()
                        .block();
        return partidak;
    }

    public List<Partida> irakurriPartidak(){
        List<Partida> partidaGuztiak = new ArrayList<>();

        //partidaGuztiak.addAll(getPartidakMarkel()); //1.Taldea
        //partidaGuztiak.addAll(getPartidakAlain());  //2.Taldea
       // partidaGuztiak.addAll(getPartidakPeru());   //3.Taldea

        List<Partida> partida = getPartidak();
        partidaGuztiak.addAll(partida);       //4.Taldea

        return partidaGuztiak;
    }

}
