package dambi.restapi.domainobject;


import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter, toString, equals
@NoArgsConstructor //automatically generates a constructor with no parameters
@AllArgsConstructor //automatically generates a constructor with all parameters
@Entity(name = "langilea")
@Table(name = "langilea")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  //JSON serialization error not to show 
public class Langilea {

    @Column (name = "email")
    private String email;

    @Column (name = "izena")
    private String izena;

    @Id //primary key
    @Column (name = "erabiltzailea")
    private String erabiltzailea;

    @Column (name = "jaiotzadata")
    private Date jaiotzadata;

    @Column (name = "taldea")
    private int taldea;
}