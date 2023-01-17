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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
            langilea.setEmaila(email);
            langilea.setErabiltzailea(user);
            langilea.setIzena(izena);
            langilea.setJaiotzeData(jaiotzedata);
            langilea.setTaldea(taldea);
            langileaRepository.save(langilea);
        } catch (Exception e) {
            return null;
        }
        return langilea;
    }

}
