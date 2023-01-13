package dambi.restapi.domainobject;


import java.util.Date;

import javax.persistence.*;

@Entity(name = "langilea")
@Table(name = "langilea")
public class Langilea {
    @Id
    @Column (name = "User")
    private String user;

    @Column (name = "E-mail")
    private String emaila;

    @Column (name = "Izena")
    private String izena;

    @Column (name = "Jaiotze-data")
    private Date jaiotzeData;

    @Column (name = "Taldea")
    private int taldea;

    public String getUser() {
        return user;
    }

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


}