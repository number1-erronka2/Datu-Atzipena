package dambi.domainObjects;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partida {

    private int id;

    private Langilea langilea;

    private float puntuazioa;

    private Date data;

    private String jokoIzena;
}
