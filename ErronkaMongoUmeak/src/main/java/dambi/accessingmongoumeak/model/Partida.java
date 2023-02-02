package dambi.accessingmongoumeak.model;

import java.util.Date;

public class Partida {

    int id, puntuazioa;
    Date data;
    
    Langilea langilea;


    public int getId(){
       return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(int puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Langilea getLangilea(){
        return langilea;
    }

    public void  setLangilea(Langilea langilea){
        this.langilea = langilea;
    }

    @Override
    public String toString() { 
        return String.format("Partida[ID:" + this.getId() + ", Langilea:" + this.getLangilea() + ", Puntuazioa: " + 
        this.getPuntuazioa() + ", Data: " + this.getData() + "]");
    }

}