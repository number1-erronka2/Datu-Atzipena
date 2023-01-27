package dambi.restapi.domainobject;


import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "langilea")
@Table(name = "langilea")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  //JSON serialization error not to show 
public class Langilea {

    @Column (name = "email")
    private String email;

    @Column (name = "izena")
    private String izena;

    @Id
    @Column (name = "erabiltzailea")
    private String erabiltzailea;

    @Column (name = "jaiotzedata")
    private Date jaiotzedata;

    @Column (name = "taldea")
    private int taldea;


    public String getIzena() {
        return izena;
    }

    public String getEmail() {
        return email;
    }

    public Date getJaiotzedata() {
        return jaiotzedata;
    }

    public int getTaldea() {
        return taldea;
    }

    public String getErabiltzailea() {
        return erabiltzailea;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void setJaiotzedata(Date jaiotzedata) {
        this.jaiotzedata = jaiotzedata;
    }

    public void setTaldea(int taldea) {
        this.taldea = taldea;
    }

    public void setErabiltzailea(String erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }
    

}