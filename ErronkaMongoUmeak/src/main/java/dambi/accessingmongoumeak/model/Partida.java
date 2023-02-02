package dambi.accessingmongoumeak.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partida {

    int id;
    int puntuazioa;
    Date data;
    
    Langilea langilea;


    @Override
    public String toString() { 
        return String.format("Partida[ID:" + this.getId() + ", Langilea:" + this.getLangilea() + ", Puntuazioa: " + 
        this.getPuntuazioa() + ", Data: " + this.getData() + "]");
    }

}