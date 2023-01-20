package dambi.restapi.domainobject;


import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "langilea")
@Table(name = "langilea")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  //JSON serialization error not to show 
public class Langilea {

    @Column (name = "email")
    private String emaila;

    @Column (name = "izena")
    private String izena;

    @Id
    @Column (name = "erabiltzailea")
    private String erabiltzailea;

    @Column (name = "jaiotzedata")
    private Date jaiotzeData;

    @Column (name = "taldea")
    private int taldea;


    public String getIzena() {
        return izena;
    }

    public String getEmaila() {
        return emaila;
    }

    public Date getJaiotzeData() {
        return jaiotzeData;
    }

    public int getTaldea() {
        return taldea;
    }

    public String getErabiltzailea() {
        return erabiltzailea;
    }

    public void setEmaila(String emaila) {
        this.emaila = emaila;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void setJaiotzeData(Date jaiotzeData) {
        this.jaiotzeData = jaiotzeData;
    }

    public void setTaldea(int taldea) {
        this.taldea = taldea;
    }

    public void setErabiltzailea(String erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }
    

}