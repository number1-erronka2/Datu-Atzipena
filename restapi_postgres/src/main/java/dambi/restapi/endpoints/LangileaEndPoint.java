package dambi.restapi.endpoints;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@RequestMapping("/Langileak")
public class LangileaEndPoint {
    @Autowired
    private LangileaRepository langileaRepository;

    @GetMapping(value = "/getLangileak")
    public Iterable<Langilea> getLangileDenak() {
        Iterable<Langilea> langileak = langileaRepository.findAll();
        return langileak;
    }

    /**
     * Langilea gehitu. IMPORTANTEA Langilea berri bat gehitzeko,
     * Odoo-ko erabiltzaileen artean email berdina duen bat egon behar da.
     * 
     * @param langilea
     * @return
     * @throws ParseException
     */
    @PostMapping(value = "/langileBerria")
    public @ResponseBody Langilea addLangileBerria(@RequestParam String email, @RequestParam String user,
            @RequestParam String izena, @RequestParam String jaiotzeData, @RequestParam int taldea)
            {
        Langilea langilea = new Langilea();

        try {
            Date jaiotzedata = new SimpleDateFormat("yyyy-MM-dd").parse(jaiotzeData);
            langilea.setEmail(email);
            langilea.setErabiltzailea(user);
            langilea.setIzena(izena);
            langilea.setJaiotzedata(jaiotzedata);
            langilea.setTaldea(taldea);
            langileaRepository.save(langilea);
        } catch (Exception e) {
            return null;
        }
        return langilea;
    }

    @DeleteMapping(value = "/langileaEzabatu")
    public @ResponseBody Langilea deleteLangilea(@RequestParam String erabiltzailea) {
        Langilea langilea = langileaRepository.findByErabiltzailea(erabiltzailea);
        langileaRepository.delete(langilea);
        return langilea;
    }

    /**
     * Langilea aldatu. Langilearen izena, jaiotze data eta taldea aldatu daitezke.
     * Langilea erabiltzailearen bidez topatzen da.
     */
    @PutMapping(value = "/langileaAldatu")
    public @ResponseBody Langilea updateLangilea(@RequestParam String erabiltzailea,
            @RequestParam String izena, @RequestParam String jaiotzeData, @RequestParam int taldea) {
        Langilea langilea = langileaRepository.findByErabiltzailea(erabiltzailea);
        try {
            Date jaiotzedata = new SimpleDateFormat("yyyy-MM-dd").parse(jaiotzeData);
            langilea.setIzena(izena);
            langilea.setJaiotzedata(jaiotzedata);
            langilea.setTaldea(taldea);
            langileaRepository.save(langilea);
        } catch (Exception e) {
            return null;
        }
        return langilea;
    }

}
