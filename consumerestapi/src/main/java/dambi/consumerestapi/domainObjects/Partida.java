package dambi.consumerestapi.domainObjects;

import java.util.Date;

public class Partida {

    private Integer id;

    private Langilea langilea;

    private float puntuazioa;

    private Date data;

    public Integer getId() {
        return id;
    }

    public float getPuntuazioa() {
        return puntuazioa;
    }

    public Date getData() {
        return data;
    }

    public void setId(Integer id) {
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
