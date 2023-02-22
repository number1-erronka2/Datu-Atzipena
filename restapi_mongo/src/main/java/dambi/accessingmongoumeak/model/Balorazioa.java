package dambi.accessingmongoumeak.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@XmlRootElement
public class Balorazioa {
    private String jokoa;
    private String erabiltzailea;
    private int puntuazioa;
    private String komentarioa;
}

