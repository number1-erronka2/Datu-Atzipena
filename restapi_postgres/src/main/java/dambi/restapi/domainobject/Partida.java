package dambi.restapi.domainobject;

import java.util.Date;

import javax.persistence.*;

@Entity(name = "partida")
@Table(name = "partida")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "langilea", referencedColumnName = "User")
    private Langilea langilea;

    @Column(name = "Puntuazioa")
    private float puntuazioa;

    @Column(name = "Data")
    private Date data;

    public Integer getId() {
        return id;
    }

    public Langilea getLangilea() {
        return langilea;
    }

    public float getPuntuazioa() {
        return puntuazioa;
    }

    public Date getData() {
        return data;
    }
}
