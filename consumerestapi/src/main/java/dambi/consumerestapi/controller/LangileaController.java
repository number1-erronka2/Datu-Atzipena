package dambi.consumerestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dambi.consumerestapi.domainObjects.Langilea;
import dambi.consumerestapi.repositories.LangileaRepository;
import dambi.consumerestapi.repositories.MongoLangileakRepo;

@RestController
@RequestMapping(path = "/mongoConsumerLangilea") 
public class LangileaController {

    @Autowired
    private MongoLangileakRepo mongoLangileakRepo;

    //private LangileaRepository langileaRepository;

    @GetMapping("/langileak")
    public List<Langilea> getLangileak() {
        return mongoLangileakRepo.findAll();
    }
}
