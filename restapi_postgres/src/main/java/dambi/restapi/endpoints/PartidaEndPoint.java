package dambi.restapi.endpoints;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dambi.restapi.dbservices.*;
import dambi.restapi.domainobject.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/Partidak")
public class PartidaEndPoint {
    @Autowired
    private PartidaRepository partidaRepository;
    @Autowired
    private LangileaRepository langileaRepository;

    @GetMapping(value = "/getPartidak")
    public Iterable<Partida> getPartidaDenak() {
        Iterable<Partida> partidak = null;
        try {
            partidak = partidaRepository.findAll();
        } catch (Exception e) {
            System.out.println("Ezin izan dira partidak bistaratu: " + e);
            return null;
        }
        return partidak;
    }

    @PostMapping(value = "/partidaBerria")
    public @ResponseBody Partida addPartidaBerria(@RequestParam String langileaName, @RequestParam float puntuazioa) {
        Partida partida = new Partida();
        Langilea langilea = new Langilea();

        try {
            langilea = langileaRepository.findByIzena(langileaName);
        } catch (Exception e) {
            System.out.println("Langilea ez da aurkitu");
        }

        try {
            partida.setLangilea(langilea);
            partida.setPuntuazioa(puntuazioa);
            partida.setData(new Date());
            partidaRepository.save(partida);

        } catch (Exception e) {
            System.out.println("Ezin izan dira partidako datuak gorde");
        }
        return partida;
    }

    @DeleteMapping(value = "/partidaEzabatu")
    public @ResponseBody Partida deletePartida(@RequestParam int id) {
        Partida partida = new Partida();
        try {
            partida = partidaRepository.findById(id);
            partidaRepository.delete(partida);
        } catch (Exception e) {
            System.out.println("Ezin izan da partida ezabatu: " + e);
            return null;
        }
        return partida;
    }

    /**
     * Partida baten puntuazioa aldatzen du.
     */
    @PutMapping(value = "/partidaAldatu")
    public @ResponseBody Partida updatePartida(@RequestParam int id, @RequestParam float puntuazioa) {
        Partida partida = new Partida();
        try{
            partida = partidaRepository.findById(id);
        } catch(Exception e){
            System.out.println("Partida ez da aurkitu");
        }

        try {
            partida.setPuntuazioa(puntuazioa);
            partidaRepository.save(partida);
        } catch (Exception e) {
            System.out.println("Ezin izan dira partidako datuak gorde");
        }
        return partida;
    }
}
