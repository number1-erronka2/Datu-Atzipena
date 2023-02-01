package dambi.consumerestapi.domainObjects;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partida {

    private Integer id;

    private Langilea langilea;

    private float puntuazioa;

    private Date data;
}
