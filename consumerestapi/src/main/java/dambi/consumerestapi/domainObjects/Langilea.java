package dambi.consumerestapi.domainObjects;

import java.util.Date;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Langilea {

    private String email;

    private String izena;

    @Id
    private String erabiltzailea;

    private Date jaiotzedata;

    private int taldea;
}