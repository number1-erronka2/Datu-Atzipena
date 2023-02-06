package dambi.consumerestapi.controller;

import java.util.List;
import java.util.Arrays;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {
    
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/langileak")
    public List<Object> getLangileak() {
        String url = "http://localhost:8080/Langileak/getLangileak";
        Object[] langileak = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(langileak);
    }

    @GetMapping("/partidak")
    public List<Object> getPartidak() {
        String url = "http://localhost:8080/Partidak/getPartidak";
        Object[] partidak = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(partidak);
    }

    /*
     * 3.Taldearen get Partidak metodoa
     */
    @GetMapping("/partidak3")
    public List<Object> getPartidakPeru() {
        String url = "http://192.168.65.12:8080/demo/get";
        Object[] partidak = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(partidak);
    }
}