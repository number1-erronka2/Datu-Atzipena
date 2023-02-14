package dambi.domainObjects;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Langilea {

    private String email;

    private String izena;

    private String erabiltzailea;

    private Date jaiotzadata;

    private int taldea;
}