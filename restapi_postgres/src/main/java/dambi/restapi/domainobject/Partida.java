package dambi.restapi.domainobject;

import java.util.Date;

import javax.persistence.*;

@Entity(name = "partida")
@Table(name = "partida")
public class Partida {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "erabiltzailea", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Langilea langilea;

    @Column(name = "puntuazioa")
    private float puntuazioa;

    @Column(name = "data")
    private Date data;

    public int getId() {
        return id;
    }

    public float getPuntuazioa() {
        return puntuazioa;
    }

    public Date getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPuntuazioa(float puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Langilea getLangilea() {
        return langilea;
    }

    public void setLangilea(Langilea langilea) {
        this.langilea = langilea;
    }

}
