package dambi.accessingmongoumeak.model;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@XmlRootElement
public class Partida {

    int id;
    int puntuazioa;
    Date data;
    String jokoIzena;

    Langilea langilea;

    @Override
    public String toString() {
        return String.format("Partida[ID:" + this.getId() + ", Langilea:" + this.getLangilea() + ", Jokoa:" + this.getJokoIzena() + ", Puntuazioa: " +
                this.getPuntuazioa() + ", Data: " + this.getData() + "]");
    }

}