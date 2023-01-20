package dambi.restapi.endpoints;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dambi.restapi.dbservices.*;
import dambi.restapi.domainobject.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/Partidak")
public class PartidaEndPoint {
    @Autowired
    private PartidaRepository partidaRepository;
    @Autowired
    private LangileaRepository langileaRepository;

    @GetMapping(value = "/getPartidak")
    public Iterable<Partida> getPartidaDenak() {
        Iterable<Partida> partidak = partidaRepository.findAll();
        return partidak;
    }

    @PostMapping(value = "/partidaBerria")
    public @ResponseBody Partida addPartidaBerria( @RequestParam String langileaName, @RequestParam float puntuazioa){
        Partida partida = new Partida();
        Langilea langilea = new Langilea();
        langilea = langileaRepository.findByIzena(langileaName);

        try {
            partida.setLangilea(langilea);
            partida.setPuntuazioa(puntuazioa);
            partida.setData(new Date());
            partidaRepository.save(partida);
            
        } catch (Exception e) {
        }
        return partida;
    }
}
