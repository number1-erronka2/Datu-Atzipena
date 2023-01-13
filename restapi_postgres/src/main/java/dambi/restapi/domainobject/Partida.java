package dambi.restapi.domainobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Puntuak")
    private int puntuak;

    @Column(name = "Data")
    private Date data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Langilea", referencedColumnName = "login")
    private Langilea langilea;

    public Integer getId() {
        return id;
    }

    public int getPuntuak() {
        return puntuak;
    }

    public Date getData() {
        return data;
    }
    

    public Langilea getLangilea() {
        return langilea;
    }
    
}
