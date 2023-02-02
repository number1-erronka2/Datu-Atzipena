package dambi.accessingmongoumeak.model;

import java.util.Date;

public class Langilea {

    int taldea;
    String email, izena, erabiltzailea;
    Date jaiotzedata;

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getErabiltzailea() {
        return erabiltzailea;
    }

    public void setErabiltzailea(String erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }

    public Date getJaiotzedata() {
        return jaiotzedata;
    }

    public void setJaiotzedata(Date jaiotzedata) {
        this.jaiotzedata = jaiotzedata;
    }


    public int getTaldea() {
        return taldea;
    }

    public void setTaldea(int taldea) {
        this.taldea = taldea;
    }


    @Override
    public String toString() {
        return "Langilea[E-mail:" + this.getEmail() + ", izena: " + this.getIzena() + ", user:" + this.getErabiltzailea() 
        + ", jaiotza-data:" + this.getJaiotzedata() + ", taldea:" + this.getTaldea() + "]";
    }

}
