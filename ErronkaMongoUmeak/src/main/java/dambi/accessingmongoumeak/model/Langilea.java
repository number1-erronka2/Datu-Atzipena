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
public class Langilea {

    int taldea;
    String email;
    String izena;
    String erabiltzailea;
    Date jaiotzedata;

    @Override
    public String toString() {
        return "Langilea[E-mail:" + this.getEmail() + ", izena: " + this.getIzena() + ", user:"
                + this.getErabiltzailea()
                + ", jaiotza-data:" + this.getJaiotzedata() + ", taldea:" + this.getTaldea() + "]";
    }

}
