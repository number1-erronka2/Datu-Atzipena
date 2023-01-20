package dambi.consumerestapi.domainObjects;

import java.util.Date;

public class Langilea {

    private String emaila;

    private String izena;

    private String erabiltzailea;

    private Date jaiotzeData;

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